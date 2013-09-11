package com.stomato.form;

import org.springframework.web.multipart.MultipartFile;

public class ImportGoodsForm {
	
	private MultipartFile excelFile;

	public MultipartFile getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(MultipartFile excelFile) {
		this.excelFile = excelFile;
	}
}
