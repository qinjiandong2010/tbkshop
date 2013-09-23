package com.stomato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stomato.domain.Goods;
import com.stomato.domain.GoodsCategory;
import com.stomato.exception.DaoException;
import com.stomato.exception.ServiceException;

@Service
public class GoodsService extends BaseServiceImpl{

	public int delete(int id) throws ServiceException, DaoException {
		return delete("com.stomato.dao.GoodsDao.delete", id);
	}

	public int add(Goods bean) throws ServiceException, DaoException {
		if (insert("com.stomato.dao.GoodsDao.add", bean) > 0){
			if( bean.getCategorys() != null ){
				List<GoodsCategory> goodsCateList = new ArrayList<GoodsCategory>();
				for (Integer cateId : bean.getCategorys()) {
					GoodsCategory gc = new GoodsCategory();
					gc.setCateId(cateId);
					gc.setGoodsId(bean.getId());
					goodsCateList.add(gc);
				}
				return super.baseDao.insert("com.stomato.dao.GoodsCateDao.addBatch", goodsCateList);
			}
		}
		return 0;
	}

	public int update(Goods bean) throws ServiceException, DaoException {
		return update("com.stomato.dao.GoodsDao.update", bean);
	}

	public List<Goods> list(Object formParam) throws ServiceException, DaoException {
		return queryForListEntity("com.stomato.dao.GoodsDao.list", Goods.class, formParam);
	}

	public int listTotal(Object formParam) throws ServiceException, DaoException {
		return queryForEntity("com.stomato.dao.GoodsDao.listTotal", Integer.class, formParam);
	}

	public Goods get(int id) throws ServiceException, DaoException {
		return queryForEntity("com.stomato.dao.GoodsDao.get", Goods.class, id);
	}
	 
}
