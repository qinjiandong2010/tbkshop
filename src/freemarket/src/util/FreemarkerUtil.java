package util;  
  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
  
public class FreemarkerUtil {  
      
    public Template getTemplate(String dir,String name) {  
        try {  
            Configuration cfg = new Configuration();  
            cfg.setClassForTemplateLoading(this.getClass(),dir);  
            cfg.setDefaultEncoding("UTF-8");
            Template temp = cfg.getTemplate(name);  
            return temp;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    /** 
     * @param name 
     * @param root 
     */  
    public void print(String dir,String name,Map<String,Object> root) {  
        try {  
            Template temp = this.getTemplate(dir,name);  
            temp.process(root, new PrintWriter(System.out));  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * @param name 
     * @param root 
     * @param outFile 
     */  
    public void fprint(String dir,String name,Map<String,Object> root,String outFile) {  
        Writer out = null;  
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
        	//通过一个文件输出流，就可以写到相应的文件中
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8")); 
            Template temp = this.getTemplate(dir,name);
            temp.setEncoding("UTF-8");
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