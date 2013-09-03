package com.stomato.constant;

public interface Constant {
	
	public static final String BUILD_EXAMPLE_ANDROID_PACKAGE = "BUILD_EXAMPLE_ANDROID_PACKAGE";
	public static final String fileSeparator = System.getProperty("file.separator");

	/**
	 * 系统公共配置
	 */
	public interface SYS_CONFIG {
		String DEFAULT_LANGUAGE = "en_US";
		/** 用户登录后的Session Key */
		String LOGIN_SESSION_KEY = "__SYSTEM_USER_SESSION_KEY__";
		/** session 过期时间为20分钟 */
		int LOGIN_SESSION_INVALIDATE = 1200;

		long PAGE_SIZE = 20;
	}
	//系统配置
	interface Configs {

		String uploadDirPath = "upload";
		
		String brandDirPath = "brand";

		String tmpsDirPath = "tmps";
		
		String filesDirPath = "files_path";
		
		String iconDir = "icon";

	}
	
	//Brand状态
	interface BrandStatus {
		//可用
		int usable = 1;
		//禁用
		int disable = 0;
		
	}

	//用户状态
	interface UserStatus{
		int newRegist = 3;

		int noPASS = 0;
		
		int approved = 1;
	}
}
