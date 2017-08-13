package com.cjam.netshop.service;

import com.cjam.netshop.entity.BizException;
import com.cjam.netshop.entity.Item;
import com.cjam.netshop.mapper.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jam on 2017/2/9.
 */
@Service
public class ItemService {

    @Autowired
    private ItemDAO itemDAO;

    public Item getItemById(Long id) throws BizException {

        Item item = itemDAO.getItemById(id);

        if (item == null){
            throw new BizException("商品不存在");
        }
        return item;
    }
}
