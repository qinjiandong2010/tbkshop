package com.stomato.form;

import javax.validation.constraints.Size;

public class ResetPasswordForm {
	
	@Size (min=6, max=20)
	private String new_password1;
	
	private String new_password2;

	public String getNew_password1() {
		return new_password1;
	}

	public void setNew_password1(String new_password1) {
		this.new_password1 = new_password1;
	}

	public String getNew_password2() {
		return new_password2;
	}

	public void setNew_password2(String new_password2) {
		this.new_password2 = new_password2;
	}

}
