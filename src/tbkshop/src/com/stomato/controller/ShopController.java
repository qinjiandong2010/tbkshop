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

import com.stomato.domain.Shop;
import com.stomato.form.ShopForm;
import com.stomato.form.ShopFormParam;
import com.stomato.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController extends UserController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String fromPage(@ModelAttribute("shopForm") ShopForm ShopForm,Model model){
		return "portal/shop/shop_form";
	}
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addShop(@Valid @ModelAttribute("shopForm") ShopForm shopForm,BindingResult result,HttpServletRequest request,Model model){
		shopService.add(shopForm.asPojo());
		model.addAttribute("success", true);
		return "portal/shop/shop_form";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editPage(@PathVariable int id,@ModelAttribute("shopForm") ShopForm ShopForm,Model model){
		return "portal/shop/shop_edit";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editShop(@PathVariable int id,@ModelAttribute("shopForm") ShopForm ShopForm,Model model){
		return "portal/shop/shop_edit";
	}
	@RequestMapping(value="/{id}/delete.html",method=RequestMethod.GET)
	public String deleteShop(@PathVariable int id,Model model){
		shopService.delete(id);
		model.addAttribute("success", true);
		return "redirect:/shop/list.html";
	}	
	@RequestMapping(value="/list.html")
	public String list(@ModelAttribute("formParam") ShopFormParam formParam,Model model){
		int total = shopService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<Shop> shopList = shopService.list(formParam);
		model.addAttribute("shopList", shopList);
		return "portal/shop/shop_list";
	}
}
