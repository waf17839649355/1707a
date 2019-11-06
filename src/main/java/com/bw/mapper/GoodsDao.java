package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Goods;

/**
 * @author wangafei
 *
 * 2019年11月2日
 */
public interface GoodsDao {
	public List<Goods> selectList(Map<String, Object> map);

	public void add(Goods goods);

	public Goods selectGoodsById(Integer gid);
	
	public void update(Goods goods);
	
	public Integer deleteGoods(String[] gid);
	
	public void updateGoods(Goods goods);
}
