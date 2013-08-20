package com.stomato.service;

import java.util.List;


public interface BaseService<T> {

	public int delete(int id);
	
	public int add(T bean);

	public int update(T bean);

	public List<T> list(Object formParam);

	public int listTotal(Object formParam);

	public T get(int id);
}
