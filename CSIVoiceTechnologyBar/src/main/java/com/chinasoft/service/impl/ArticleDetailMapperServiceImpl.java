package com.chinasoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.ArticleDetailMapper;
import com.chinasoft.pojo.ArticleDetail;
import com.chinasoft.pojo.Comment;
import com.chinasoft.service.ArticleDetailMapperService;

@Service
public class ArticleDetailMapperServiceImpl implements ArticleDetailMapperService{

	@Autowired
	ArticleDetailMapper mapper;
	
	@Override
	public ArticleDetail getAllById(int a_id) {
		ArticleDetail articleDetail = mapper.getAllById(a_id);
		return articleDetail;
	}

	public List<Comment> getCommentsByArticleId(int a_id) {
		List<Comment> comments = mapper.getCommentsByArticleId(a_id);
		return comments;
	}

	public void deleteCommentByC_id(int c_id) {
		mapper.deleteCommentByC_id(c_id);
		
	}

	public void updateLikesByC_id(int c_id) {
		mapper.updateLikesByC_id(c_id);
		
	}

	public void updateLikesByA_id(int a_id) {
		mapper.updateLikesByA_id(a_id);
		
	}

	public int selectC_likesByC_id(int c_id) {
		int c_likes = mapper.selectC_likesByC_id(c_id);
		return c_likes;
	}

	public int selectA_likesByA_id(int a_id) {
		int a_likes = mapper.selectA_likesByA_id(a_id);
		return a_likes;
	}

}
