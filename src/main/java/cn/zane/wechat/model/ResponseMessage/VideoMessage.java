/**
 * 
 */
package cn.zane.wechat.model.ResponseMessage;


import cn.zane.wechat.model.Video;

/**
 * @author zane
 *回复视频消息
 */
public class VideoMessage extends ResponseBaseMessage {
	
//	视频】
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	
	
}
