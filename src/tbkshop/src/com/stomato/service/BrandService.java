package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomato.dao.BrandDao;
import com.stomato.domain.Brand;

@Service
public class BrandService{

	@Autowired
	private BrandDao brandDao;

	public int add(Brand bean) {
		return brandDao.add(bean);
	}

	public int delete(int id) {
		return brandDao.delete(id);
	}

	public Brand get(int id) {
		return brandDao.get(id);
	}

	public List<Brand> list(Object formParam) {
		return brandDao.list(formParam);
	}

	public int listTotal(Object formParam) {
		return brandDao.listTotal(formParam);
	}

	public int update(Brand bean) {
		return brandDao.update(bean);
	}
}
