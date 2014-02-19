package ${bean.domain}.controller;
 
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

import com.stomato.domain.${bean.className};
import com.stomato.form.${bean.className}Form;
import com.stomato.form.${bean.className}SearchForm;
import com.stomato.service.${bean.className}Service;
 /**
 * ${bean.businessName}
 * 
 * @author ${bean.authorName}
 */
@Controller
@RequestMapping(value="/${bean.className}")
public class ${bean.className}Controller {
	
	@Autowired
	private ${bean.className}Service ${bean.className}Service;
 
	@RequestMapping(value="/list.html")
	public String ${bean.className}List(@ModelAttribute("formParam") ${bean.className}SearchForm searchForm,BindingResult result,HttpServletRequest request,Model model){
		int total = ${bean.className}Service.listTotal(searchForm);
		searchForm.setTotalCount(total);
		List<${bean.className}> dataList = ${bean.className}Service.list(searchForm);
		model.addAttribute("dataList", dataList);
		return "portal/${bean.className}/${bean.className}List";
	}

	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String add${bean.className}(@ModelAttribute("beanForm") ${bean.className}Form beanForm){
		return "portal/${bean.className}/${bean.className}Form";
	}

	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String add${bean.className}(@Valid @ModelAttribute("beanForm") ${bean.className}Form beanForm, BindingResult result,HttpServletRequest request,Model model){
		
		if(result.hasErrors()){
			return "portal/${bean.className}/${bean.className}Form";
		}
		${bean.className} bean = beanForm.asPojo();
		${bean.className}Service.add(bean);
		//清空表单
		BeanUtils.copyProperties(new ${bean.className}Form(), beanForm);
		model.addAttribute("success", true);
		return "portal/${bean.className}/${bean.className}Form";
	}
	
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String update${bean.className}(@PathVariable int id,@ModelAttribute("beanForm")${bean.className}Form beanForm,BindingResult result) throws ParseException, IOException{
		${bean.className} bean = ${bean.className}Service.get(id);
		BeanUtils.copyProperties(bean, beanForm);
		return "portal/${bean.className}/${bean.className}Edit";
	}
	
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String update${bean.className}(@PathVariable int id,@Valid @ModelAttribute("beanForm")${bean.className}Form beanForm,BindingResult result,Model model) throws ParseException, IOException{
		if( result.hasErrors()){
			return "portal/${bean.className}/${bean.className}Edit";
		}
		beanForm.setId(id);
		${bean.className}Service.update(beanForm.asPojo());
		model.addAttribute("success", true);
		return update${bean.className}(id, beanForm, result);
	}
}