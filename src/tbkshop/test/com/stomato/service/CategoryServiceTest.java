package com.stomato.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stomato.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext.xml")
public class CategoryServiceTest {

	@Autowired
	CategoryService categoryService;
	
	@Test
	public void getCategory(){
		Category category = categoryService.getCategory(40);
		System.out.println(category);
		category = categoryService.getCategory(40);
		System.out.println(category);
	}
	@Test
	public void queryCategory(){
		System.out.println(categoryService.queryCategory(0, true));
		System.out.println(categoryService.queryCategory(0, true));
	}
}
