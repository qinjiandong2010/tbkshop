package com.stomato.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.domain.Brand;
import com.stomato.domain.Category;
import com.stomato.exception.DaoException;
import com.stomato.exception.ServiceException;
import com.stomato.form.BrandForm;
import com.stomato.form.BrandFormParam;
import com.stomato.service.BaseService;
import com.stomato.service.CategoryService;

@Controller
@RequestMapping("/brand")
public class BrandController extends UserController {

	@Autowired
	private BaseService baseService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String fromPage(@ModelAttribute("brandForm") BrandForm brandForm,Model model){
		List<Category> categoryList = categoryService.getListByParent();
		model.addAttribute("categoryList", categoryList);
		return "portal/brand/brand_form";
	}
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addBrand(@Valid @ModelAttribute("brandForm") BrandForm brandForm,BindingResult result,HttpServletRequest request,Model model) throws ServiceException, DaoException{
		brandForm.setBrandIcon("");
		baseService.insert("com.stomato.dao.BrandDao.add",brandForm.asPojo());
		model.addAttribute("success", true);
		return "portal/brand/brand_form";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editPage(@PathVariable int id,@ModelAttribute("brandForm") BrandForm brandForm,Model model){
		return "portal/brand/brand_edit";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editBrand(@PathVariable int id,@ModelAttribute("brandForm") BrandForm brandForm,Model model){
		return "portal/brand/brand_edit";
	}
	@RequestMapping(value="/{id}/del.html",method=RequestMethod.GET)
	public String delBrand(@PathVariable int id,Model model){
		model.addAttribute("success", true);
		return "redirect:/admin/brand/list.html";
	}	
	@RequestMapping(value="/list.html")
	public String list(@ModelAttribute("formParam") BrandFormParam formParam,Model model) throws ServiceException, DaoException{
		int total = baseService.queryForEntity("com.stomato.dao.BrandDao.listTotal",Integer.class,formParam);
		formParam.setTotalCount(total);
		List<Brand> brandList = baseService.queryForListEntity("com.stomato.dao.BrandDao.list",Brand.class,formParam);
		model.addAttribute("brandList", brandList);
		return "portal/brand/brand_list";
	}
}
