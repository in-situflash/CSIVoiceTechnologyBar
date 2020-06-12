package com.chinasoft.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.CommentMapper;
import com.chinasoft.pojo.Comment;
import com.chinasoft.service.CommentMapperService;

@Service
public class CommentMapperServiceImpl implements CommentMapperService{

	@Autowired
	CommentMapper mapper;
	
	public List<Comment> selectCommentByUser(String username){
		List<Comment> comments = mapper.selectCommentByUser(username);
		
		return comments;
	}

	/*
	* 给定要编辑的评论的id和内容，更新编辑的评论
	*/
	public int editComment(int c_id, String newContent){
		Comment comment = new Comment();
		comment.setC_id(c_id);
		comment.setContent(newContent);

		// 编辑评论时刷新评论时间
		// 设定接口调用的时间为评论的时间
		comment.setC_createtime(new Date());

		return mapper.editComment(comment);
	}

	public int deleteComments(String id_str){
		// 此处假定要删除的评论的id使用 "-" 隔开
		String[] ids = id_str.split("-");
		List<Integer> id_list = new ArrayList<>();

		for (String id: ids){
			int id_int = Integer.parseInt(id);
			id_list.add(id_int);
		}

		return mapper.deleteComments(id_list);
	}
}
