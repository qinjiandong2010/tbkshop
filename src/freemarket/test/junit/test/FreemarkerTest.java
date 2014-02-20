package junit.test;  
  
import java.sql.Connection;
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

import com.stomato.config.TableSchema;
import com.stomato.config.TableSchema.ColumnsSchema;
  
  
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
    private void generateProject(TableSchema table){
    	String ftlDir = "/ftl";
        
        String projectSrcDri = "D:/jiandong/project/adPlatform-master/trunck/project/portal/src/com/stomato";
        String projectWebDri = "D:/jiandong/project/adPlatform-master/trunck/project/portal/WebContent/WEB-INF/views/portal";
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("bean", table);  
        fprint(ftlDir,"bean.ftl",projectSrcDri+"/domain/"+table.getName()+".java",map);  
        System.out.println("genernate domain finish.");
        fprint(ftlDir,"service.ftl",projectSrcDri+"/service/"+table.getName()+"Service.java",map);
        System.out.println("genernate service finish.");
        fprint(ftlDir,"dao.ftl",projectSrcDri+"/dao/"+table.getName()+"Dao.java",map);
        System.out.println("genernate dao finish.");
        fprint(ftlDir,"controller.ftl",projectSrcDri+"/controller/"+table.getName()+"Controller.java",map);
        System.out.println("genernate controller finish.");
        fprint(ftlDir,"form.ftl",projectSrcDri+"/form/"+table.getName()+"Form.java",map);
        System.out.println("genernate formbean finish.");
        fprint(ftlDir,"formParam.ftl",projectSrcDri+"/form/"+table.getName()+"FormParam.java",map);
        System.out.println("genernate formbean finish.");
        fprint(ftlDir,"ibatisMap.ftl",projectSrcDri+"/dao/"+table.getName()+"Dao.xml",map);
        System.out.println("genernate ibatisMap xml finish.");
        fprint(ftlDir+"/web","listPage.ftl",projectWebDri+"/"+table.getNameI()+"/"+table.getNameI()+"List.jsp",map);
        System.out.println("genernate list page finish.");
        fprint(ftlDir+"/web","editPage.ftl",projectWebDri+"/"+table.getNameI()+"/"+table.getNameI()+"Edit.jsp",map);
        System.out.println("genernate edit page finish.");
        fprint(ftlDir+"/web","addPage.ftl",projectWebDri+"/"+table.getNameI()+"/"+table.getNameI()+"Form.jsp",map);
        System.out.println("genernate add page finish.");
        System.out.println("--generate project success.");
        
    }
   @Test  
    public void testGenerateProject() throws SQLException {  
	   	String tableName = "t_log_operation";
	   	String domain = "com.stomato";
    	 //创建连接
       	Connection conn = DBUtil.openConn("MySql", "localhost", "3306", "information_schema", "root", "");
    	//查要生成实体类的表
       	String schemaTableSql = "select * from TABLES where TABLE_SCHEMA='adplatform' and TABLE_NAME=?";
       	String schemaColumnSql = "select * from COLUMNS where TABLE_SCHEMA='adplatform' and TABLE_NAME=?";
       	try {
       		Map<String, Object> tMetaData = DBUtil.queryMap(conn, schemaTableSql, tableName);
       		TableSchema table = new TableSchema();
       		table.setDomain(domain);
       		table.setName(tMetaData.get("TABLE_NAME").toString());
       		table.setComment(tMetaData.get("TABLE_COMMENT").toString());
       		table.setAuthorName("Administrator");

			List<ColumnsSchema> attributes = new ArrayList<ColumnsSchema>();
			List<Map<String, Object>> columnsMetaData = DBUtil.queryMapList(conn, schemaColumnSql, tableName);
			for (Map<String, Object> columnMetaData : columnsMetaData) {
				String columnName = columnMetaData.get("COLUMN_NAME")+"";
				String colType = columnMetaData.get("DATA_TYPE")+"";
				boolean isNull = Boolean.parseBoolean(columnMetaData.get("IS_NULLABLE")+"");
				int colSize =StringUtil.getIntParameter(columnMetaData,"CHARACTER_MAXIMUM_LENGTH");
				boolean priKey =StringUtil.getStringParameter(columnMetaData,"COLUMN_KEY",true).equals("PRI") ? true : false;
				String comment = columnMetaData.get("COLUMN_COMMENT")+"";
				ColumnsSchema attribute = new ColumnsSchema();
				attribute.setName(columnName);
				attribute.setDataType(colType);
				attribute.setLength(colSize);
				attribute.setNull(isNull);
				attribute.setPriKey(priKey);
				attribute.setComment(comment);
				
    	    	attributes.add(attribute);
			}
			table.setColumns(attributes);
			
    		generateProject(table);
		}catch (Exception err){
			err.printStackTrace();
		} finally{
			try {
				if( !conn.isClosed() ){
					conn.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
    }
}