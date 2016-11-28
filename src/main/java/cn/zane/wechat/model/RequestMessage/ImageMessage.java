package cn.zane.wechat.model.RequestMessage;

/**
 * 图片消息
 * @author zane
 *
 */

public class ImageMessage extends RequestBaseMessage {
//	图片链接
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	
}
