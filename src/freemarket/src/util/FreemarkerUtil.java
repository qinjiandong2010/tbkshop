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
            //通过Freemaker的Configuration读取相应的ftl  
            Configuration cfg = new Configuration();  
            //设定去哪里读取相应的ftl模板文件  
            cfg.setClassForTemplateLoading(this.getClass(),dir);  
            //在模板文件目录中找到名称为name的文件  
            Template temp = cfg.getTemplate(name);  
            return temp;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    /** 
     * 控制台输出 
     * @param name 
     * @param root 
     */  
    public void print(String dir,String name,Map<String,Object> root) {  
        try {  
            //通过Template可以将模板文件输出到相应的流  
            Template temp = this.getTemplate(dir,name);  
            temp.process(root, new PrintWriter(System.out));  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 输出HTML文件 
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
            //通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径  
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