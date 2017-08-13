package com.cjam.netshop.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjam.netshop.entity.BizException;
import com.cjam.netshop.entity.Item;
import com.cjam.netshop.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IndexService indexService;

    @RequestMapping(value="/getIndexList",method={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    JSONObject getIndexList(HttpServletRequest request,
                        HttpServletResponse response) {

        String openid = request.getParameter("openid");

        JSONObject res = new JSONObject();
        res.put("code",0);
        try {
            logger.info("openid:{}",openid);
            List<Item> itemList = indexService.getItemListByIndex();
            JSONArray jsonList = (JSONArray)JSON.toJSON(itemList);
            res.put("data",jsonList);
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

    @RequestMapping(value="/getIndexTopList",method={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    JSONObject getIndexTopList(HttpServletRequest request,
                        HttpServletResponse response) {

        String openid = request.getParameter("openid");

        JSONObject res = new JSONObject();
        res.put("code",0);
        try {
            logger.info("openid:{}",openid);
            List<Item> itemList = indexService.getItemListByIndex();
            JSONArray jsonList = (JSONArray)JSON.toJSON(itemList);
            res.put("data",jsonList);
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
