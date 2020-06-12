package com.chinasoft.mapper;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Article;

public interface ArticleMapper_post {

	List<Article> selectAllArticleByLimit(Map map);
	List<Article> selectArticleByPar(Map map);
	List<Article> selectArticleByParByLimit(Map map);
	void insertArticle(Article article);
	void deleteArticle(int a_id);
	List<Article> selectAllArticle();
}

