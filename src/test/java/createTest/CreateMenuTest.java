package createTest;

import cn.zane.wechat.model.button.*;
import cn.zane.wechat.util.CommonUtil;
import net.sf.json.JSONObject;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by zane on 2016/10/27.
 */
public class CreateMenuTest {
	// 菜单创建（POST）
	public final static String menu_create_url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		ViewButton btn1 = new ViewButton();
		btn1.setType("view");
		btn1.setName("VR平台");
		btn1.setUrl("www.baidu.com");

		ClickButton btn2 = new ClickButton();
		btn2.setType("click");
		btn2.setName("活动链接");
		btn2.setKey("activities");

		ClickButton btn31 = new ClickButton();
		btn31.setType("click");
		btn31.setName("联系我们");
		btn31.setKey("contactOur");

		ClickButton btn32 = new ClickButton();
		btn32.setType("click");
		btn32.setName("关于");
		btn32.setKey("about");
		ComplexButton btn3 = new ComplexButton();
		btn3.setName("关于我们");
		btn3.setSub_button(new Button[] {btn31,btn32});

		Menu menu = new Menu();

		menu.setButton(new Button[]{btn1,btn2,btn3});
//		String jsonMenu = JSONObject.fromObject(menu).toString();
		String jsonMenu = "{\"button\":[{\"type\":\"view\",\"name\":\"VR平台\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0b1ecd19f255e28a&redirect_uri=http://zane197.iok.la/myspring/auth2access&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect\"},{\"type\":\"click\",\"name\":\"活动链接\",\"key\":\"activities\"},{\"name\":\"关于我们\",\"sub_button\":[{\"type\":\"click\",\"name\":\"联系我们\",\"key\":\"contactOur\"},{\"type\":\"click\",\"name\":\"关于\",\"key\":\"about\"}]}]}";
		boolean result = false;
		String accessToken = CommonUtil.getToken("wx0b1ecd19f255e28a", "e27fae4020b4542ee38ed76691d7e410").getAccessToken();
		System.out.println(accessToken);
//		String	accessToken = "fBHEH7y0fgmJPiQTpbPUw0nWXz8CLJKECMWbMeHD32B8cp7LJRhn1LEsfK_GzGCjsN0M-jgP9adD48cMBmt3tov_dWOtf-j3FwEmIIjBE46dd4AJGJ1CI4Z9OkivwnvNIQPjAHAMUT";

//		菜单创建接口地址
		String menuCreateUrl = menu_create_url.replace("ACCESS_TOKEN", accessToken);
//		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(menuCreateUrl, "POST", jsonMenu);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			System.out.println();
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				System.out.println("创建菜单失败 errcode:{} errmsg:{}"+ errorCode+"+++"+ errorMsg);
			}
		}
	}
}
