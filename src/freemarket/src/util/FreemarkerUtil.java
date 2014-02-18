package util;  
  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
  
public class FreemarkerUtil {  
      
    public Template getTemplate(String dir,String name) {  
        try {  
            //ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl  
            Configuration cfg = new Configuration();  
            //�趨ȥ�����ȡ��Ӧ��ftlģ���ļ�  
            cfg.setClassForTemplateLoading(this.getClass(),dir);  
            //��ģ���ļ�Ŀ¼���ҵ�����Ϊname���ļ�  
            Template temp = cfg.getTemplate(name);  
            return temp;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    /** 
     * ����̨��� 
     * @param name 
     * @param root 
     */  
    public void print(String dir,String name,Map<String,Object> root) {  
        try {  
            //ͨ��Template���Խ�ģ���ļ��������Ӧ����  
            Template temp = this.getTemplate(dir,name);  
            temp.process(root, new PrintWriter(System.out));  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * ���HTML�ļ� 
     * @param name 
     * @param root 
     * @param outFile 
     */  
    public void fprint(String dir,String name,Map<String,Object> root,String outFile) {  
        FileWriter out = null;  
        try {  
        	File f = new File(outFile);
        	if( !f.exists() ){
        		f.getParentFile().mkdirs();  
                try{  
                    f.createNewFile();  
                }catch(IOException e){  
                    e.printStackTrace();  
                }  
        	}
            //ͨ��һ���ļ���������Ϳ���д����Ӧ���ļ��У��˴��õ��Ǿ���·��  
            out = new FileWriter(new File(outFile));  
            Template temp = this.getTemplate(dir,name);  
            temp.process(root, out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if(out!=null) out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  