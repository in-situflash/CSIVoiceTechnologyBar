package com.chinasoft.mapper;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Article;

public interface ArticleMapper_mypost {

	List<Article> selectAllmyArticleByLimit(Map map);
	List<Article> selectmyArticleByPar(Map map);
	List<Article> selectmyArticleByParByLimit(Map map);
	void insertmyArticle(Article article);
	void deletemyArticle(int a_id);
	List<Article> selectAllmyArticle(String username);
	int selectLastmyArticle();
}
