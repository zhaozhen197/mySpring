
package cn.zane.wechat.util;

import cn.zane.wechat.model.Article;
import cn.zane.wechat.model.ResponseMessage.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

/**
 * @author zane
 *
 */
public class MessageUtil {

//	请求消息类型 文本
	public static final String  REQ_MESSAGE_TYPE_TEXT = "text";
//	请求消息类型 图片
	public static final String  REQ_MESSAGE_TYPE_IMAGE = "image";
//	请求消息类型 音频
	public static final String  REQ_MESSAGE_TYPE_VOICE = "voice";
//	请求消息类型 视频
	public static final String  REQ_MESSAGE_TYPE_VIDEO = "video";
//	请求消息类型 位置
	public static final String  REQ_MESSAGE_TYPE_LOCATION = "location";
//	请求消息类型 链接
	public static final String  REQ_MESSAGE_TYPE_LINK = "link";
//	请求消息类型 事件
	public static final String  REQ_MESSAGE_TYPE_EVENT = "event";
	
	
//	事件类型 订阅
	public static final String  EVENT_TYPE_SUBSCRIBE = "SUBSCRIBE";
//	事件类型  取消订阅
	public static final String  EVENT_TYPE_NSUBSCRIBE = "UNSUBSCRIBE";
//	scan （扫描带参数二维码）
	public static final String EVENT_TYPE_SCAN = "SCAN";
//上报地理位置
	public static final String EVENT_TYPE_LOCATION = "LOCATRION";
//	自定义菜单
	public static final String EVENT_TYPE_CLICK = "CLICK";
	
	
	//响应类型：文字消息
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	//响应类型：图片消息
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	//响应类型：语音消息
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	//响应类型：视频消息
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	//响应类型：音乐消息
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	//响应类型：图文消息
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	
	/**
	 * 解析微信发来的请求
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
		
		/**
		 * 将解析结果存储在HashMap
		 */
		Map<String, String> map = new HashMap<String, String>();
//		从rquest中获取输入流
		InputStream inputStream = request.getInputStream();
//		读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
//		获取xml根节点
		Element root = document.getRootElement();
//		得到所有结点
		List<Element> elements = root.elements();
		
//		遍历所有子节点
		for (Element element : elements) {
			map.put(element.getName(), element.getText());
		}
		//释放资源
		inputStream.close();

		return map;
	}
	

	/**
	 * 扩展xstream 使其支持CDATA
	 */
	private static XStream xstream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out){
//				对所有的xml结点的转换都增加CData标记
				boolean cdata = true;
				
				public void startNode(String name,Class clazz){
					super.startNode(name,clazz);

					if(name.equals("CreateTime")){

						cdata = false;

					}else {
						cdata = true;
					}
				}
				
				protected void writeText(QuickWriter writer, String text)
				{
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
	});
	
	/**
	 * 文本消息对象转换为Xml
	 * @param textMessage
	 * @return xml
	 */
	public static String messageToXml(TextMessage textMessage){
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 语音消息转换为xml
	 * @param voiceMessage
	 * @return
	 */
	public static String messageToXml(VoiceMessage voiceMessage) {
		xstream.alias("xml",voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	
	/**
	 * 视频消息转换为xml
	 * @param videoMessage
	 * @return
	 */
	public static String messageToXml(VideoMessage videoMessage) {
		xstream.alias("xml",videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
	
	/**
	 *音乐消息转换为xml
	 * @param musicMessage
	 * @return
	 */
	public static String messageToXml(MusicMessage musicMessage) {
		xstream.alias("xml",musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * 图文消息对象转换xml
	 * @param newsMessage
	 * @return
	 */
	public static String messageToXml(NewsMessage newsMessage) {
		xstream.alias("xml",newsMessage.getClass());
		xstream.alias("xml",new Article().getClass());
		return xstream.toXML(newsMessage);
	}
}
