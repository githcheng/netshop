package com.cjam.netshop.service;

import com.cjam.netshop.entity.BizException;
import com.cjam.netshop.entity.Item;
import com.cjam.netshop.mapper.ItemDAO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jam on 2017/2/9.
 */
@Service
public class IndexService {

    @Autowired
    private ItemDAO itemDAO;

    public List<Item> getItemListByIndex() throws BizException {

        List<Item> courseLogList = itemDAO.getItemList();

        if (CollectionUtils.isEmpty(courseLogList)){
            throw new BizException("您最近没有要学习的课程");
        }
        return courseLogList;
    }
}
