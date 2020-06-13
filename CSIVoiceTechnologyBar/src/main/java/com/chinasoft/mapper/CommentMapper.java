package com.chinasoft.mapper;

import java.util.List;

import com.chinasoft.pojo.Comment;
import com.chinasoft.pojo.TitledComment;

public interface CommentMapper {
	List<Comment> selectCommentByUser(String username);
	int editComment(Comment comment);
	int deleteComments(List<Integer> d_ids);
	// 根据提供的用户名，获取带文章标题的评论
	List<TitledComment> selectTitledCommentByUser(String username);
}
