package com.stomato.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.domain.Category;
import com.stomato.form.CategoryForm;
import com.stomato.form.CategoryFormParam;
import com.stomato.service.CategoryService;

/**
 * 商品分类MVC控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/category")
public class CategoryController {

	//private Logger logger = Logger.getLogger(AppTypeController.class);
	@Autowired
	private CategoryService categoryService ;
	/**
	 * goto 进入添加商品分类
	 * @return
	 */
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String fromPage(@ModelAttribute("categoryForm") CategoryForm appTypeForm,Model model){
		List<Category> resultList = categoryService.getListFillSun();
		model.addAttribute("categoryList", resultList);
		return "portal/category/cate_form";
	}

	/**
	 * 添加商品分类
	 * @param Category
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("categoryForm")CategoryForm categoryForm, BindingResult result,HttpServletRequest request,Model model){
		
		if(result.hasErrors()){
			return "portal/category/cate_form";
		}
		Category category = categoryForm.asPojo();
		categoryService.addCategory(category);
		//清空表单
		BeanUtils.copyProperties(new CategoryForm(), categoryForm);
		model.addAttribute("success", true);
		return fromPage(categoryForm, model);
	}
	
	/**
	 * 展示商品分类
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/show.html")
	public String showCategory(int id,HttpServletRequest request){
		Category category = categoryService.getCategory(id);
		request.setAttribute("category", category);
		return "portal/category/cate_show";
	}
	
	/**
	 * 商品分类列表
	 * @param Category
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/list.html")
	public String categoryList(@ModelAttribute("formParam")CategoryFormParam formParam,BindingResult result,HttpServletRequest request,Model model){
		int total = categoryService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<Category> categoryList = categoryService.listCategory(formParam);
		model.addAttribute("categoryList", categoryList);
		return "portal/category/cate_list";
	}

	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editCategory(@PathVariable int id,@ModelAttribute("categoryForm")CategoryForm form,BindingResult result,Model model) throws ParseException, IOException{
		Category category = categoryService.getCategory(id);
		List<Category> resultList = categoryService.getListFillSun();
		model.addAttribute("categoryList", resultList);
		BeanUtils.copyProperties(category, form);
		return "portal/category/cate_edit";
	}
	/**
	 * 修改商品分类
	 * @param Category
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editCategory(@Valid @ModelAttribute("categoryForm")CategoryForm form, BindingResult result,HttpServletRequest request,Model model) throws ParseException, IOException{
		if( result.hasErrors()){
			return "portal/category/cate_edit";
		}
		Category category = form.asPojo();
		categoryService.updateCategory(category);
		model.addAttribute("success", true);
		return editCategory(category.getId(), form, result,model);
	}
	/**
	 * 删除商品分类，数据库标识删除
	 * @param id
	 * @return
	 */
	 @RequestMapping(value="/{id}/delete.html")
	public String adChanelDelete(@PathVariable int id,@ModelAttribute("category")Category category,BindingResult result,HttpServletRequest request,Model model){
		categoryService.deleteCategory(id);
		model.addAttribute("success", true);
		return "redirect:/admin/category/list.html";
	}
}