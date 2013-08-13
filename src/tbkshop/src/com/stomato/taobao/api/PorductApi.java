package com.stomato.taobao.api;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.UserSellerGetResponse;
public class PorductApi {
	
     protected static String url = "http://gw.api.tbsandbox.com/router/rest";//沙箱环境调用地址
     //正式环境需要设置为:http://gw.api.taobao.com/router/rest
     protected static String appkey = "test";
     protected static String appSecret = "test";
     protected static String sessionkey = "test"; //如 沙箱测试帐号sandbox_c_1授权后得到的sessionkey
     public static void testUserGet() {
         TaobaoClient client = new DefaultTaobaoClient(url, appkey, appSecret);//实例化TopClient类
         UserSellerGetRequest req = new UserSellerGetRequest();//实例化具体API对应的Request类
         req.setFields("nick,user_id,type");
         //req.setNick("sandbox_c_1");
         UserSellerGetResponse response;
         try {
             response = client.execute(req,sessionkey); //执行API请求并打印结果
             System.out.println("result:"+response.getBody());
          
         } catch (ApiException e) {
         // deal error
         }
     }
     public static void main(String[] args) {
    	 PorductApi.testUserGet();
	}
}
