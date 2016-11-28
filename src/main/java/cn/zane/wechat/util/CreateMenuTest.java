package cn.zane.wechat.util;

import cn.zane.wechat.model.button.*;
import net.sf.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by zane on 2016/10/27.
 */
public class CreateMenuTest {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		ViewButton btn1 = new ViewButton();

		btn1.setName("VR平台");
		btn1.setType("view");
		btn1.setUrl("www.baidu.com");

		ClickButton btn2 = new ClickButton();
		btn2.setName("活动链接");
		btn2.setType("click");
		btn2.setKey("activities");

		ClickButton btn31 = new ClickButton();
		btn31.setName("联系我们");
		btn31.setType("click");
		btn31.setKey("contactOur");

		ClickButton btn32 = new ClickButton();
		btn32.setName("关于");
		btn32.setType("click");
		btn32.setKey("about");
		ComplexButton btn3 = new ComplexButton();
		btn3.setName("关于我们");
		btn3.setSub_button(new Button[] {btn31,btn32});

		Menu menu = new Menu();

		menu.setButton(new Button[]{btn1,btn2,btn3});
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);

		String accessToken = CommonUtil.getToken("wx0b1ecd19f255e28a", "e27fae4020b4542ee38ed76691d7e410").getAccessToken();


//		菜单创建接口地址
		String menuCreateUrl = "https://api.weixin.qq.com/cgi-bin/create?access_token="+accessToken;
//		建立连接
		URL url = new URL(menuCreateUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//		使用自定义 的信任管理kkd
		TrustManager[] tm = { new MyX509TrustManager()};

		SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null,tm,new java.security.SecureRandom());

		SSLSocketFactory ssf = sslContext.getSocketFactory();

		httpsURLConnection .setSSLSocketFactory(ssf);
//		httpsURLConnection
	}







}
