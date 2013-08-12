package com.stomato.constant;

public interface Constant {
	
	public static final String BUILD_EXAMPLE_ANDROID_PACKAGE = "BUILD_EXAMPLE_ANDROID_PACKAGE";
	public static final String fileSeparator = System.getProperty("file.separator");
	
	//系统配置
	interface Configs {
		String credentialsDirPath = "credentials";

		String adresourceDirPath = "adresource";

		String appsDirPath = "apps";

		String tmpsDirPath = "tmps";
		
		String filesDirPath = "files_path";
		
		String appIconDirSuffix = "Icons";
		
		String appDirSuffix = "Dir";

		String appIconDir = "icon";

	}
	
	//App状态
	interface AppStatus {
		int infoCompleted = 1;
		
		int sdkInstalled = 2;
		
	}
	
	//Credential 证件类型
	interface CredentialsType{
		int identityCard = 1;
		int businessLicense = 2;
	}
	//用户状态
	interface UserStatus{
		int newRegist = 3;

		int noPASS = 0;
		
		int approved = 1;
	}
	//广告资源状态
	interface AdResourceStatus{
		//上架
		int onShelf = 1;
		//下架
		int offShelf = 0;
	}
	//广告推送控制
	interface AdPushStatus{
		boolean open = true;
		boolean close = false;
	}
}