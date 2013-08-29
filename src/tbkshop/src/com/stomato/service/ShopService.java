package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomato.dao.ShopDao;
import com.stomato.domain.Shop;
import com.stomato.form.ShopFormParam;

@Service
public class ShopService implements BaseService<Shop> {

	@Autowired
	private ShopDao shopDao;

	@Override
	public int add(Shop bean) {
		return shopDao.add(bean);
	}

	@Override
	public int delete(int id) {
		return shopDao.delete(id);
	}

	@Override
	public Shop get(int id) {
		return shopDao.get(id);
	}

	@Override
	public List<Shop> list(Object formParam) {
		return shopDao.list(formParam);
	}

	@Override
	public int listTotal(Object formParam) {
		return shopDao.listTotal(formParam);
	}

	@Override
	public int update(Shop bean) {
		// TODO Auto-generated method stub
		return shopDao.update(bean);
	}

	public List<Shop> getValidShopList(){
		ShopFormParam formParam = new ShopFormParam();
		formParam.setStatus(true);
		return list(formParam);
	}
}
