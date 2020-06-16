package com.chinasoft.mapper;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Article;

public interface ArticleMapper_mypost {

	List<Article> selectAllmyArticleByLimit(Map map);
	List<Article> selectmyArticleByPar(Map map);
	List<Article> selectmyArticleByParByLimit(Map map);
	void insertmyArticle(Article article);
	void deletemyArticle(Map map);
	List<Article> selectAllmyArticle(String username);
	int selectLastmyArticle();
	String selectUsernameByA_id(int a_id);
}
