package com.stomato.utils;


/**
 * 字符串处理工具类
 * 
 * @author Duke-Alliance Team
 * @since JDK1.6
 * @version 1.0
 * @history 2013-7-23 create
 */
public class StringUtil extends StringUtils {

	/**
	 * 判断字符串是否有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean hasChinese(String str) {
		if (str == null) {
			return false;
		}
		if (str.getBytes().length != str.length()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符是否为 null 或 空字符串
	 * 
	 * @param str
	 * @return if "str" is null or empty then return true else return false
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (null == obj || obj.toString().trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符是否为 null 或 空字符串
	 * 
	 * @param str
	 * @return str
	 */
	public static String NullOrEmpty(String str) {
		try {
			if (str == null) {
				return "";
			} else {
				str = str.trim();
				str = new String( str.getBytes( "ISO-8859-1" ) , "UTF-8" );
			}
		} catch (Exception e) {

		}
		return str;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param x
	 * @return
	 */
	public static int[] bubbleSort(int[] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] > x[j]) {
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
		return x;
	}
}
