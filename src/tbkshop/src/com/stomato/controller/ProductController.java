package com.stomato.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.form.ProductForm;

@Controller
@RequestMapping("/product")
public class ProductController extends UserController{

	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String formpage(@ModelAttribute("productForm") ProductForm productForm){
		return null;
	}
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String formpage(@Valid @ModelAttribute("productForm") ProductForm productForm,Model model){
		return null;
	}
	@RequestMapping(value="/list.html",method=RequestMethod.POST)
	public String producdtList(Model model){
		return null;
	}
	@RequestMapping(value="/{id}/delete.html",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id,Model model){
		return null;
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editProduct(@PathVariable int id,Model model){
		return null;
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editProduct(@PathVariable int id,@Valid @ModelAttribute("productForm") ProductForm productForm,Model model){
		return null;
	}
	
}
