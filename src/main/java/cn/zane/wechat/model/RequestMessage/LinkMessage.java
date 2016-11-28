/**
 * 
 */
package cn.zane.wechat.model.RequestMessage;

/**
 * @author zane
 *
 */
public class LinkMessage {

	
	//消息标题
	private String title;
//	消息描述
	private String description;
//	消息链接
	private String Url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
	
}
