package ${bean.domain}.controller;
 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String ${bean.className}List(@ModelAttribute("formParam") ${bean.className}FormParam formParam,BindingResult result,HttpServletRequest request,Model model){
		int total = ${bean.className}Service.listTotal(formParam);
		formParam.setTotalCount(total);
		List<Map<String,Object>> dataList = ${bean.className}Service.getListMap(formParam);
		model.addAttribute("dataList", dataList);
		return "portal/${bean.className}/${bean.className}List";
	}
}