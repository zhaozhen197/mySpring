/**
 * 
 */
package cn.zane.wechat.model.RequestMessage;

/**
 * 视频消息
 * @author zane
 *
 */
public class VideoMessage extends RequestBaseMessage {
//	视频id
	private String mediaId;
//	视频缩略图id
	
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
}
