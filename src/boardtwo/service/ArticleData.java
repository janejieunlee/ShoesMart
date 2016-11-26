package boardtwo.service;

import boardtwo.model.Article2;
import boardtwo.model.ArticleContent;

public class ArticleData {
	private Article2 article;
	private ArticleContent content;

	public ArticleData(Article2 article, ArticleContent content) {
		this.article = article;
		this.content = content;
	}

	public Article2 getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}


}
