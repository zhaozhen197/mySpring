/**
 * 
 */
package cn.zane.wechat.model.ResponseMessage;


import cn.zane.wechat.model.Voice;

/**
 * @author zane
 *回复语音消息
 */
public class VoiceMessage extends ResponseBaseMessage {
	
	//回复语音
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
}
