package com.stomato.form;

import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.stomato.domain.Product;

public class ProductForm {

	private Long id;
	private String productId;
	@Length(max = 50)
	@NotEmpty
	private String productName;
	@Min(0)
	private Double retailPrice;
	@Min(0)
	private Double price;
	@Min(0)
	private Double commission;
	@Min(0)
	private Integer integral;
	private Integer brandId;
	@Min(0)
	private Integer stocks;
	@Min(0)
	private Integer volume;
	private Integer categoryId;
	private String icon185;
	private String img;
	private Integer imgStatus;
	private String link;
	private String keyword;
	private Integer buys;
	private Integer status;
	private Integer type;
	private Date startDate;
	private Date endDate;
	private String brief;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getIcon185() {
		return icon185;
	}

	public void setIcon185(String icon185) {
		this.icon185 = icon185;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getImgStatus() {
		return imgStatus;
	}

	public void setImgStatus(Integer imgStatus) {
		this.imgStatus = imgStatus;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getBuys() {
		return buys;
	}

	public void setBuys(Integer buys) {
		this.buys = buys;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public Product asPojo() {
		Product param = new Product();
		BeanUtils.copyProperties(this, param);
		return param;
	}
}
