package com.stomato.dao;

import java.util.List;

import com.stomato.domain.Shop;

public interface ShopDao {
	public int add(Shop bean);

	public int delete(int id);

	public Shop get(Shop shop);

	public List<Shop> list(Object formParam);

	public int listTotal(Object formParam);

	public int update(Shop bean);

	public List<Shop> getValidShopList();
}
