/**
 * 
 */
package cn.zane.wechat.model.RequestMessage;

/**
 * 地理消息
 * @author zane
 *
 */
public class LocationMessage extends RequestBaseMessage {
	
	//地理纬度
	private String location_x;
	//	地理经度
	private String location_y;
	//缩略图大小
	private String scale;
	//地理位置信息
	private String lable;
	
	
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getLocation_x() {
		return location_x;
	}
	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}
	public String getLocation_y() {
		return location_y;
	}
	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	
	
}
