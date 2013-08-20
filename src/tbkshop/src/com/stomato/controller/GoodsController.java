package com.stomato.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.form.GoodsForm;
import com.stomato.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends UserController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public String formpage(@ModelAttribute("goodsForm") GoodsForm productForm) {
		return "portal/goods/goods_form";
	}

	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public String formpage(@Valid @ModelAttribute("goodsForm") GoodsForm productForm,Model model) {
		goodsService.add(productForm.asPojo());
		return "portal/goods/goods_form";
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.POST)
	public String producdtList(Model model) {
		return "portal/goods/goods_list";
	}

	@RequestMapping(value = "/{id}/delete.html", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id, Model model) {
		return "portal/goods/goods_list";
	}

	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.GET)
	public String editProduct(@PathVariable int id, Model model) {
		return "portal/goods/goods_edit";
	}

	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.POST)
	public String editProduct(@PathVariable int id,
			@Valid @ModelAttribute("productForm") GoodsForm productForm,
			Model model) {
		return "portal/goods/goods_edit";
	}

}
