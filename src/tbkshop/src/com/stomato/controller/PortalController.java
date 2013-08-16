package com.stomato.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.domain.Admin;
import com.stomato.domain.Password;
import com.stomato.form.LoginForm;
import com.stomato.form.ResetByEmailForm;
import com.stomato.form.ResetPasswordForm;
import com.stomato.helper.MailHelper;
import com.stomato.service.AdminService;
import com.stomato.service.PasswordService;
import com.stomato.utils.StringUtils;
import com.stomato.validator.ResetPasswordValidation;

@Controller
@RequestMapping("/")
public class PortalController extends UserController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private ResetPasswordValidation resetPasswordValidation;
	
	@RequestMapping(value="/login.html", method = RequestMethod.GET)
	public String showForm(@ModelAttribute LoginForm loginForm, Map<String, Object> model, HttpServletRequest request) {
		return "admin/login";
	}

	@RequestMapping(value="/login.html", method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (result.hasErrors()) {
			if (StringUtils.isEmpty(loginForm.getUserName())) {
				model.addAttribute("usernameEmpty", true);
			} else if (StringUtils.isEmpty(loginForm.getPassword())) {
				model.addAttribute("passwordEmpty", true);
			} else {
				model.addAttribute("accountErr", true);
			}
			return "admin/login";
		}
		Admin user = loginForm.asPojo();
		user = adminService.getUser(user);
		if (user == null) {
			model.addAttribute("accountErr", true);
			return "admin/login";
		}
		
		if (loginForm.getRemember()) {
			user.setLoginToken(StringUtils.getUUID());
			adminService.uploadLoginToken(user);
			this.saveUserCookie(user, request, response);
		}
		this.refreshUserSession(request, user);
		
		String nextUrl = request.getParameter("nextUrl");
		loginForm = null;
		if (!StringUtils.isEmpty(nextUrl)) {
			return "redirect:" + nextUrl;
		}
		return "redirect:/dashboard.html";
	}
	
	@RequestMapping("/logout.html")
	public String signOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			this.clearUserCookie(request, response);
			session.invalidate();
		}
		
		return "redirect:/login.html";
	}
	
	@RequestMapping("/dashboard.html")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	@RequestMapping(value="/recover/reset_pwd.html", method=RequestMethod.GET)
	public String showResetPwd(@ModelAttribute("resetForm") ResetByEmailForm form) {
		return "admin/recover/reset_pwd";
	}
	
	@RequestMapping(value="/recover/reset_pwd.html", method=RequestMethod.POST)
	public String processResetPwd(@Valid @ModelAttribute("resetForm") ResetByEmailForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			if (StringUtils.isEmpty(form.getEmail())) {
				model.addAttribute("emailEmpty", true);
			} else {
				model.addAttribute("emailFormatErr", true);
			}
			return "admin/recover/reset_pwd";
		}
		
		String email = form.getEmail();
		Admin user = adminService.getUserByEmail(email);
		if (user == null) {
			model.addAttribute("emailNotFound", true);
			return "admin/recover/reset_pwd";
		}
		
		String token = StringUtils.getRandomChars(3) + "-" + StringUtils.getRandomChars(3) + "-" + StringUtils.toMD5(StringUtils.getUUID() + user.getUserName()).substring(2, 22);
		Password pwd = new Password();
		pwd.setEmail(email);
		pwd.setToken(token);
		passwordService.setToken(pwd);
		
		String link = "/recover/reset_pwd_confirm/" + token;
		MailHelper.sendResetPwdEmail(email, user.getUserName(), link, "zh_cn");
		
		return "redirect:/recover/reset_pwd_done.html";
	}
	
	@RequestMapping(value="/recover/reset_pwd_done.html", method=RequestMethod.GET)
	public String reset_pwd_done() {
		return "admin/recover/reset_pwd_done";
	}
	
	@RequestMapping(value="/recover/reset_pwd_confirm/{token}", method=RequestMethod.GET)
	public String showResetPwdCofirm(@ModelAttribute("confirmForm") ResetPasswordForm form, @PathVariable String token) {
		if (StringUtils.isEmpty(token)) {
			return "redirect:/recover/reset_pwd_unsuccess.html";
		}
		Password password = passwordService.getToken(token);
		if (password == null) {
			return "redirect:/recover/reset_pwd_unsuccess.html";
		}
		return "admin/recover/reset_pwd_confirm";
	}
	
	@RequestMapping(value="/recover/reset_pwd_confirm/{token}", method=RequestMethod.POST)
	public String processResetPwdCofirm(@Valid @ModelAttribute("confirmForm") ResetPasswordForm form, BindingResult result, @PathVariable String token) {
		if (StringUtils.isEmpty(token)) {
			return "redirect:/recover/reset_pwd_unsuccess.html";
		}
		resetPasswordValidation.validate(form, result);
		if (result.hasErrors()) {
			return "admin/recover/reset_pwd_confirm";
		}
		
		Password password = passwordService.getToken(token);
		if (password == null) {
			return "redirect:/recover/reset_pwd_unsuccess.html";
		}
		
		Admin user = adminService.getUserByEmail(password.getEmail());
		user.setPassword(form.getNew_password1());
		passwordService.removeToken(password.getEmail());
		adminService.updatePassword(user);
		
		return "redirect:/recover/reset_pwd_success.html";
	}
	
	@RequestMapping(value="/recover/reset_pwd_success.html", method=RequestMethod.GET)
	public String reset_pwd_success() {
		return "admin/recover/reset_pwd_success";
	}
	
	@RequestMapping(value="/recover/reset_pwd_unsuccess.html", method=RequestMethod.GET)
	public String reset_pwd_unsuccess() {
		return "admin/recover/reset_pwd_unsuccess";
	}
	
	@RequestMapping("/notify2.html")
	public String notify2() {
		return "admin/notify2";
	}
}
