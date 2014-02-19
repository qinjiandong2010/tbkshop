package junit.test;  
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import util.DBUtil;
import util.FreemarkerUtil;
import util.StringUtil;

import com.stomato.config.FtlConfig;
import com.stomato.config.FtlConfig.FtlAttribute;
import com.stomato.config.FtlConfig.FtlMetaData;
  
  
public class FreemarkerTest {  
    private static FreemarkerUtil fu;  
      
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        fu = new FreemarkerUtil();  
    }  
      
    //1��������freemarker  
    /*@Test  
    public void test01() {  
        //1���������ģ��  
        Map<String,Object> root = new HashMap<String,Object>();  
        //2��Ϊ���ģ�����ֵ  
        root.put("username", "����");  
        //3�������ģ�ͺ�ģ����ϵ�������������̨  
        fu.print("01.ftl", root);  
        fu.fprint("01.ftl", root, "01.html");  
    }  */
    /*//2.freemarker�������  
    @Test  
    public void test02() {  
        map.put("user", new User(1,"����",16));  
        sprint("03.ftl");  
        fprint("03.ftl","03.html");  
    }  
    //4.�������  
    @Test  
    public void test04() {  
        List<User> users = Arrays.asList(new User(1,"����",22),new User(2,"����",33));  
        map.put("users",users);  
        sprint("04.ftl");  
        fprint("04.ftl","04.html");  
    }  
    //5������ҳ�澲̬��  
    @Test  
    public void test05() {  
        map.put("username", "����Ա");  
        List<User> users = Arrays.asList(new User(1,"����",22),new User(2,"����",33));  
        map.put("users",users);  
        sprint("05.ftl");  
        fprint("05.ftl","05.html");  
    }  
    //6 freemarker �����ֵ  
    @Test  
    public void test06() {  
        //��ʱuser����û��group��ֵ����ʱ�����ҳ����ʾgroupֱ�ӱ���  
        //freemarker���ᴦ���ֵ  
        map.put("user",new User(1,"�ص�",22));  
        sprint("06.ftl");  
    }  
       */
    private void sprint(String dir,String name,Map<String,Object> map) {  
        fu.print(dir,name, map);  
    }  
    private void fprint(String dir,String name,String filename,Map<String,Object> map) {  
        fu.fprint(dir,name, map, filename);  
    } 
    @Test
    public void test07() {  
    	System.out.println("begin...");
    	FtlConfig bean = new FtlConfig();
    	bean.setClassName("LogSetting");
    	bean.setDomain("com.stomato");
    	bean.setBusinessName("日志配置");
    	bean.setAuthorName("Jiandong");
    	
    	bean.setMetaData( new FtlMetaData("t_logsetting","","日志配置"));
    	
    	List<FtlAttribute> attributes = new ArrayList<FtlAttribute>();
    	FtlAttribute attribute = new FtlAttribute("id","Integer","唯一主键ID",true);
    	attribute.setMetaData(new FtlMetaData("id","int","唯一主键ID"));
    	attributes.add(attribute);
    	
    	attribute = new FtlAttribute("tableName","String","表名",false);
    	attribute.setMetaData(new FtlMetaData("table_name","varchar","表名"));
    	attributes.add(attribute);
    	
    	attribute = new FtlAttribute("businessName","String","业务名称",false);
    	attribute.setMetaData(new FtlMetaData("business_name","varchar","业务名称"));
    	attributes.add(attribute);

    	attribute = new FtlAttribute("createUserId","Integer","创建用户ID",true);
    	attribute.setMetaData(new FtlMetaData("create_user_id","int","表名"));
    	attributes.add(attribute);
    	
    	attribute = new FtlAttribute("createTime","java.util.Date","创建时间",false);
    	attribute.setMetaData(new FtlMetaData("create_time","datetime","创建时间"));
    	attributes.add(attribute);

    	bean.setAttributes(attributes);
    	
        generateProject(bean);
    }
    
    private void generateProject(FtlConfig config){
    	String ftlDir = "/ftl";
        
        String projectSrcDri = "F:/JD/project_svn/adPlatform-master/trunck/project/portal/src/com/stomato";
        String projectWebDri = "F:/JD/project_svn/adPlatform-master/trunck/project/portal/WebContent/WEB-INF/views/portal";
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("bean", config);  
        fprint(ftlDir,"bean.ftl",projectSrcDri+"/domain/"+config.getClassName()+".java",map);  
        System.out.println("genernate domain finish.");
        fprint(ftlDir,"service.ftl",projectSrcDri+"/service/"+config.getClassName()+"Service.java",map);
        System.out.println("genernate service finish.");
        fprint(ftlDir,"dao.ftl",projectSrcDri+"/dao/"+config.getClassName()+"Dao.java",map);
        System.out.println("genernate dao finish.");
        fprint(ftlDir,"controller.ftl",projectSrcDri+"/controller/"+config.getClassName()+"Controller.java",map);
        System.out.println("genernate controller finish.");
        fprint(ftlDir,"form.ftl",projectSrcDri+"/form/"+config.getClassName()+"Form.java",map);
        System.out.println("genernate formbean finish.");
        fprint(ftlDir,"ibatisMap.ftl",projectSrcDri+"/dao/"+config.getClassName()+"Dao.xml",map);
        System.out.println("genernate ibatisMap xml finish.");
        fprint(ftlDir+"/web","listPage.ftl",projectWebDri+"/"+config.getClassName()+"/"+config.getClassName()+"List.jsp",map);
        System.out.println("genernate list page finish.");
        fprint(ftlDir+"/web","editPage.ftl",projectWebDri+"/"+config.getClassName()+"/"+config.getClassName()+"Edit.jsp",map);
        System.out.println("genernate edit page finish.");
        System.out.println("--generate project success.");
        
    }
    /**
     * 下划线_截取字符串，返回字符串驼峰命名
     * @param str
     * @return
     */
    private String getCamelCase(String str){
    	String []words = str.trim().split("_");
    	
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
    
    private String getDataTypeName(String dataType){
    	if(dataType.toLowerCase().equals("datetime")){
    		return "java.util.Date";
    	}else if(dataType.toLowerCase().equals("int")){
    		return "java.lang.Integer";
    	}else if(dataType.toLowerCase().equals("double")){
    		return "java.lang.Double";
    	}else if(dataType.toLowerCase().equals("float")){
    		return "java.lang.Float";
    	}else{
    		return "java.lang.String";
    	}
    }
    
   @Test  
    public void testGenerateProject() {  
	   	String tableName = "t_log_setting";
	   	String domain = "com.stomato";
    	 //创建连接
       	Connection con = DBUtil.openConn("MySql", "localhost", "3306", "adplatform", "powerall", "123456");
    		//查要生成实体类的表
       	String sql = "select * from "+tableName;
       	PreparedStatement pStemt = null;
       	try {
    			pStemt = con.prepareStatement(sql);
    			ResultSetMetaData rsmd = pStemt.getMetaData();
    			int size = rsmd.getColumnCount();	//统计列
    			List<FtlAttribute> attributes = new ArrayList<FtlAttribute>();
    			for (int i = 0; i < size; i++) {
    				String columnName = rsmd.getColumnName(i + 1);
    				String colType = rsmd.getColumnTypeName(i + 1);
    				int colSize = rsmd.getColumnDisplaySize(i + 1);
    				String schema = rsmd.getSchemaName(i + 1);
    				FtlAttribute attribute = new FtlAttribute(getCamelCase(columnName),getDataTypeName(colType),schema,false);
        	    	attribute.setMetaData(new FtlMetaData(columnName,colType,schema));
        	    	attributes.add(attribute);
    			}
    			FtlConfig config = new FtlConfig();
    			config.setClassName(StringUtil.initcap(getCamelCase(tableName.replaceFirst("t_", ""))));
    			config.setDomain(domain);
    			config.setBusinessName("日志配置");
    			config.setAuthorName("Administrator");
    			config.setMetaData( new FtlMetaData(tableName,"","日志配置"));
    			config.setAttributes(attributes);
    			
    	    	
    	        generateProject(config);
    	        
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally{
    			try {
					if( !pStemt.isClosed() ){
						pStemt.close();
					}
					if( !con.isClosed() ){
	    				con.close();
	    			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			
    		}
    }
}