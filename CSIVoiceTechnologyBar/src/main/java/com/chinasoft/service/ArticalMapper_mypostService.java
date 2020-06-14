package com.chinasoft.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Article;

public interface ArticalMapper_mypostService {

	List<Article> FindmyAllByLimit(Map map);
	void addmyArticle(Article article);
	List<Article> FindmyByPar(Map map);
	List<Article> FindmyByParByLimit(Map map);
	void deletemyArticle(int a_id);
	List<Article> FindmyAll(String username);
	int selectLastmyArticle();
}
