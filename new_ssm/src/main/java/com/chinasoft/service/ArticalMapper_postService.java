package com.chinasoft.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Article;

public interface ArticalMapper_postService {

	List<Article> FindAllByLimit(Map map);
	void addArticle(Article article);
	List<Article> FindByPar(Map map);
	List<Article> FindByParByLimit(Map map);
	void deleteArticle(int a_id);
	List<Article> FindAll();
	int selectLastArticle();
}
