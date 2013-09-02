package com.stomato.form;


public class BrandFormParam extends SearchFormParam{
   
	private String brandName;
	private String cateId;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
}
