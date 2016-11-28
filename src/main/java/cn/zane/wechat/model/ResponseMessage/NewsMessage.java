package cn.zane.wechat.model.ResponseMessage;


import cn.zane.wechat.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * 回复图文消息
 * @author zane
 *
 */
public class NewsMessage {
	
	
//	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	private int articleCount;
//	图文消息个数，限制为10条以内
	List<Article> articles = new ArrayList<Article>();

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
 
}
