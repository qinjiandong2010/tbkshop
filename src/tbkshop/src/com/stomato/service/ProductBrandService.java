package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomato.dao.ProductBrandDao;
import com.stomato.domain.ProductBrand;

@Service
public class ProductBrandService implements BaseService<ProductBrand> {

	@Autowired
	private ProductBrandDao brandDao;

	@Override
	public int add(ProductBrand bean) {
		return brandDao.add(bean);
	}

	@Override
	public int delete(int id) {
		return brandDao.delete(id);
	}

	@Override
	public ProductBrand get(int id) {
		return brandDao.get(id);
	}

	@Override
	public List<ProductBrand> list(Object formParam) {
		return brandDao.list(formParam);
	}

	@Override
	public int listTotal(Object formParam) {
		return brandDao.listTotal(formParam);
	}

	@Override
	public int update(ProductBrand bean) {
		return brandDao.update(bean);
	}

}
