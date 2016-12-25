package cn.zane.wechat.service.impl;

/**
 * Created by zane on 2016/11/26.
 */

import cn.zane.wechat.model.ResponseMessage.TextMessage;
import cn.zane.wechat.util.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 核心服务类
 * @author zane
 *
 */
@Service
public class CoreServiceImpl {

    /**
     * 处理微信服务器发来的请求
     * @param request
     * @return xml
     * @throws DocumentException
     * @throws IOException
     */
    public String processRequest(HttpServletRequest request) throws IOException, DocumentException {
        //xml格式的消息数据
        String respXml = null;
//		默认返回的文本消息内容
        String respContent = "初始消息";
//		调用parseXml
        Map<String, String> requestMap = MessageUtil.parseXml(request);
//		发送方账户
        String fromUserName = requestMap.get("FromUserName");
//		开发者账号
        String toUserName = requestMap.get("ToUserName");
//		消息类型
        String msgType = requestMap.get("MsgType");
        String eventKey = requestMap.get("EventKey");
        System.out.println("eventkey:"+eventKey);
//		回复消息
        TextMessage textMessage = new TextMessage();

        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setCreateTime(new Date().getTime());

        //文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            respContent = "文本消息";
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            respContent = "图片消息";
        }else if (msgType .equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            respContent = "语音消息";
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
            respContent ="视频消息";
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            respContent ="位置消息";
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            respContent = "链接消息";
        }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//			事件类型
            String eventType = requestMap.get("Event");
            System.out.println(eventType);
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                respContent = "谢谢你的关注！";
            }else if (eventType.equals(MessageUtil.EVENT_TYPE_NSUBSCRIBE)) {
//				respContent =""
            }else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
//				TODO 处理二维码事件
            }else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                //TODO
            }else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                //TODO 处理菜单单机事件
                //事件类型

                if (eventKey.equals("activities")){
                    respContent = "活动链接";
                } else if (eventKey.equals("contactOur")) {
                    respContent = "联系我们";
                }else if (eventKey.equals("about")){
                    respContent = "关于";

                    //TODO 其他操作
                }
            }
        }
        //设置文本消息的内容
        textMessage.setContent(respContent);
//		将文本消息对象转换为xml
        respXml = MessageUtil.messageToXml(textMessage);
        return respXml;
    }
}

