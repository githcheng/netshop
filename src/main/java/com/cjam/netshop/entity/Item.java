package com.cjam.netshop.entity;

import java.util.List;

/**
 * Created by jam on 2017/8/13.
 */
public class Item {

    private long itemId;
    private String imageUrl = null;
    private String desc;
    private String title;
    private Integer type;

    private List<String> swiperImageUrl = null;
    private List<String> infoImageUrl = null;

    private Long onePrice = null;
    private Long truePrice = null;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
