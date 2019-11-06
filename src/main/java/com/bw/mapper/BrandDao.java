package com.bw.mapper;

import java.util.List;

import com.bw.entity.Brand;
import com.bw.entity.Goodskind;

/**
 * @author wangafei
 *
 * 2019年11月3日
 */
public interface BrandDao {
	
	public List<Brand> selectlist();
	
	public List<Goodskind> selectlist1();
}
