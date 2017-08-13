package com.cjam.netshop.mapper;

import com.cjam.netshop.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jam on 2017/2/8.
 */
@Mapper
public interface ItemDAO {

    @Select("select id as itemId, image_url as imageUrl, `desc`, title,type FROM item where type = #{type}")
    List<Item> getItemList(@Param("type")Integer type);

}

