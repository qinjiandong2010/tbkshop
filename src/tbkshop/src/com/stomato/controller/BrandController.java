package com.stomato.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.stomato.constant.Constant;
import com.stomato.domain.Brand;
import com.stomato.domain.Category;
import com.stomato.domain.User;
import com.stomato.exception.DaoException;
import com.stomato.exception.ServiceException;
import com.stomato.form.BrandForm;
import com.stomato.form.BrandFormParam;
import com.stomato.service.BrandService;
import com.stomato.service.CategoryService;
import com.stomato.service.ConfigService;
import com.stomato.utils.DateUtils;
import com.stomato.utils.StringUtils;

@Controller
@RequestMapping("/brand")
public class BrandController extends UserController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigService configService;
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String fromPage(@ModelAttribute("brandForm") BrandForm brandForm,Model model){
		List<Category> categoryList = categoryService.getListByParent();
		model.addAttribute("categoryList", categoryList);
		return "portal/brand/brand_form";
	}
	private String uploadIcon(User user,MultipartFile iconFile,BindingResult result){
		/**
		 * 上传文件路径
		 */
		String realPath = configService.loadConfig(Constant.Configs.filesDirPath)+Constant.fileSeparator+Constant.Configs.uploadDirPath
						  +Constant.fileSeparator+user.getUid()
						  +Constant.fileSeparator+Constant.Configs.brandDirPath
						  +Constant.fileSeparator+DateUtils.getDateStr(DateUtils.patternB)
						  +Constant.fileSeparator+Constant.Configs.iconDir;
		File uploadDir = new File(realPath);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		String newname = DateUtils.getDateStr(DateUtils.patternF)+StringUtils.getSuffix(iconFile.getOriginalFilename());
		try {
			iconFile.transferTo(new File(realPath, newname));
		} catch (Exception err){
			result.rejectValue("iconFile", "10000", "C[10000]Brand icon to upload failed");
			return "";
		}
		return realPath+Constant.fileSeparator+newname;
	}
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addBrand(@Valid @ModelAttribute("brandForm") BrandForm brandForm,BindingResult result,HttpServletRequest request,Model model) throws ServiceException, DaoException{
		MultipartFile iconFile = brandForm.getIconFile();
		if( iconFile.isEmpty() ){
			brandForm.setBrandIcon("");
		}else{
			brandForm.setBrandIcon(uploadIcon(this.lookup(request), iconFile, result));
		}
		brandService.add(brandForm.asPojo());
		model.addAttribute("success", true);
		return "portal/brand/brand_form";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String editPage(@PathVariable int id,@ModelAttribute("brandForm") BrandForm brandForm,BindingResult result,Model model){
		Brand brand = brandService.get(id);
		//bingding bean to view
		BeanUtils.copyProperties(brand, brandForm);
		List<Category> categoryList = categoryService.getListByParent();
		model.addAttribute("categoryList", categoryList);
		return "portal/brand/brand_edit";
	}
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String editBrand(@PathVariable int id,@Valid @ModelAttribute("brandForm") BrandForm brandForm,BindingResult result,HttpServletRequest request,Model model){
		String toView = "portal/brand/brand_edit";
		if( result.hasErrors() ){
			return toView;
		}
		Brand oldBrand = brandService.get(id);

		MultipartFile iconFile = brandForm.getIconFile();
		if( iconFile.isEmpty() ){
			brandForm.setBrandIcon(oldBrand.getBrandIcon());
		}else{		
			File oldIconFile = new File(oldBrand.getBrandIcon());
			if( oldIconFile.exists() ){
				oldIconFile.delete();
			}
			brandForm.setBrandIcon(uploadIcon(this.lookup(request), iconFile, result));
		}
		brandService.update(brandForm.asPojo());
		model.addAttribute("success", true);
		return editPage(id, brandForm, result, model);
	}
	@RequestMapping(value="/{id}/delete.html",method=RequestMethod.GET)
	public String delBrand(@PathVariable int id,Model model){
		brandService.delete(id);
		model.addAttribute("success", true);
		return "redirect:/brand/list.html";
	}	
	@RequestMapping(value="/list.html")
	public String list(@ModelAttribute("formParam") BrandFormParam formParam,Model model) throws ServiceException, DaoException{
		int total = brandService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<Brand> brandList = brandService.list(formParam);
		List<Category> categoryList = categoryService.getListByParent();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("brandList", brandList);
		return "portal/brand/brand_list";
	}
	/**
	 * 编辑可用
	 * @return
	 */
	@RequestMapping(value="/{id}/usable.html")
	public String usableStatus(@PathVariable int id,Model model){
		Brand brand = brandService.get(id);
		if( Constant.BrandStatus.disable == brand.getStatus()){
			brand.setStatus(Constant.BrandStatus.usable);
			brandService.update(brand);
		}
		return "redirect:/brand/list.html";
	}
	/**
	 * 编辑禁用
	 * @return
	 */
	@RequestMapping(value="/{id}/disable.html")
	public String disableStatus(@PathVariable int id,Model model){
		Brand brand = brandService.get(id);
		if( Constant.BrandStatus.usable == brand.getStatus()){
			brand.setStatus(Constant.BrandStatus.disable);
			brandService.update(brand);
		}
		return "redirect:/brand/list.html";
	}	
}
