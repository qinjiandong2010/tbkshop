package com.stomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.stomato.dao.CategoryDao;
import com.stomato.domain.Category;
import com.stomato.form.CategoryFormParam;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}
	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
	}
	public List<Category> listCategory(CategoryFormParam param) {
		return categoryDao.listCategory(param);
	}

	public int listTotal(CategoryFormParam param) {
		return categoryDao.listTotal(param);
	}
	
	public Category getCategory(int id) {
		return categoryDao.getCategory(id);
	}
	public List<Category> getListByParent(){
		CategoryFormParam formParam = new CategoryFormParam();
		formParam.setVisible(true);
		formParam.setParent(0);
		return categoryDao.listCategory(formParam);
	}
	@Cacheable(value="sysConfigCache")
	public List<Category> getListNode(){
		List<Category> list = getListByParent();
		for (Category category : list) {
			getListNode(category);
		}
		return list;
	}
	private void getListNode(Category parent){
		List<Category> list = queryCategory(parent.getId(), true);
		parent.setListNode(list);
		for (Category category : list) {
			getListNode(category);
		}
	}
	@Cacheable(value="sysConfigCache")
	public List<Category> queryCategory(int parentId,boolean visible){
		CategoryFormParam formParam = new CategoryFormParam();
		formParam.setVisible(true);
		formParam.setParent(parentId);
		return categoryDao.listCategory(formParam); 
	}
}
