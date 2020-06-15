package com.chinasoft.service.impl;

import java.util.*;

import com.chinasoft.pojo.TitledComment;
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
		根据提供的用户名，获取带文章标题的评论
	 */
	public List<TitledComment> selectTitledCommentByUser(String username){
		List<TitledComment> comments = mapper.selectTitledCommentByUser(username);

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

	/**
	 * 检查待删除的评论项是否是自己的评论
	 * @param id_str 待删除的评论id拼接字符串
	 * @param username 正在删除评论的登录用户名
	 * @return 是否有资格删除这些评论
	 */
	public boolean checkOperationAuthorization(String id_str, String username){
		List<Integer> id_list = parseCIdCatStr(id_str);
		List<String> comUsernames = mapper.selectUsersOfComments(id_list);

		// 利用流来快速判断评论用户列表内的用户名是否与给定用户名相同
		boolean isMatched = comUsernames.stream().allMatch(name->name.equals(username));

		System.out.println("\n\noperated username:"+username);
		System.out.println("owner usernames:"+comUsernames);
		System.out.println("matched:"+isMatched+"\n\n");
		return isMatched;
	}

	public int deleteComments(String id_str){
		List<Integer> id_list = parseCIdCatStr(id_str);

		return mapper.deleteComments(id_list);
	}


	/**
	 * 解析多个评论id拼接而成的字符串为id的列表，拼接符号为 "-"
	 * @param id_str id拼接后的字符串
	 * @return id列表
	 */
	private List<Integer> parseCIdCatStr(String id_str){
		// 此处假定要删除的评论的id使用 "-" 隔开
		String[] ids = id_str.split("-");
		List<Integer> id_list = new ArrayList<>();

		for (String id: ids){
			int id_int = Integer.parseInt(id);
			id_list.add(id_int);
		}
		return id_list;
	}
}
