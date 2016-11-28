package cn.zane.wechat.model.RequestMessage;

/**
 * 语音消息
 * @author zane
 *
 */
public class VoiceMessage extends RequestBaseMessage {

	/**
	 * 媒体id
	 */
	private String mediaId;
//	媒体格式
	private String format;
//	语音识别结果 utf-8
	private String recognition;
	
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
	
	
}
