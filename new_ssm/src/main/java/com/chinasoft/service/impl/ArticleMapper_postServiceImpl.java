package com.chinasoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.ArticleMapper_post;
import com.chinasoft.pojo.Article;
import com.chinasoft.service.ArticalMapper_postService;

@Service
public class ArticleMapper_postServiceImpl implements ArticalMapper_postService{

	@Autowired
	ArticleMapper_post mapper;

	@Override
	public List<Article> FindAllByLimit(Map map) {
		List<Article> article = mapper.selectAllArticleByLimit(map);
		return article;
	}
	
	
	@Override
	public List<Article> FindByPar(Map map){
		List<Article> article = mapper.selectArticleByPar(map);
		return article;
	}
	
	@Override
	public void addArticle(Article article) {
		mapper.insertArticle(article);
	}

	@Override
	public void deleteArticle(int a_id) {
		mapper.deleteArticle(a_id);
	}

	@Override
	public List<Article> FindAll() {
		List<Article> article = mapper.selectAllArticle();
		return article;
	}

	@Override
	public List<Article> FindByParByLimit(Map map) {
		List<Article> article = mapper.selectArticleByParByLimit(map);
		return article;
	}


	@Override
	public int selectLastArticle() {
		int a_id = mapper.selectLastArticle();
		return a_id;
	}
	
	

}
