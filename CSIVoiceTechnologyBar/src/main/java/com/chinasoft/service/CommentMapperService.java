package com.chinasoft.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.pojo.Comment;
import com.chinasoft.pojo.TitledComment;

public interface CommentMapperService {
	List<Comment> selectCommentByUser(String username);
	List<TitledComment> selectTitledCommentByUser(String username);
	int editComment(int c_id, String newContent);
	int deleteComments(String id_str);
	boolean checkOperationAuthorization(String id_str, String username);
}
