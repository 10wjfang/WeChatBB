package com.fang.service.Impl;

import com.fang.config.WeChatContant;
import com.fang.domain.ArticleItem;
import com.fang.service.WeChatService;
import com.fang.utils.WeChatUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: fwj
 * @Description:
 * @Date: Created in 2018/8/21 17:15
 * @Modified by:
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Override
    public String processRequest(HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent;
        try {
            // 调用parseXml方法解析请求消息
            Map<String,String> requestMap = WeChatUtil.parseXml(request);
            // 消息类型
            String msgType = (String) requestMap.get(WeChatContant.MsgType);
            String mes = null;
            // 文本消息
            if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_TEXT)) {
                mes =requestMap.get(WeChatContant.Content).toString();
                if (mes.contains("博客")) {
                    List<ArticleItem> items = new ArrayList<>();
                    ArticleItem item = new ArticleItem();
                    item.setTitle("方伟俊的博客");
                    item.setDescription("知识分享");
                    item.setPicUrl("http://weijunfang.coding.me/blog/img/home-bg.jpg");
                    item.setUrl("http://weijunfang.coding.me/blog/");
                    items.add(item);
                    respXml = WeChatUtil.sendArticleMsg(requestMap, items);
                }
                else if("我的信息".equals(mes)){
//                    Map<String, String> userInfo = getUserInfo(requestMap.get(WeChatContant.FromUserName));
//                    System.out.println(userInfo.toString());
//                    String nickname = userInfo.get("nickname");
//                    String city = userInfo.get("city");
//                    String province = userInfo.get("province");
//                    String country = userInfo.get("country");
//                    String headimgurl = userInfo.get("headimgurl");
//                    List<ArticleItem> items = new ArrayList<>();
//                    ArticleItem item = new ArticleItem();
//                    item.setTitle("你的信息");
//                    item.setDescription("昵称:"+nickname+"  地址:"+country+" "+province+" "+city);
//                    item.setPicUrl(headimgurl);
//                    item.setUrl("http://www.baidu.com");
//                    items.add(item);
//
//                    respXml = WeChatUtil.sendArticleMsg(requestMap, items);
                }
            }
            // 图片消息
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
                respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
            }
            // 语音消息
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
                respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
            }
            // 视频消息
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
                respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
            }
            // 地理位置消息
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
            }
            // 链接消息
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
                respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
            }
            // 事件推送
            else if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = (String) requestMap.get(WeChatContant.Event);
                // 关注
                if (eventType.equals(WeChatContant.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！赶快和我聊天吧，新闻资讯、天气查询、" +
                            "菜谱、笑话、酒店、快递、百科、翻译等都可以问我哦";
                    respXml = WeChatUtil.sendTextMsg(requestMap, respContent);
                }
                // 取消关注
                else if (eventType.equals(WeChatContant.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(WeChatContant.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(WeChatContant.EVENT_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equals(WeChatContant.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                }
            }
            //mes = mes == null ? "不知道你在干嘛" : mes;
            //if(respXml == null)
            //    respXml = WeChatUtil.sendTextMsg(requestMap, mes);
            System.out.println(respXml);
            return respXml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
