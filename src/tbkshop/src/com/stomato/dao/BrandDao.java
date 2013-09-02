package com.stomato.dao;

import java.util.List;

import com.stomato.domain.Brand;

public interface BrandDao {
	public int add(Brand bean);

	public int delete(int id);

	public Brand get(int id);

	public List<Brand> list(Object formParam);

	public int listTotal(Object formParam);

	public int update(Brand bean);
}
