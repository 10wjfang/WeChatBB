package com.fang.domain;

/**
 * @Author: fwj
 * @Description:
 * @Date: Created in 2018/8/21 17:11
 * @Modified by:
 */
public class ArticleItem {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getPicUrl() {
        return PicUrl;
    }
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
    public String getUrl() {
        return Url;
    }
    public void setUrl(String url) {
        Url = url;
    }
}
