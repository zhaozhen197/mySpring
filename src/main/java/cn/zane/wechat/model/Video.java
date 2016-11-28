/**
 * 
 */
package cn.zane.wechat.model;

/**
 * @author zane
 *视频
 */
public class Video {
//	通过素材管理中的接口上传多媒体文件，得到的id
	private String mediaId;
//	视频消息的标题
	private String title;
//	视频消息的描述
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

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
	
	

}
