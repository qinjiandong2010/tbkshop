package com.stomato.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stomato.constant.Constant;
import com.stomato.domain.User;
import com.stomato.form.EmailForm;
import com.stomato.form.PasswordForm;
import com.stomato.form.ProfileForm;
import com.stomato.form.UserForm;
import com.stomato.form.UserFormParam;
import com.stomato.helper.MailHelper;
import com.stomato.service.AccountsService;
import com.stomato.service.RoleService;
import com.stomato.validator.PasswordValidation;

@Controller
@RequestMapping("/accounts")
public class AccountsController extends UserController {
	
	@Autowired
	private PasswordValidation passwordValidation;
	
	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("")
	public String rootPath() {
		return "forward:/accounts/overview";
	}
	
	@RequestMapping("/overview")
	public String main(@ModelAttribute("profileForm") ProfileForm form) {
		return "portal/accounts/overview";
	}
	
	@RequestMapping(value="/change_pwd", method=RequestMethod.GET)
	public String updatePwd(@ModelAttribute("pwdForm") PasswordForm form) {
		return "portal/accounts/change_pwd";
	}
	
	@RequestMapping(value="/change_pwd", method=RequestMethod.POST)
	public String updatePwd(@Valid @ModelAttribute("pwdForm") PasswordForm form, BindingResult result, HttpServletRequest request, Model model) throws Exception {
		passwordValidation.validate(form, result);
		if (!result.hasErrors()) {
			User sessionUser = this.lookup(request);
			User user = new User();
			user.setUid(sessionUser.getUid());
			user.setUserName(sessionUser.getUserName());
			user.setPassword(form.getPassword());
			user = accountsService.getUser(user);
			if (user != null) {
				user.setPassword(form.getNewpassword());
				int count = accountsService.updatePassword(user);
				if (count > 0) {
					model.addAttribute("updated", true);
				}
			} else {
				model.addAttribute("passwordError", true);
			}
		}
		form = null;
		
		return "portal/accounts/change_pwd";
	}
	
	@RequestMapping(value="/change_profile", method=RequestMethod.GET)
	public String updateProfile(@ModelAttribute("profileForm") ProfileForm form, HttpServletRequest request, Model model) {
		User user = this.lookup(request);
		model.addAttribute(user);
		
		return "portal/accounts/change_profile";
	}
	
	@RequestMapping(value="/change_profile", method=RequestMethod.POST)
	public String updateProfile(@Valid @ModelAttribute("profileForm") ProfileForm form, BindingResult result, HttpServletRequest request, Model model) throws Exception {
		if (result.hasErrors()) {
			return "portal/accounts/change_profile";
		}
		User user = this.lookup(request);
		User formUser = form.asPojo();
		form = null;
		if (formUser.getRoleId() == 1) {
			formUser.setCompany(null);
		} else if (formUser.getRoleId() == 2) {
			formUser.setContactName(null);
		}
		user.setRoleId(formUser.getRoleId());
		user.setCompany(formUser.getCompany());
		user.setContactName(formUser.getContactName());
		user.setContactTel(formUser.getContactTel());
		user.setQq(formUser.getQq());
		user.setWebsite(formUser.getWebsite());
		
		accountsService.updateUser(user);
		this.refreshUserSession(request, user);
		
		return "redirect:/accounts/overview";
	}
	
	@RequestMapping(value="/change_email", method=RequestMethod.GET)
	public String changeEmail(@ModelAttribute("emailForm") EmailForm emailForm) {
		return "portal/accounts/change_email";
	}
	
	@RequestMapping(value="/change_email", method=RequestMethod.POST)
	public String changeEmail(@Valid @ModelAttribute("emailForm") EmailForm emailForm, BindingResult results, Model model, HttpServletRequest request) throws Exception {
		if (results.hasErrors()) {
			return "portal/accounts/change_email";
		}
		
		User user = this.lookup(request);
		if (emailForm.getEmail().equals(user.getEmail())) {
			results.rejectValue("email", "error.email_is_currently", "This email address is you are using now.");
			return "portal/accounts/change_email";
		}
		
		if (accountsService.getUserByEmail(emailForm.getEmail()) != null) {
			results.rejectValue("email", "error.email_is_exist", "This email address has been registered.");
			return "portal/accounts/change_email";
		}
		
		user.setEmail(emailForm.getEmail());
		accountsService.updateEmail(user);
		this.refreshUserSession(request, user);
		
		return "redirect:/accounts/overview";
	}
	
