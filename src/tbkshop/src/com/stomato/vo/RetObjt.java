package com.stomato.vo;

public class RetObjt {

	public static final String ADD_SUCCESS = "0";
	public static final String EDIT_SUCCESS = "00";
	public static final String DEL_SUCCESS = "000";
	
	private String code;

	private String message;

	private Object result;

	public RetObjt(String code, String message, Object result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
