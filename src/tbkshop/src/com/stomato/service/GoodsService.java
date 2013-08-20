package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomato.dao.GoodsDao;
import com.stomato.domain.Goods;

@Service
public class GoodsService implements BaseService<Goods> {

	@Autowired
	private GoodsDao goodsDao;

	@Override
	public int delete(int id) {
		return goodsDao.delete(id);
	}

	@Override
	public int add(Goods bean) {
		return goodsDao.add(bean);
	}

	@Override
	public int update(Goods bean) {
		return goodsDao.update(bean);
	}

	@Override
	public List<Goods> list(Object formParam) {
		return goodsDao.list(formParam);
	}

	@Override
	public int listTotal(Object formParam) {
		return goodsDao.listTotal(formParam);
	}

	@Override
	public Goods get(int id) {
		return goodsDao.get(id);
	}
	 
}
