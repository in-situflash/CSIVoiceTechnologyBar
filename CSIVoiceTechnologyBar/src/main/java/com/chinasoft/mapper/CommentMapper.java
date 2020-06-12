package com.chinasoft.mapper;

import java.util.List;

import com.chinasoft.pojo.Comment;

public interface CommentMapper {
	List<Comment> selectCommentByUser(String username);
	int editComment(Comment comment);
	int deleteComments(List<Integer> d_ids);
}
