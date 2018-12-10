package com.xyc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyc.mapper.BaseDictMapper;
import com.xyc.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	
	@Override
	public List<BaseDict> queryBaseDictByTypeCode(String dictTypeCode) {
		return baseDictMapper.queryBaseDictByTypeCode(dictTypeCode);
	}

}
