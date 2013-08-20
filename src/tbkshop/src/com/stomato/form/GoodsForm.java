package com.stomato.form;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.stomato.domain.Goods;
import com.stomato.utils.StringUtils;

public class GoodsForm {
	private long id;
	@Length(max=100,min=6)
	private String goodsCode;
	@NotEmpty
	private String goodsName;
	private String displayName;
	private Integer shopId;
	private Integer barndId;
	private Integer createrUid;
	private Integer cateId;
	private Double shopPrice;
	private Double marketPrice;
	private Double commission;
	private String goodsPic;
	private String goodsIcon;
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
	
	public String goodsPic1;
	public String goodsPic2;
	public String goodsPic3;
	public String goodsPic4;

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

	public Integer getBarndId() {
		return barndId;
	}

	public void setBarndId(Integer barndId) {
		this.barndId = barndId;
	}

	public Integer getCreaterUid() {
		return createrUid;
	}

	public void setCreaterUid(Integer createrUid) {
		this.createrUid = createrUid;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public String getGoodsPic() {
		if(goodsPic1 != null || !StringUtils.isEmpty(goodsPic1)){
			goodsPic += ","+goodsPic1;
		}
		if(goodsPic2 != null || !StringUtils.isEmpty(goodsPic2)){
			goodsPic += ","+goodsPic2;
		}
		if(goodsPic3 != null || !StringUtils.isEmpty(goodsPic3)){
			goodsPic += ","+goodsPic3;
		}
		if(goodsPic4 != null || !StringUtils.isEmpty(goodsPic4)){
			goodsPic += ","+goodsPic4;
		}
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public String getGoodsIcon() {
		return goodsIcon;
	}

	public void setGoodsIcon(String goodsIcon) {
		this.goodsIcon = goodsIcon;
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

	public String getGoodsPic1() {
		return goodsPic1;
	}

	public void setGoodsPic1(String goodsPic1) {
		this.goodsPic1 = goodsPic1;
	}

	public String getGoodsPic2() {
		return goodsPic2;
	}

	public void setGoodsPic2(String goodsPic2) {
		this.goodsPic2 = goodsPic2;
	}

	public String getGoodsPic3() {
		return goodsPic3;
	}

	public void setGoodsPic3(String goodsPic3) {
		this.goodsPic3 = goodsPic3;
	}

	public String getGoodsPic4() {
		return goodsPic4;
	}

	public void setGoodsPic4(String goodsPic4) {
		this.goodsPic4 = goodsPic4;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public Goods asPojo() {
		Goods param = new Goods();
		BeanUtils.copyProperties(this, param);
		return param;
	}
}
