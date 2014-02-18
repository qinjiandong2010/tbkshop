package util;

public class StringUtil {

	/**
	 * 功能：将输入字符串的首字母改成大写
	 * @param str
	 * @return
	 */
	public static String initcap(String str) {
		
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		
		return new String(ch);
	}
}
