package cn.zane.wechat.controller;

import cn.zane.wechat.model.CheckWechatServer;
import cn.zane.wechat.model.SNSUserInfo;
import cn.zane.wechat.model.WeixinOauth2Token;
import cn.zane.wechat.service.CoreService;
import cn.zane.wechat.util.AuthoInterface;
import cn.zane.wechat.util.SignUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zane on 2016/10/27.
 */
@Controller
public class CheckController {

	@Autowired
	private CoreService coreService;
	/**
	 * 确认请求来自微信服务器
	 */
	@RequestMapping(value = "/CheckRequest",method = RequestMethod.GET)
	public @ResponseBody String CheckRequest(CheckWechatServer checkRequest , ModelMap modelMap) {
		System.out.println(checkRequest);
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
			return checkRequest.getEchostr();
		}
		return "";
	}

	@RequestMapping(value = "/CheckRequest",method = RequestMethod.POST)
	public @ResponseBody String getMessageFromWechat(CheckWechatServer checkRequest , HttpServletRequest request, ModelMap modelMap) throws IOException, DocumentException {
		request.setCharacterEncoding("utf-8");
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
			String respXml = CoreService.processRequest(request);
			return respXml;
		}
		return "";
	}

	@RequestMapping(value = "/auth2access" ,method = RequestMethod.GET)
	public String oath(HttpServletRequest request) {
		System.out.println("code");
		String code = request.getParameter("code");

		if (!"authodeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AuthoInterface.getOauth2AccessToken("wx0b1ecd19f255e28a", "e27fae4020b4542ee38ed76691d7e410", code);
			// 网页授权接口访问凭证
			String accessToken = weixinOauth2Token.getAccessToken();
			// 用户标识
			String openId = weixinOauth2Token.getOpenId();
			// 获取用户信息
			SNSUserInfo snsUserInfo = AuthoInterface.getSNSUserInfo(accessToken, openId);

			// 设置要传递的参数
			request.setAttribute("snsUserInfo", snsUserInfo);
		}
		// 跳转到index.jsp
        return "index";
	}

}
