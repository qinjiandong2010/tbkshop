package com.stomato.form;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.stomato.domain.ProductBrand;

public class ProductBrandForm {

	private Integer id;
	private String brandName;
	private String cateId;
	private String brandIcon;
	private String remark;
	private Integer sort;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getBrandIcon() {
		return brandIcon;
	}

	public void setBrandIcon(String brandIcon) {
		this.brandIcon = brandIcon;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public ProductBrand asPojo() {
		ProductBrand param = new ProductBrand();
		BeanUtils.copyProperties(this, param);
		return param;
	}
	/************非持久化对象************/
	private MultipartFile iconFile;

	public MultipartFile getIconFile() {
		return iconFile;
	}

	public void setIconFile(MultipartFile iconFile) {
		this.iconFile = iconFile;
	}
	
}
