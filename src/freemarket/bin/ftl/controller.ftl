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

import com.stomato.domain.${bean.name};
import com.stomato.form.${bean.name}Form;
import com.stomato.form.${bean.name}FormParam;
import com.stomato.service.${bean.name}Service;
 /**
 * ${bean.comment}
 * 
 * @author ${bean.authorName}
 */
@Controller
@RequestMapping(value="/${bean.nameI}")
public class ${bean.name}Controller {
	
	@Autowired
	private ${bean.name}Service ${bean.nameI}Service;
 
	@RequestMapping(value="/list.html")
	public String ${bean.name}List(@ModelAttribute("formParam") ${bean.name}FormParam formParam,BindingResult result,HttpServletRequest request,Model model){
		int total = ${bean.nameI}Service.listTotal(formParam);
		formParam.setTotalCount(total);
		List<${bean.name}> dataList = ${bean.nameI}Service.list(formParam);
		model.addAttribute("dataList", dataList);
		return "portal/${bean.nameI}/${bean.nameI}List";
	}

	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String add${bean.name}(@ModelAttribute("beanForm") ${bean.name}Form beanForm){
		return "portal/${bean.nameI}/${bean.nameI}Form";
	}

	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String add${bean.name}(@Valid @ModelAttribute("beanForm") ${bean.name}Form beanForm, BindingResult result,HttpServletRequest request,Model model){
		
		if(result.hasErrors()){
			return "portal/${bean.nameI}/${bean.nameI}Form";
		}
		${bean.name} bean = beanForm.asPojo();
		${bean.nameI}Service.add(bean);
		//清空表单
		BeanUtils.copyProperties(new ${bean.name}Form(), beanForm);
		model.addAttribute("success", true);
		return "portal/${bean.nameI}/${bean.nameI}Form";
	}
	
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.GET)
	public String update${bean.name}(@PathVariable int id,@ModelAttribute("beanForm")${bean.name}Form beanForm,BindingResult result) throws ParseException, IOException{
		${bean.name} bean = ${bean.nameI}Service.get(id);
		BeanUtils.copyProperties(bean, beanForm);
		return "portal/${bean.nameI}/${bean.nameI}Edit";
	}
	
	@RequestMapping(value="/{id}/edit.html",method=RequestMethod.POST)
	public String update${bean.name}(@PathVariable int id,@Valid @ModelAttribute("beanForm")${bean.name}Form beanForm,BindingResult result,Model model) throws ParseException, IOException{
		if( result.hasErrors()){
			return "portal/${bean.nameI}/${bean.nameI}Edit";
		}
		beanForm.setId(id);
		${bean.nameI}Service.update(beanForm.asPojo());
		model.addAttribute("success", true);
		return update${bean.name}(id, beanForm, result);
	}
}