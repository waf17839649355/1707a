package com.bw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Brand;
import com.bw.entity.Goodskind;
import com.bw.mapper.BrandDao;

/**
 * @author wangafei
 *
 * 2019年11月3日
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Resource
	private BrandDao dao;
	
	public List<Brand> selectlist() {
		// TODO Auto-generated method stub
		return dao.selectlist();
	}

	public List<Goodskind> selectlist1() {
		// TODO Auto-generated method stub
		return dao.selectlist1();
	}

}