	/**
	 * goto 添加用户页面
	 * @return
	 */
	@RequestMapping(value="/formpage.html",method=RequestMethod.GET)
	public String userFormPage(@ModelAttribute("userForm")UserForm userForm,BindingResult result,Model model){
		model.addAttribute("roleList", roleService.listRole(null));
		return "portal/user/userForm";
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @param request
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws Exception 
	 */
	@RequestMapping(value="/formpage.html",method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userForm")UserForm userForm,BindingResult result,Model model) throws Exception{

		model.addAttribute("roleList", roleService.listRole(null));
		if( !userForm.getPassword().equals(userForm.getConfirmPassword()) ){
			result.rejectValue("confirmPassword", "error.password_not_match","Password and Confirm Password Not match.");
		}
		if( !result.hasErrors() ){
			User verifier = new User();
			verifier.setEmail(userForm.getEmail());
			verifier.setUserName(userForm.getUserName());
			verifier = accountsService.verify(verifier);
			if (verifier != null) {
				if (userForm.getEmail().equals(verifier.getEmail())) {
					result.rejectValue("email", "error.email_is_exist","This email address has been registered.");
					return "portal/user/userForm";
				}
				if (userForm.getUserName().equals(verifier.getUserName())) {
					result.rejectValue("username", "error.username_is_exist","This username has been registered.");
					return "portal/user/userForm";
				}
			}
			User user = userForm.asPojo();
			//不需审核
			user.setStatus(Constant.UserStatus.approved);
			accountsService.addUser(user);
			user = accountsService.getUser(user);
			//清空表单
			BeanUtils.copyProperties(new UserForm(), userForm);
			model.addAttribute("success", true);
		}
		return "portal/user/userForm";
	}
	@RequestMapping(value="/listUser.html")
	public String list(@ModelAttribute("formParam")UserFormParam formParam,BindingResult result,Model model) throws Exception{
		int total = accountsService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<User> userList = accountsService.listUser(formParam);
		model.addAttribute("userList", userList);
		return "portal/user/userList";
	}
	@RequestMapping(value="/editUser.html",method=RequestMethod.GET)
	public String updateUser(@ModelAttribute("profileForm")ProfileForm form,int id,Model model) throws Exception{
		User user = accountsService.getUserByUid(id);
		model.addAttribute("editUser", user);
		model.addAttribute("role", roleService.getRole(user.getRoleId()));
		model.addAttribute("roleList", roleService.listRole(null));
		return "portal/user/userUpdate";
	}
	@RequestMapping(value="/editUser.html",method=RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("profileForm")ProfileForm form,BindingResult result,Model model,HttpServletRequest request) throws Exception{

		model.addAttribute("roleList", roleService.listRole(null));
		if(result.hasErrors()){
			return updateUser(form, form.getUid(), model);
		}
		User user = accountsService.getUserByUid(form.getUid());
		if (form.getRoleId() == 1) {
			user.setCompany(null);
		} else if (form.getRoleId() == 2) {
			user.setContactName(null);
		}
		user.setRoleId(form.getRoleId());
		user.setCompany(form.getCompany());
		user.setContactName(form.getContactName());
		user.setContactTel(form.getContactTel());
		user.setQq(form.getQq());
		user.setWebsite(form.getWebsite());
		
		accountsService.updateUser(user);
		
		model.addAttribute("editUser", user);
		model.addAttribute("role", roleService.getRole(user.getRoleId()));
		model.addAttribute("success", true);
		return "portal/user/userUpdate";
	}
	@RequestMapping(value="/userReviewList.html")
	public String listToReview(@ModelAttribute("formParam")UserFormParam formParam,BindingResult result,Model model) throws Exception{
		int total = accountsService.listTotal(formParam);
		formParam.setTotalCount(total);
		List<User> userList = accountsService.listUser(formParam);
		model.addAttribute("userList", userList);
		return "portal/user/userReviewList";
	}
	/**
	 * 用户审核通过
	 * @param id
	 * @param model
	 * @throws Exception 
	 */
	@RequestMapping(value="/{id}/userApproved.html")
	public String approvedUser(@PathVariable int id,Model model) throws Exception{
		User user = accountsService.getUserByUid(id);
		if( user == null ){
			model.addAttribute("success", false);
			return "redirect:/accounts/userReviewList.html";
		}
		user.setStatus(Constant.UserStatus.approved);
		accountsService.updateUser(user);
		model.addAttribute("success", false);
		return "redirect:/accounts/userReviewList.html";
	}
	/**
	 * 用户审核通过
	 * @param id
	 * @param model
	 * @throws Exception 
	 */
	@RequestMapping(value="/{id}/userNoPass.html")
	public String noPassUser(@PathVariable int id,Model model) throws Exception{
		User user = accountsService.getUserByUid(id);
		if( user == null ){
			model.addAttribute("success", false);
			return "redirect:/accounts/userReviewList.html";
		}
		user.setStatus(Constant.UserStatus.noPASS);
		accountsService.updateUser(user);
		model.addAttribute("success", true);
		return "redirect:/accounts/userReviewList.html";
	}
	/**
	 * 用户审核不�1�7�过，向用户发�1�7�驳回理甄1�7
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/{id}/userRebut.html",method=RequestMethod.GET)
	public String rebutUser(@PathVariable int id,Model model) throws Exception{
		User user = accountsService.getUserByUid(id);
		model.addAttribute("user", user);
		return "portal/user/userRebut";
	}
	@RequestMapping(value="/{id}/userRebut.html",method=RequestMethod.POST)
	public String rebutUser(@PathVariable int id,String describe,HttpServletRequest request,Model model) throws Exception{
		User user = accountsService.getUserByUid(id);
		MailHelper.sendRegisterRebutEmail(user.getEmail(), user.getContactName(), describe, "zh");
		model.addAttribute("success", true);
		return rebutUser(id, model);
	}
}