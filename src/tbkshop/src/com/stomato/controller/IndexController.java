package com.stomato.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import com.stomato.common.PublicDao;
import com.stomato.domain.Category;
import com.stomato.domain.Page;
import com.stomato.form.GoodsFormParam;
import com.stomato.service.CategoryService;
import com.stomato.service.GoodsService;
import com.stomato.service.IndexService;

@Controller
public class IndexController {
	private static final Logger LOG = Logger.getLogger(IndexController.class);
	@Autowired
	private LocaleResolver localeResolver;
	@Autowired
	private IndexService indexService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
<<<<<<< HEAD
	private PublicDao publicDao;
=======
	private GoodsService goodsService;
>>>>>>> c4ee6b65bc62b5c24a1fa03a4b563984bd447398
	
	@RequestMapping("/")
	public String index(@ModelAttribute("formParam") GoodsFormParam formParam,BindingResult result, Model model) {
		try {
			formParam.setPageSize(30);
<<<<<<< HEAD
			int count = publicDao.queryForEntity("com.stomato.dao.GoodsDao.querySummaryCount", Integer.class, formParam);
			formParam.setTotalCount(count);
			List goodsList = publicDao.queryForListEntity("com.stomato.dao.GoodsDao.querySummaryList", Map.class, formParam);
=======
			
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("offset", formParam.getOffset());
			paramMap.put("pagesize", formParam.getPageSize());
			paramMap.put("categorys", formParam.getCategorys());
			paramMap.put("pricefrom", formParam.getPricefrom());
			paramMap.put("priceto", formParam.getPriceto());
			
			Page<Map<String,Object>> page = goodsService.queryGoods(paramMap);
			formParam.setTotalCount((int)page.getTotalRecord());
>>>>>>> c4ee6b65bc62b5c24a1fa03a4b563984bd447398
			List<Category> resultList = categoryService.getListNode();
			model.addAttribute("categoryList", resultList);
			model.addAttribute("goodsList", page.getDataList());
		} catch (Exception err) {
			LOG.error("查询商品异常",err);
		}
		return "index";
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView aboutus() {
		return new ModelAndView("aboutus/aboutus");
	}
	
	@RequestMapping("/partner")
	public ModelAndView partner() {
		return new ModelAndView("partner/partner");
	}
	
	@RequestMapping("/helpcenter")
	public ModelAndView helpcenter() {
		return new ModelAndView("helpcenter/helpcenter");
	}
	
	@RequestMapping("/news")
	public ModelAndView news() {
		return new ModelAndView("news/news");
	}
	
	@RequestMapping("/news/{articleId}")
	public ModelAndView newsArticle(@PathVariable long articleId) {
		return new ModelAndView("news/news_"+articleId);
	}
	
	@RequestMapping("/zh")
	public ModelAndView switchToZH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Locale locale = Locale.SIMPLIFIED_CHINESE;
		localeResolver.setLocale(request, response, locale);
		model.put("pushAdsDisplay", indexService.getIndexCount());
		return new ModelAndView("index", model);
	}
	
	@RequestMapping("/en")
	public ModelAndView switchToEN(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Locale locale = Locale.US;
		localeResolver.setLocale(request, response, locale);
		model.put("pushAdsDisplay", indexService.getIndexCount());
		return new ModelAndView("index", model);
	}
}