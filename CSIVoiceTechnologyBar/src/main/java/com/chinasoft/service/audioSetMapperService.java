package com.chinasoft.service;

import com.chinasoft.pojo.audioSet;
//import com.chinasoft.pojo.perSet;

public interface audioSetMapperService {
	
	//更新语音设置
	void updateByAudioSet(audioSet audio);
	// 根据用户名获取语音设置
	audioSet selectAudiosetByUser(String username);
}
