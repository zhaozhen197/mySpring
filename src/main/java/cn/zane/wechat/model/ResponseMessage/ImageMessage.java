/**
 * 
 */
package cn.zane.wechat.model.ResponseMessage;


import cn.zane.wechat.model.Image;

/**
 * @author zane
 *回复图片消息
 */
public class ImageMessage extends ResponseBaseMessage {

	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
