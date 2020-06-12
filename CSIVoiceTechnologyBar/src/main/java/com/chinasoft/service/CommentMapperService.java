package com.chinasoft.service;

import java.util.List;

import com.chinasoft.pojo.Comment;

public interface CommentMapperService {
	List<Comment> selectCommentByUser(String username);
	int editComment(int c_id, String newContent);
	int deleteComments(String id_str);
}
