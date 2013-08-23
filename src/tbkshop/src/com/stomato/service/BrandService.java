package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomato.dao.BrandDao;
import com.stomato.domain.Brand;

@Service
public class BrandService implements BaseService<Brand> {

	@Autowired
	private BrandDao brandDao;

	@Override
	public int add(Brand bean) {
		return brandDao.add(bean);
	}

	@Override
	public int delete(int id) {
		return brandDao.delete(id);
	}

	@Override
	public Brand get(int id) {
		return brandDao.get(id);
	}

	@Override
	public List<Brand> list(Object formParam) {
		return brandDao.list(formParam);
	}

	@Override
	public int listTotal(Object formParam) {
		return brandDao.listTotal(formParam);
	}

	@Override
	public int update(Brand bean) {
		return brandDao.update(bean);
	}
}
