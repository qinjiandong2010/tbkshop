package com.stomato.domain;

import java.util.Arrays;
import java.util.Date;

public class Goods {
	private long id;
	private String goodsCode;
	private String goodsName;
	private String displayName;
	private Integer shopId;
	private Integer brandId;
	private Integer createrUid;
	private Double sellPrice;
	private Double costPrice;
	private Double commRate;
	private Double commPrice;
	private String goodsPic;
	private String sIcon;
	private String lIcon;
	private String likeNum;
	private Boolean isTop;
	private Boolean isHot;
	private Boolean indexHot;
	private Boolean status;
	private Boolean preview;
	private Integer sort;
	private String keyword;
	private Integer stocks;
	private String linkUrl;
	private Integer buys;
	private Boolean delFlag;
	private String brief;
	private String content;
	private Date createtime;
	private Date modifytime;
	private Integer[] categorys;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getCreaterUid() {
		return createrUid;
	}

	public void setCreaterUid(Integer createrUid) {
		this.createrUid = createrUid;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getCommRate() {
		return commRate;
	}

	public void setCommRate(Double commRate) {
		this.commRate = commRate;
	}

	public Double getCommPrice() {
		return commPrice;
	}

	public void setCommPrice(Double commPrice) {
		this.commPrice = commPrice;
	}

	public Integer[] getCategorys() {
		return categorys;
	}

	public void setCategorys(Integer[] categorys) {
		this.categorys = categorys;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
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

	public String getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Boolean getIndexHot() {
		return indexHot;
	}

	public void setIndexHot(Boolean indexHot) {
		this.indexHot = indexHot;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getPreview() {
		return preview;
	}

	public void setPreview(Boolean preview) {
		this.preview = preview;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

	public String getsIcon() {
		return sIcon;
	}

	public void setsIcon(String sIcon) {
		this.sIcon = sIcon;
	}

	public String getlIcon() {
		return lIcon;
	}

	public void setlIcon(String lIcon) {
		this.lIcon = lIcon;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getBuys() {
		return buys;
	}

	public void setBuys(Integer buys) {
		this.buys = buys;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}
