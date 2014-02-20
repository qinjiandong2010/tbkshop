package util;

import java.util.Map;

public class StringUtil {

	/**
     * 下划线_截取字符串，返回字符串驼峰命名
     * @param str
     * @return
     */
    public static String getCamelCase(String str){
    	String []words = str.trim().replaceFirst("t_", "").split("_");
    	
    	String camelCaseStr = "";
    	for (int i = 0; i < words.length; i++) {
    		if( i == 0 ){
    			camelCaseStr = words[i];
    		}else{
    			camelCaseStr += StringUtil.initcap(words[i]);
    		}
		}
    	return camelCaseStr;
    }
    
	public static String initcap(String str) {
		
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		
		return new String(ch);
	}
	

	public static int getIntParameter(Map<String,Object> map,String key) {
		Object value = map.get(key);
		if (value != null) {
			try {
				return Integer.parseInt((value+"").trim());
			} catch (Exception e) {
				return 0;
			}
		}
		return 0;
	}
	public static long getLongParameter(Map<String,Object> map,String key) {
		Object value = map.get(key);
		if (value != null) {
			try {
				return Long.parseLong((value+"").trim());
			} catch (Exception e) {
				return 0L;
			}
		}
		return 0L;
	}
	public static boolean getBooleanParameter(Map<String,Object> map,String key) {
		Object value = map.get(key);
		if (value != null) {
			try {
				return Boolean.parseBoolean((value+"").trim());
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	public static String getStringParameter(Map<String,Object> map,String key, boolean isNull) throws Exception {
		Object value = map.get(key);
		if ((value+"").isEmpty()) {
			if (!isNull) {
				throw new Exception("值不能为空");
			} else {
				return "";
			}
		} else {
			return value+"";
		}
	}
}
