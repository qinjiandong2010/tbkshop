package com.stomato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stomato.constant.Constant;
import com.stomato.domain.User;
import com.stomato.enums.AccountTypeEnum;
import com.stomato.form.RegistrationForm;
import com.stomato.service.AccountsService;
import com.stomato.validator.RegistrationValidation;

@Controller
@RequestMapping("/")
public class RegistrationController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private RegistrationValidation registrationValidation;
	
	@Autowired
	private AccountsService accountsService;
	
	@RequestMapping(value="/register.html", method = RequestMethod.GET)
	public String showRegistration(@ModelAttribute("regForm") RegistrationForm form) {
		return "portal/register";
	}

	@RequestMapping(value="/register.html", method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("regForm") RegistrationForm form,
											 BindingResult result,
											 @RequestParam("file1") MultipartFile file1,
											 @RequestParam("file2") MultipartFile file2,
											 Model model,
											 HttpServletRequest request) {
		registrationValidation.validate(form, result);
		if (result.hasErrors()) {
			model.addAttribute("type", form.getType());
			return "portal/register";
		}
		
		User verifier = new User();
		verifier.setEmail(form.getEmail());
		verifier.setUserName(form.getUserName());
		verifier = accountsService.verify(verifier);
		if (verifier != null) {
			if (form.getEmail().equals(verifier.getEmail())) {
				model.addAttribute("type", form.getType());
				result.rejectValue("email", "error.email_is_exist", "This email address has been registered.");
				return "portal/register";
			}
			if (form.getUserName().equals(verifier.getUserName())) {
				model.addAttribute("type", form.getType());
				result.rejectValue("userName", "error.username_is_exist", "This username has been registered.");
				return "portal/register";
			}
		}
		
		User user = form.asPojo();
		user.setStatus(Constant.UserStatus.newRegist);
		accountsService.addUser(user);
		
		if (user.getRoleId() == AccountTypeEnum.Company.value()) {
		}
		
		return "redirect:/notify2.html";
	}
	
	@ResponseBody
	@RequestMapping("/checkreg.html")
	public Object checkreg(HttpServletRequest request) {
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		User verifier = new User();
		verifier.setEmail(email);
		verifier.setUserName(userName);
		verifier = accountsService.verify(verifier);
		return verifier != null;
	}
}
