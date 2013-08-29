package com.stomato.form;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.stomato.domain.Shop;

public class ShopForm {
	private Integer id;
	private String shopName;
	private String shopLogo;
	private String shopUrl;
	private String shopInfo;
	private Integer sort;
	private String remark;
	private String couponsUse;
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public String getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCouponsUse() {
		return couponsUse;
	}

	public void setCouponsUse(String couponsUse) {
		this.couponsUse = couponsUse;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public Shop asPojo() {
		Shop param = new Shop();
		BeanUtils.copyProperties(this, param);
		return param;
	}

	/** **********非持久化对象*********** */
	private MultipartFile shopLogoFile;

	public MultipartFile getShopLogoFile() {
		return shopLogoFile;
	}

	public void setShopLogoFile(MultipartFile shopLogoFile) {
		this.shopLogoFile = shopLogoFile;
	}

}
