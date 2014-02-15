package com.stomato.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.common.PublicDao;
import com.stomato.domain.Brand;
import com.stomato.domain.Category;
import com.stomato.domain.Goods;
import com.stomato.domain.Shop;
import com.stomato.exception.DaoException;
import com.stomato.exception.ServiceException;
import com.stomato.form.GoodsForm;
import com.stomato.form.GoodsFormParam;
import com.stomato.form.ImportGoodsForm;
import com.stomato.service.BrandService;
import com.stomato.service.CategoryService;
import com.stomato.service.GoodsService;
import com.stomato.service.ShopService;
import com.stomato.utils.ExcelUtils;

@Controller
@RequestMapping("/goods")
public class GoodsController extends UserController {

	private static final Logger LOG = Logger.getLogger(GoodsController.class);
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublicDao publicDao;

	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public String formpage(@ModelAttribute("goodsForm") GoodsForm productForm,Model model) throws DaoException {
		List<Shop> shopList = shopService.getValidShopList();
		List<Brand> brandList = brandService.list(null);
		List<Category> categoryList = categoryService.getListNode();
		model.addAttribute("shopList", shopList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("categoryList", categoryList);
		return "portal/goods/goods_form";
	}

	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public String formpage(@Valid @ModelAttribute("goodsForm") GoodsForm productForm,HttpServletRequest request,Model model) throws ServiceException, DaoException {
		productForm.setCreaterUid(this.lookup(request).getUid());
		goodsService.add(productForm.asPojo());
		BeanUtils.copyProperties(new GoodsForm(), productForm);
		model.addAttribute("success", true);
		return formpage(productForm, model);
	}

	@RequestMapping(value = "/list.html")
	public String producdtList(@ModelAttribute("formParam") GoodsFormParam formParam,BindingResult result,Model model) throws ServiceException, DaoException {
		List<Shop> shopList = shopService.getValidShopList();
		List<Brand> brandList = brandService.list(null);
		List<Category> categoryList = categoryService.getListNode();
		
		int count = goodsService.listTotal(formParam);
		formParam.setTotalCount(count);
		List<Goods> goodsList = goodsService.list(formParam);
		model.addAttribute("shopList", shopList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("goodsList", goodsList);
		return "portal/goods/goods_list";
	}

	@RequestMapping(value = "/{id}/delete.html", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) throws ServiceException, DaoException {
		Goods goods = goodsService.get(id);
		if( goods != null ){
			goods.setDelFlag(true);
		}
		goodsService.update(goods);
		model.addAttribute("success", true);
		return "redirect:/goods/list.html";
	}

	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.GET)
	public String preEdit(@PathVariable int id,@ModelAttribute("goodsForm") GoodsForm productForm,Model model) throws BeansException, ServiceException, DaoException {
		List<Shop> shopList = shopService.getValidShopList();
		List<Brand> brandList = brandService.list(null);
		List<Category> categoryList = categoryService.getListNode();
		model.addAttribute("shopList", shopList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("categoryList", categoryList);
		BeanUtils.copyProperties(goodsService.get(id), productForm);
		return "portal/goods/goods_edit";
	}

	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.POST)
	public String saveEdit(@PathVariable int id, @Valid @ModelAttribute("goodsForm") GoodsForm productForm, BindingResult result,Model model) throws ServiceException, DaoException {
		String gotoPage = "portal/goods/goods_edit";
		if( result.hasErrors()){
			return gotoPage;
		}
		goodsService.update(productForm.asPojo());
		model.addAttribute("success", true);
		return gotoPage;
	}
	/**
	 * 导入Excel
	 * @return
	 */
	@RequestMapping(value="/import.html",method=RequestMethod.GET)
	public String importExcel(){
		return "portal/goods/goods_import";
	}
	@RequestMapping(value="/import.html",method=RequestMethod.POST)
	public String importExcel(@Valid @ModelAttribute("importForm") ImportGoodsForm importForm, BindingResult result,Model model){
		String gotoPage = "portal/goods/goods_import";
		if( !importForm.getExcelFile().isEmpty() ){
			if( !importForm.getExcelFile().getContentType().contains("excel") ){
				result.rejectValue("excelFile", "20000", "C[20000]File format error.");
			}
			if( result.hasErrors() ){
				return gotoPage;
			}
			String[] columnNames = {"date","image","title","price","link","shop","s_link","comm_rate","m_link"};
			try {
				List<Map<String,Object>> list = ExcelUtils.readExcel(columnNames, importForm.getExcelFile().getInputStream());
				List<Goods> goodsList = new ArrayList<Goods>();
				for (Map<String, Object> map : list) {
					Shop newShop = new Shop();
					newShop.setShopName((String)map.get("shop"));
					newShop.setShopUrl((String)map.get("s_link"));
					Shop shop = shopService.get(newShop);
					if( shop == null ){
						publicDao.insert("com.stomato.dao.ShopDao.add", newShop);
						shop = newShop;
					}
					Goods goods = new Goods();
					goods.setGoodsCode("");
					goods.setShopId(shop.getId());
					goods.setGoodsName((String)map.get("title"));
					goods.setGoodsPic((String)map.get("image"));
					goods.setlIcon(goods.getGoodsPic());
					goods.setsIcon(goods.getlIcon());
					goods.setCommRate(Double.parseDouble(map.get("comm_rate").toString().replace("%", "")));
					goods.setCostPrice(Double.parseDouble((String)map.get("price")));
					goods.setSellPrice(goods.getCostPrice());
					// 格式化价格，取小数点后两位的浮点数
					BigDecimal bd = new BigDecimal( String.valueOf( goods.getSellPrice() * (goods.getCommRate() / 100) ) ).setScale( 2, RoundingMode.HALF_UP );
					goods.setCommPrice(bd.doubleValue());
					goods.setLinkUrl((String)map.get("link"));
					goods.setBrief((String)map.get("m_link"));
					goodsList.add(goods);
				}
				publicDao.operateItemBatch("com.stomato.dao.GoodsDao.addBatch", goodsList);
				model.addAttribute("success", true);
			} catch (Exception err) {
				model.addAttribute("success", false);
				LOG.error("导入Excel失败", err);
			}
		}
		return gotoPage;
	}

}
