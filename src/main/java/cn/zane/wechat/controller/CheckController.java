package cn.zane.wechat.controller;

import cn.zane.wechat.model.CheckWechatServer;
import cn.zane.wechat.model.ResponseMessage.TextMessage;
import cn.zane.wechat.model.WeixinOauth2Token;
import cn.zane.wechat.model.entity.TWeixinuserEntity;
import cn.zane.wechat.service.impl.CoreServiceImpl;
import cn.zane.wechat.util.AuthoInterface;
import cn.zane.wechat.util.MessageUtil;
import cn.zane.wechat.util.SignUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by zane on 2016/10/27.
 */
@Controller
public class CheckController {

	@Autowired
	private CoreServiceImpl coreServiceImpl;
	/**
	 * 确认请求来自微信服务器
	 */
	@RequestMapping(value = "/CheckRequest",method = RequestMethod.GET)
	public @ResponseBody String CheckRequest(CheckWechatServer checkRequest , ModelMap modelMap) {
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
			return checkRequest.getEchostr();
		}
		return "";
	}

/*	@RequestMapping(value = "/CheckRequest",method = RequestMethod.POST)
	public @ResponseBody String getMessageFromWechat(CheckWechatServer checkRequest , HttpServletRequest request, ModelMap modelMap) throws IOException, DocumentException {
		request.setCharacterEncoding("utf-8");
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
			String respXml = processRequest(request);
			return respXml;
		}
		return "";
	}*/

	/**
	 * 获取用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/auth2access" ,method = RequestMethod.GET)
	public String oath(HttpServletRequest request) throws ParseException {
		String code = request.getParameter("code");
		if (!"authodeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AuthoInterface.getOauth2AccessToken("wx0b1ecd19f255e28a", "e27fae4020b4542ee38ed76691d7e410", code);
			// 用户标识
			String openId = weixinOauth2Token.getOpenId();
			// 获取用户信息
			TWeixinuserEntity weixinUserInfo = null;
			String accessToken = weixinOauth2Token.getAccessToken();
			weixinUserInfo = AuthoInterface.getWeixinUserInfo(accessToken, openId);
			// 设置要传递的参数
			request.setAttribute("weixinUserInfo", weixinUserInfo);
		}
		// 跳转到index.jsp
        return "index";
	}


}
