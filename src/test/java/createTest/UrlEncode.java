package createTest;

import java.io.UnsupportedEncodingException;

import static cn.zane.wechat.util.UrlEncode.urlEncode;


/**
 * Created by zane on 2016/11/20.
 */
public class UrlEncode {

//    https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0b1ecd19f255e28a&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
    public static void main(String[] args) throws UnsupportedEncodingException {
        String tmp ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0b1ecd19f255e28a&redirect_uri="+urlEncode("http://zane197.iok.la/myspring/auth2access")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        System.out.println(tmp);
    }
}
