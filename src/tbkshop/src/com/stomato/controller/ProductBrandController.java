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

import com.stomato.domain.Category;
import com.stomato.domain.ProductBrand;
import com.stomato.form.ProductBrandForm;
import com.stomato.form.ProductBrandFormParam;
import com.stomato.service.CategoryService;
import com.stomato.service.ProductBrandService;

@Controller
@RequestMapping("/brand")
public class ProductBrandController extends UserController {

	@Autowired
	private ProductBrandService brandService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String fromPage(@ModelAttribute("brandForm") ProductBrandForm brandForm,Model model){
		List<Category> categoryList = categoryService.getListByParent();
		model.addAttribute("categoryList", categoryList);
		return "portal/brand/brand_form";
	}
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addBrand(@Valid @ModelAttribute("brandForm") ProductBrandForm brandForm,BindingResult result,HttpServletRequest request,Model model){
		brandForm.setBrandIcon("");
		brandService.add(brandForm.asPojo());
		model.addAttribute("success", true);
		return "portal/brand/brand_form";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editPage(@PathVariable int id,@ModelAttribute("brandForm") ProductBrandForm brandForm,Model model){
		return "portal/brand/brand_edit";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editBrand(@PathVariable int id,@ModelAttribute("brandForm") ProductBrandForm brandForm,Model model){
		return "portal/brand/brand_edit";
	}
	@RequestMapping(value="/{id}/del.html",method=RequestMethod.GET)
	public String delBrand(@PathVariable int id,Model model){
		model.addAttribute("success", true);
		return "redirect:/admin/brand/list.html";
	}	
	@RequestMapping(value="/list.html")
	public String list(@ModelAttribute("formParam") ProductBrandFormParam formParam,Model model){
		int total = brandService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<ProductBrand> brandList = brandService.list(formParam);
		model.addAttribute("brandList", brandList);
		return "portal/brand/brand_list";
	}
}
