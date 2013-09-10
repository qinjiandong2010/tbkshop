package com.stomato.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelTool {

	/**
	 * 读取Excel文件
	 * @param columnNames
	 * @param filePath
	 * @return 
	 * @throws IOException
	 */
	public static List<Map<String,Object>> readExcel(String[] columnNames,String filePath) throws IOException {
		List<Map<String,Object>> rowList = new ArrayList<Map<String,Object>>();
		FileInputStream fis = new FileInputStream(filePath); // 根据excel文件路径创建文件流
		POIFSFileSystem fs = new POIFSFileSystem(fis); // 利用poi读取excel文件流
		HSSFWorkbook wb = new HSSFWorkbook(fs); // 读取excel工作簿
		HSSFSheet sheet = wb.getSheetAt(0); // 读取excel的sheet，0表示读取第一个、1表示第二个.....
		// 获取sheet中总共有多少行数据sheet.getPhysicalNumberOfRows()
		for (int i = 0,rowNum = sheet.getPhysicalNumberOfRows(); i < rowNum; i++) {
			HSSFRow row = sheet.getRow(i + 1); // 取出sheet中的某一行数据
			if (row != null) {
				Map<String,Object> rowMap = new HashMap<String, Object>();
				// 获取该行中总共有多少列数据row.getLastCellNum()
				for (int j = 0; j < row.getLastCellNum(); j++) {
					HSSFCell cell = row.getCell((short) j); // 获取该行中的一个单元格对象
					// 判断单元格数据类型，这个地方值得注意：当取某一行中的数据的时候，需要判断数据类型，否则会报错
					// java.lang.NumberFormatException: You cannot get a
					// string
					// value from a numeric cell等等错误
					if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						rowMap.put(columnNames[j],cell.getNumericCellValue()); // 一般的数据类型在excel中读出来都为float型
					} else {
						rowMap.put(columnNames[j],cell.getStringCellValue());
					}
				}
				rowList.add(rowMap);
			}
		}
		return rowList;
	}

	public static void main(String[] args) {
		try {
			String[] columnNames = {"date","image","title","price","link","shop","s_link","comm_ratio","m_link"};
			List<Map<String,Object>> result = ExcelTool.readExcel(columnNames,"F:/project/tbkshop/src/tbkshop/WebContent/WEB-INF/report/template/2013-09-09-45443273.xls");
			for (Map<String, Object> map : result) {
				System.out.println(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
