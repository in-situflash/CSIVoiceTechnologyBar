package com.chinasoft.service;

import java.util.List;

import com.chinasoft.pojo.ArticleDetail;
import com.chinasoft.pojo.Comment;
import com.chinasoft.pojo.audioSet;

public interface ArticleDetailMapperService {
	
	ArticleDetail getAllById(int a_id);
	
	List<Comment> getCommentsByArticleId(int a_id);
	
	void deleteCommentByC_id(int c_id);
	
	void updateLikesByC_id(int c_id);
	
	void updateLikesByA_id(int a_id); 
	
	int selectC_likesByC_id(int c_id);
	
	int selectA_likesByA_id(int a_id); 
	
	List<Integer> selectC_idsByUsername(String username);
	
	String selectImageByUsername(String username);
	
	audioSet selectAudioSetByUsername(String username);
	
	String selectUsernameByC_id(int c_id);
	
	void insertComment(Comment comment);
	
	void uploadImage(String image_url, String username);
}
 