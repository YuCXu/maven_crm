package com.xyc.mapper;

import java.util.List;

import com.xyc.pojo.BaseDict;

public interface BaseDictMapper {
	
	/**
	 * 根据dict_type_code查询数据字典
	 * @param dict_type_code
	 * @return
	 */
	public List<BaseDict> queryBaseDictByTypeCode(String dictTypeCode);
}
