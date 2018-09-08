package com.fang.domain;

/**
 * @Author: fwj
 * @Description:
 * @Date: Created in 2018/9/6 13:48
 * @Modified by:
 */
public class AccessToken {
    private String access_token;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
