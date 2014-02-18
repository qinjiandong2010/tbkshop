package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	private String username;
	private String password;

	/**
	 * µÇÂ¼´¦Àí
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getVediosByCategory() throws Exception {
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
