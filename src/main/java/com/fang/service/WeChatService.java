package com.fang.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: fwj
 * @Description:
 * @Date: Created in 2018/8/21 17:08
 * @Modified by:
 */
public interface WeChatService {
    String processRequest(HttpServletRequest request);
}
