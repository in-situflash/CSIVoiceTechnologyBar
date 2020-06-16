package com.chinasoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasoft.mapper.audioSetMapper;

import com.chinasoft.pojo.audioSet;
import com.chinasoft.service.audioSetMapperService;

@Service
public class audioSetMapperServiceImpl implements audioSetMapperService{

	@Autowired
	audioSetMapper mapper;

	@Override
	public void updateByAudioSet(audioSet audio) {
		mapper.updateByAudioSet(audio);
		
	}

	public audioSet selectAudiosetByUser(String username){
		audioSet audioset = mapper.selectAudiosetByUser(username);

		return audioset;
	}
}