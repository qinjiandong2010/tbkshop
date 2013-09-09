package com.stomato.form;

import org.hibernate.validator.constraints.NotEmpty;

public class MenuFormParam extends PublicParamForm {

	/**
	 * 菜单名称
	 */
	@NotEmpty
	private String name;

	/**
	 * 父菜单ID 0表示没有父菜单
	 */
	private Integer parent;

	/**
	 * 是否可见：0-不可见，1-可见
	 */
	private Integer visible;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

}
