package com.chinasoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.ArticleMapper_mypost;
import com.chinasoft.pojo.Article;
import com.chinasoft.service.ArticalMapper_mypostService;

@Service
public class ArticleMapper_mypostServiceImpl  implements ArticalMapper_mypostService{

	@Autowired
	ArticleMapper_mypost mapper;

	@Override
	public List<Article> FindmyAllByLimit(Map map) {
		List<Article> article = mapper.selectAllmyArticleByLimit(map);
		return article;
	}
	
	
	@Override
	public List<Article> FindmyByPar(Map map){
		List<Article> article = mapper.selectmyArticleByPar(map);
		return article;
	}
	
	@Override
	public void addmyArticle(Article article) {
		mapper.insertmyArticle(article);
	}

	@Override
	public void deletemyArticle(int a_id) {
		mapper.deletemyArticle(a_id);
	}

	@Override
	public List<Article> FindmyAll(String username) {
		List<Article> article = mapper.selectAllmyArticle(username);
		return article;
	}

	@Override
	public List<Article> FindmyByParByLimit(Map map) {
		List<Article> article = mapper.selectmyArticleByParByLimit(map);
		return article;
	}


	@Override
	public int selectLastmyArticle() {
		int a_id = mapper.selectLastmyArticle();
		return a_id;
	}
}
