package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Goods;
import com.bw.mapper.GoodsDao;

/**
 * @author wangafei
 *
 * 2019年11月2日
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Resource
	private GoodsDao dao;
	public List<Goods> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectList(map);
	}
	public void add(Goods goods) {
		// TODO Auto-generated method stub
		dao.add(goods);
	}
	public Goods selectGoodsById(Integer gid) {
		// TODO Auto-generated method stub
		return dao.selectGoodsById(gid);
	}
	public void update(Goods goods) {
		// TODO Auto-generated method stub
		dao.update(goods);
	}
	public Integer deleteGoods(String[] gid) {
		// TODO Auto-generated method stub
		return dao.deleteGoods(gid);
	}
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		dao.updateGoods(goods);
	}

}
