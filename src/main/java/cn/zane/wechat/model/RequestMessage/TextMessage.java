package cn.zane.wechat.model.RequestMessage;

/**
 * 文本消息
 * @author zane
 *
 */
public class TextMessage extends RequestBaseMessage {
//	消息内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
