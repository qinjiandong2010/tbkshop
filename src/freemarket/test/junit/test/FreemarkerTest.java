package junit.test;  
  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

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
    @Test  
    public void test01() {  
        //1、创建数据模型  
        Map<String,Object> root = new HashMap<String,Object>();  
        //2、为数据模型添加值  
        root.put("username", "张三");  
        //3、将数据模型和模板组合的数据输出到控制台  
        fu.print("01.ftl", root);  
        fu.fprint("01.ftl", root, "01.html");  
    }  
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
    private void sprint(String name) {  
        fu.print(name, map);  
    }  
    private void fprint(String name,String filename) {  
        fu.fprint(name, map, filename);  
    } 
    @Test  
    public void test07() {  
        map.put("tableName", "LogSetting");  
        List<Map<String,Object>> columnList = new ArrayList<Map<String,Object>>(); 
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("name", "id");
        dataMap.put("dataType", "Integer");
        dataMap.put("description", "primary key");
        columnList.add(dataMap);
        
        map.put("columnList",columnList);  
        sprint("bean.ftl");  
        fprint("bean.ftl","D:/project/freemarket/src/bean/LogSetting.java");  
    }  
}