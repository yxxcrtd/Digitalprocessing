package cn.digitalpublishing.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
/**
 * 转换成DOC
 * @author	zhouwenqian
 *
 */
@SuppressWarnings("deprecation")
public class DOCHelper {
	/**
	 * 转换成doc
	 * @param content	要转换的内容
	 * @param savePath	保存路径
	 * @param enCoding	编码
	 * @throws IOException
	 */
	public static void toDoc(String content, String savePath,String enCoding) throws IOException{
       
		FileWriterWithEncoding docWriter = null;
		try {
         
			docWriter = new FileWriterWithEncoding(savePath,enCoding);
			docWriter.write(content);
			
		} catch(Exception e){
			throw e;
		}finally{
			if(docWriter!=null){
				try {
					docWriter.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
			
    }
	public static String docToString(String doc) throws IOException{
		
		return null;
	}
	/**
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	 public static String getContent(String fileName) throws Exception {   
		 	File f = new File(fileName);
	        FileInputStream fis = new FileInputStream(f);
	        HWPFDocument doc = new HWPFDocument(fis);     
	        Range rang = doc.getRange();     
	        String text = rang.text();     
	        fis.close();     
	        return text;     
	  }  
	 /**
	  * 
	  * @param fileName
	  * @return
	  * @throws IOException
	  * @throws OpenXML4JException
	  * @throws XmlException
	  */
	 public static String extractTextFromDOC2007(String fileName) throws Exception {   
	     OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);   
	     POIXMLTextExtractor ex = new XWPFWordExtractor(opcPackage);      
	  
	        return ex.getText();   
	    }   
	public static void main(String[] args) throws Exception {
		//String aa = getContent(new File("c:\\123.docx"));
		
		String bb = extractTextFromDOC2007("c:\\123.docx");
		System.out.println(bb);
	}
	
	
}
