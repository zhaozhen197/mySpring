package cn.zane.wechat.model;

/**
 * 网页授权信息
 *
 * Created by zane on 2016/11/20.
 */
public class WeixinOauth2Token {
    //网页授权接口调用凭证
    private String accessToken;
    //    凭证有效时延
    private int expiresIn;
    // 用于刷新凭证
    private String refreshToken;
    // 用户唯一标识
    private String openId;
    // 用户授权作用域
    private String scope;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expirsIn) {
        this.expiresIn = expirsIn;
    }


    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "WeixinOauth2Token{" +
                "accessToken='" + accessToken + '\'' +
                ", expirsIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", openId='" + openId + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
