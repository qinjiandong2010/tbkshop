package com.stomato.dao;

import java.util.List;

import com.stomato.domain.Category;
import com.stomato.form.CategoryFormParam;

public interface CategoryDao {

	public void addCategory(Category category );

	public void updateCategory(Category category);
	
	public void deleteCategory(int id);

	public List<Category> listCategory(CategoryFormParam param);

	public int listTotal(CategoryFormParam param);

	public Category getCategory(int id);
}
