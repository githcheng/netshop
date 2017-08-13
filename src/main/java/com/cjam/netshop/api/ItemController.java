package com.cjam.netshop.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjam.netshop.entity.BizException;
import com.cjam.netshop.entity.Item;
import com.cjam.netshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jam on 2017/8/13.
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/getItemById",method={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    JSONObject getIndexList(HttpServletRequest request,
                            HttpServletResponse response) {

        String openid = request.getParameter("openid");
        String idStr = request.getParameter("id");
        Long id = idStr != null ? Long.valueOf(idStr) : 0L;
        JSONObject res = new JSONObject();
        res.put("code",0);
        try {
            logger.info("id:{}",id);

            Item item = itemService.getItemById(id);
            JSONObject itemObj = (JSONObject)JSON.toJSON(item);
            final JSONObject infoImage = new JSONObject(){{
                put("url","http://oum9qkqsg.bkt.clouddn.com/index_ppt_001.jpg");
            }};


            itemObj.put("onePrice", "99.00");
            itemObj.put("truePrice", "267.00");
            itemObj.put("specLst",new JSONObject(){{
                put("value",123);
                put("text","25g/ml （6片装）");
            }});
            itemObj.put("infoImageUrls",new JSONArray(){{
                add(infoImage);
                add(infoImage);
                add(infoImage);
                add(infoImage);
            }});

            itemObj.put("swiperImageUrls",new JSONArray(){{
                add(infoImage);
                add(infoImage);
                add(infoImage);
                add(infoImage);
            }});
            itemObj.put("info","`薰衣草对肌肤有很好的调整效果，增强皮肤对环境影响的防护力，全面排出肌肤表面与积累在毛孔中的老废物杂质，" +
                    "唤醒明亮的健康美肌，使用薰衣草面膜后肌肤变得更明亮、润泽和更有弹性；" +
                    "薰衣草面膜能增加肌肤的保水性，使肌肤的保湿效果增大，因而促使肌肤更显亮丽且不易产生过敏反应；" +
                    "增加肌肤的紧缩性及弹性，使松弛的肌肤回复年轻状态，并可因此达到去除皱纹的目的。" +
                    "因保水性及紧缩性的双重作用，薰衣草面膜可改善干性及油性肌肤的分泌状态，使之渐趋于中性肌肤，" +
                    "并促使毛细孔收缩细致。电脑辐射、油脂分泌过剩造成毛孔粗大，使用后平复");
            res.put("data",itemObj);
        } catch (BizException e) {
            logger.error(e.getMessage(),e);
            res.put("code",1);
            res.put("msg", e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            res.put("code",1);
            res.put("msg", "服务异常");
        } finally {
            return res;
        }
    }
}
