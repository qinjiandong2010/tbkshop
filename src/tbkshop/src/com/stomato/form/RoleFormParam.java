package com.stomato.form;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleFormParam extends PublicParamForm {

	@NotEmpty
	private String roleName;

	private int status;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
