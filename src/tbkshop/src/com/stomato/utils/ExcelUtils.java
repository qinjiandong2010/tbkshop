package com.stomato.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * excel工具类，使用excel模板生成excel
 * @author  jiandong
 */
public class ExcelUtils {
	
	private static final Logger logger = Logger.getLogger(ExcelUtils.class);
	/**
	 * 使用模板生成excel
	 * @param from 模板路径
	 * @param beans 值
	 * @param outputStream 输出流
	 */
	public static <T> void export2Excel(String tempFile, Map<String,T> beans,OutputStream outputStream){
		if( beans == null ){
			logger.error("beans不能为null");
			return;
		}
		XLSTransformer transformer = new XLSTransformer();
		InputStream inputStream = null;
		try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(tempFile)));
            HSSFWorkbook workbook = (HSSFWorkbook) transformer.transformXLS(inputStream, beans);
            workbook.write(outputStream);
        }catch (Exception e) {
        	logger.error(e);
		}finally{
			 if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("[@生成EXCEL失败]"+e.getMessage(), e);
                    e.printStackTrace();
                }
            }
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                logger.error("关闭流异常", e);
                e.printStackTrace();
            }
		}
	}
	/**
	 * 使用模板生成excel
	 * @param from 模板路径
	 * @param beans 值
	 * @param outputStream 输出流
	 */
	public static <T> void export2Excel(String name,String tempFile, Map<String,T> beans,HttpServletResponse response){
		response.reset();
	    response.setContentType("APPLICATION/vnd.ms-excel");
		try {
			String fileName = URLEncoder.encode(name,"UTF-8")+"-" + DateUtils.getDateStr(DateUtils.patternB);
		    response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+".xls\"");
		} catch (UnsupportedEncodingException e) {}
		try {
			export2Excel(tempFile, beans, response.getOutputStream());
		} catch (IOException e) {
			logger.error("导出Excel异常", e);
		}
	}
	
	/**
	 * 读取Excel文件
	 * @param columnNames
	 * @param filePath
	 * @return 
	 * @throws IOException
	 */
	public static List<Map<String,Object>> readExcel(String[] columnNames,String filePath) throws IOException {
		return readExcel(columnNames,  new FileInputStream(filePath));
	}
	public static List<Map<String,Object>> readExcel(String[] columnNames,InputStream fis) throws IOException {
		List<Map<String,Object>> rowList = new ArrayList<Map<String,Object>>();
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
}