package com.stomato.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stomato.service.BrandService;
import com.stomato.service.CategoryService;
import com.stomato.service.ConfigService;

@Controller
@RequestMapping("/rest")
public class RestController extends UserController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigService configService;
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="/ticker/{market}",method=RequestMethod.GET)
	public @ResponseBody Map<String,String> getTicker(@PathVariable String market,Model model){
		Map<String,String> map = new HashMap<String, String>();
		map.put("result", "0");
		map.put("message", "成功!");
		return map;
	}
}
