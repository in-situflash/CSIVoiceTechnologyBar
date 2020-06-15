package com.chinasoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.ArticleDetail;
import com.chinasoft.pojo.Comment;
import com.chinasoft.pojo.audioSet;

public interface ArticleDetailMapper {
	
	ArticleDetail getAllById(int a_id);

	@Select("select * from comment where a_id = #{a_id}")
	List<Comment> getCommentsByArticleId(int a_id);

	@Delete("delete from comment where c_id = #{c_id}")
	void deleteCommentByC_id(int c_id);

	@Update("update comment set c_likes = c_likes + 1 where c_id = #{c_id}")
	void updateLikesByC_id(int c_id);

	@Update("update article set a_likes = a_likes + 1 where a_id = #{a_id}")
	void updateLikesByA_id(int a_id);

	@Select("select c_likes from comment where c_id = #{c_id}")
	int selectC_likesByC_id(int c_id);

	@Select("select a_likes from article where a_id = #{a_id}")
	int selectA_likesByA_id(int a_id);

	@Select("select c_id from comment where username = #{username} ")
	List<Integer> selectC_idsByUsername(String username);

	@Select("select image_url from address where username = #{username}")
	String selectImageByUsername(String username);

	@Select("select * from voice where username = #{username}")
	audioSet selectAudioSetByUsername(String username);

	@Select("select username from comment where c_id = #{c_id}")
	String selectUsernameByC_id(int c_id);

	@Insert("insert into comment(username,content,a_id) values(#{username},#{content},#{a_id})")
	void insertComment(Comment comment);

}
