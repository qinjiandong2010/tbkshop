package com.stomato.form;

public class GoodsFormParam extends PublicParamForm {

	private String goodsName;

	private String keyword;

	private Double pricefrom;

	private Double priceto;

	private String pricerange;

	private Integer[] categorys;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer[] getCategorys() {
		return categorys;
	}

	public void setCategorys(Integer[] categorys) {
		this.categorys = categorys;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Double getPricefrom() {
		return pricefrom;
	}

	public void setPricefrom(Double pricefrom) {
		this.pricefrom = pricefrom;
	}

	public Double getPriceto() {
		return priceto;
	}

	public void setPriceto(Double priceto) {
		this.priceto = priceto;
	}

	public String getPricerange() {
		return pricerange;
	}

	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}

}
