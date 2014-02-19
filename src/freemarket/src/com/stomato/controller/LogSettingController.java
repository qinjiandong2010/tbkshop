package com.stomato.controller;
 /**
 * 日志配置
 * 
 * @author Admin
 */
@Controller
@RequestMapping(value="/LogSetting")
public class LogSettingController {
	
	@Autowired
	private LogSettingService LogSettingService;
 
	@RequestMapping(value="/list.html")
	public String LogSettingList(@ModelAttribute("formParam") LogSettingFormParam formParam,BindingResult result,HttpServletRequest request,Model model){
		int total = LogSettingService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<Map<String,Object>> dataList = LogSettingService.getListMap(formParam);
		model.addAttribute("dataList", dataList);
		return "portal/LogSetting/LogSettingList";
	}
}