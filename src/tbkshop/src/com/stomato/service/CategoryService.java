package com.stomato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Category> getListNode(){
		List<Category> list = getListByParent();
		for (Category category : list) {
			getListNode(category);
		}
		return list;
	}
	
	public void getListNode(Category parent){
		CategoryFormParam formParam = new CategoryFormParam();
		formParam.setVisible(true);
		formParam.setParent(parent.getId());
		List<Category> list = categoryDao.listCategory(formParam);
		parent.setListNode(list);
		for (Category category : list) {
			getListNode(category);
		}
	}   
	public List<Category> getAllChilds(){
		CategoryFormParam formParam = new CategoryFormParam();
		formParam.setVisible(true);
		List<Category> CategoryList = categoryDao.listCategory(formParam);
		List<Category> levelList = new ArrayList<Category>();
		if( CategoryList != null ){
			for (Category category : CategoryList) {
				if(category.getParent().intValue() == 0){
					levelList.add(category);
				}
			}
			for (Category level : levelList) {
				List<Category> sunType = new ArrayList<Category>();
				for (Category category : CategoryList) {
					if(level.getId().intValue() == category.getParent().intValue()){
						sunType.add(category);
					}
				}
				level.setListNode(sunType);
			}
		}
		return levelList;
	}
}
