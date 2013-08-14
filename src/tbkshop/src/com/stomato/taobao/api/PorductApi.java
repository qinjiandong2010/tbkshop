package com.stomato.taobao.api;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemsListGetRequest;
import com.taobao.api.request.TaobaokeItemsGetRequest;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.ItemsListGetResponse;
import com.taobao.api.response.TaobaokeItemsGetResponse;
import com.taobao.api.response.UserSellerGetResponse;
public class PorductApi {
	
     protected static String url = "http://gw.api.taobao.com/router/rest";//沙箱环境调用地址
     //正式环境需要设置为:http://gw.api.taobao.com/router/rest
     protected static String appkey = "21596630";
     protected static String appSecret = "bfce425792595f7a32e59801c676a4bc";
     protected static String sessionkey = "61008266b732eb2e0fb1e248768cbc719811d978cf7fbdb734536919"; //如 沙箱测试帐号sandbox_c_1授权后得到的sessionkey
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
     
     public static void testItemsGet(){
    	 TaobaoClient client=new DefaultTaobaoClient(url, appkey, appSecret);
    	 TaobaokeItemsGetRequest req=new TaobaokeItemsGetRequest();
    	 req.setFields("num_iid");
    	 req.setNick("jay");
    	 req.setPid(123456L);
    	 req.setKeyword("abc");
    	 req.setCid(123L);
    	 req.setStartPrice("1");
    	 req.setEndPrice("999");
    	 req.setAutoSend("true");
    	 req.setArea("杭州");
    	 req.setStartCredit("1heart");
    	 req.setEndCredit("1heart");
    	 req.setSort("price_desc");
    	 req.setGuarantee("true");
    	 req.setStartCommissionRate("1234");
    	 req.setEndCommissionRate("2345");
    	 req.setStartCommissionNum("1000");
    	 req.setEndCommissionNum("10000");
    	 req.setStartTotalnum("1");
    	 req.setEndTotalnum("10");
    	 req.setCashCoupon("true");
    	 req.setVipCard("true");
    	 req.setOverseasItem("true");
    	 req.setSevendaysReturn("true");
    	 req.setRealDescribe("true");
    	 req.setOnemonthRepair("true");
    	 req.setCashOndelivery("true");
    	 req.setMallItem("true");
    	 req.setPageNo(1L);
    	 req.setPageSize(40L);
    	 req.setOuterCode("abc");
    	 req.setIsMobile(true);
    	 req.setReferType(1L);
    	 try {
			TaobaokeItemsGetResponse response = client.execute(req);
			System.out.println("result:"+response.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public static void testItemsList(){
    	 TaobaoClient client=new DefaultTaobaoClient(url, appkey, appSecret);
    	 ItemsListGetRequest req=new ItemsListGetRequest();
    	 try {
    		 req.setFields("num_iid,title,nick,pric,itemimg");
    		 req.setNumIids("1500021875168");
    		 req.setNumIids("1500014041158");
			ItemsListGetResponse response = client.execute(req , sessionkey);
			System.out.println(response.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public static void main(String[] args) {
    	 PorductApi.testUserGet();
    	 PorductApi.testItemsGet();
    	 PorductApi.testItemsList();
	}
}
