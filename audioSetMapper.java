package com.chinasoft.mapper;

import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.audioSet;

public interface audioSetMapper {
	
	
	@Update("update voice set voicetype=#{voicetype},speed=#{speed},tone=#{tone},volume=#{volume} where username =#{username};")
	void updateByAudioSet(audioSet audio);
}
