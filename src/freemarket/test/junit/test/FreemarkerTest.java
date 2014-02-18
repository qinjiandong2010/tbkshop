package junit.test;  
  
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import bean.FtlConfig;
import bean.FtlConfig.FtlAttribute;

import util.DBUtil;
import util.FreemarkerUtil;
  
  
public class FreemarkerTest {  
    private static FreemarkerUtil fu;  
    private static Map<String,Object> map = null;  
      
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        fu = new FreemarkerUtil();  
        map = new HashMap<String,Object>();  
    }  
      
    //1、创建简单freemarker  
    /*@Test  
    public void test01() {  
        //1、创建数据模型  
        Map<String,Object> root = new HashMap<String,Object>();  
        //2、为数据模型添加值  
        root.put("username", "张三");  
        //3、将数据模型和模板组合的数据输出到控制台  
        fu.print("01.ftl", root);  
        fu.fprint("01.ftl", root, "01.html");  
    }  */
    /*//2.freemarker输出对象  
    @Test  
    public void test02() {  
        map.put("user", new User(1,"李四",16));  
        sprint("03.ftl");  
        fprint("03.ftl","03.html");  
    }  
    //4.输出数组  
    @Test  
    public void test04() {  
        List<User> users = Arrays.asList(new User(1,"张三",22),new User(2,"李四",33));  
        map.put("users",users);  
        sprint("04.ftl");  
        fprint("04.ftl","04.html");  
    }  
    //5、将包含页面静态化  
    @Test  
    public void test05() {  
        map.put("username", "管理员");  
        List<User> users = Arrays.asList(new User(1,"张三",22),new User(2,"李四",33));  
        map.put("users",users);  
        sprint("05.ftl");  
        fprint("05.ftl","05.html");  
    }  
    //6 freemarker 处理空值  
    @Test  
    public void test06() {  
        //此时user对象并没有group的值，这时如果在页面显示group直接报错  
        //freemarker不会处理空值  
        map.put("user",new User(1,"地点",22));  
        sprint("06.ftl");  
    }  
       */
    private void sprint(String dir,String name) {  
        fu.print(dir,name, map);  
    }  
    private void fprint(String dir,String name,String filename) {  
        fu.fprint(dir,name, map, filename);  
    } 
    public void test07() {  
    	System.out.println("开始生成代码.");
    	FtlConfig bean = new FtlConfig();
    	bean.setClassName("LogSetting");
    	bean.setPackagePath("");
    	bean.setBusinessName("日志配置");
    	bean.setAuthorName("Jiandong");
    	
    	List<FtlAttribute> attributes = new ArrayList<FtlAttribute>();
    	attributes.add(new FtlAttribute("id","Integer","日志ID",true));
    	attributes.add(new FtlAttribute("tableName","String","表名",false));
    	attributes.add(new FtlAttribute("businessName","String","业务名称",false));
    	attributes.add(new FtlAttribute("createUserId","Integer","创建用户ID",true));
    	attributes.add(new FtlAttribute("createTime","Date","创建时间",true));
    	bean.setAttributes(attributes);
    	
        map.put("bean", bean);  
        String ftlDir = "/ftl";
        
        fprint(ftlDir,"bean.ftl","D:/jiandong/project/tbkshop/src/freemarket/src/bean/LogSetting.java");  
        fprint(ftlDir,"service.ftl","D:/jiandong/project/tbkshop/src/freemarket/src/service/LogSettingService.java");  
        fprint(ftlDir,"dao.ftl","D:/jiandong/project/tbkshop/src/freemarket/src/dao/LogSettingDao.java");
        fprint(ftlDir,"controller.ftl","D:/jiandong/project/tbkshop/src/freemarket/src/controller/LogSettingController.java");
        fprint(ftlDir,"form.ftl","D:/jiandong/project/tbkshop/src/freemarket/src/form/LogSettingForm.java");

        fprint(ftlDir+"/web","listPage.ftl","D:/jiandong/project/tbkshop/src/freemarket/web/logSeting/LogSettingList.jsp");
        fprint(ftlDir+"/web","editPage.ftl","D:/jiandong/project/tbkshop/src/freemarket/web/logSeting/LogSettingEdit.jsp");
        System.out.println("生成完成.");
    } 
    @Test  
    public void testGenerateProject() {  
    	Connection conn = DBUtil.openConn("MySQL", "localhost", "3306", "adplatform", "root", "123456");
    
    	DBUtil.query
    }
}