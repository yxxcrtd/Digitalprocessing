package cn.digitalpublishing.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * 转换成xml
 * @author	zhouwenqian
 *
 */
@SuppressWarnings("deprecation")
public class XMLHelper {
	
	public  String TEMPVAL;
	/**
	 * 转换成xml
	 * @param content	要转换的内容
	 * @param savePath	保存路径
	 * @param enCoding	编码
	 * @throws IOException	
	 */
	public static void txtToXML(String content, String savePath,String enCoding) throws IOException{
       
		XMLWriter xmlWriter = null;
		try {
			Document document = DocumentHelper.createDocument();
            Element books = DocumentHelper.createElement("books");
            document.add(books);
            Element contents = DocumentHelper.createElement("content");
            contents.setText(content);
            books.add(contents);
         
            Writer write = new OutputStreamWriter(new FileOutputStream(new File(savePath)),"UTF-8");
            xmlWriter = new XMLWriter(write,OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
			
		} catch(Exception e){
			throw e;
		}finally{
			if(xmlWriter!=null){
				xmlWriter.close();
			}
		}
			
    }
	
	/**
	 * dom4j解析XML
	 * @param xmlPath	文件路径 
	 * @throws Exception
	 */
	public  String parseXml(String xmlPath)throws Exception{  
		String xmlContent ;
		String rootContent = null;
		String sonsContent = null;
		
        File xmlFile = new File(xmlPath);  
       
        if(xmlFile.exists()){  
            SAXReader reader = new SAXReader();  
            //读入文档流  
            Document document = reader.read(xmlFile);  
            //获取根节点  
            Element root = document.getRootElement();
            rootContent = root.getName()+":\n";
            String count="  ";
            TEMPVAL = rootContent;
            getSonElement(root,count);
            TEMPVAL.trim();
        }
        return TEMPVAL;
    }  
	
	public  void getSonElement(Element ele,String count){
		List sons=ele.elements();
		 String content = null;
		  if(0!=sons.size()){
		   for(Iterator i=ele.elementIterator();i.hasNext();){
		    Element son=(Element) i.next();
		    String sum=count+"  ";
		    TEMPVAL+=son.getName().trim()+":"+son.getText().trim()+"\n";
		    getSonElement(son,sum);
		   }
		  }
	}
}
