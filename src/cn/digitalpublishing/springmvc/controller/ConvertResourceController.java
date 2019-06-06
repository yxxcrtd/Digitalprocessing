package cn.digitalpublishing.springmvc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.ConvertResource;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.springmvc.form.ConvertForm;
import cn.digitalpublishing.springmvc.form.ResourceForm;
import cn.digitalpublishing.util.DOCHelper;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.AsianFontMapper;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * 
 */
@Controller
@RequestMapping("/pages/convertresource")
public class ConvertResourceController extends BaseController {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("convertresource/convertresourceList.ftl");
	}

	/**
	 * 资源列表
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	public ConvertForm manager(ConvertForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		String fileType = form.getFileType();
		String fileName = form.getFileName();
		if(fileType!=null&&!"".equals(fileType)){
			condition.put("fileType", fileType);
		}
		
		if(fileName!=null&&!"".equals(fileName)){
			condition.put("fileName", "%"+fileName+"%");
		}
		
		List<ConvertResource> list = new ArrayList<ConvertResource>();
		
		try {
			form.setiTotalRecords(this.convertResourceService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (form.getiTotalRecords() > 0) {
				list = this.convertResourceService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		form.setAaData(list);
		return form;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/resourceindex")
	public ModelAndView resourceindex() throws Exception {
		String forwardString = "convertresource/resource.ftl";
		return new ModelAndView(forwardString);
	}

	/**
	 * 资源列表
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/resourcemanager", headers = "Accept=application/json")
	public ResourceForm resourcemanager(ResourceForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		
		List<Resource> list = new ArrayList<Resource>();
		
		try {
			form.setiTotalRecords(this.resourceService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (0 < form.getiTotalRecords()) {
				list = this.resourceService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		form.setAaData(list);
		return form;
	}
	
	@RequestMapping(value="/form/convertinit")
	public ModelAndView convertinit(ConvertForm form)throws Exception {
		forwardString="convertresource/convertinit.ftl";
		Map<String,Object> model = new HashMap<String,Object>();
		String id = request.getParameter("id");
		try{
			form.setId(id);
			model.put("form", form);
		}catch(Exception e){
            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
			forwardString="error";
		}
		return new ModelAndView(forwardString,model);
	}
	
	@ResponseBody
	@RequestMapping(value="/form/convert")
	public ConvertForm convert(ConvertForm form)throws Exception {
		ConvertResource convertResource = form.getObj();
		String resourceid = request.getParameter("id");
		try{
			//查询转换记录 如果记录存在 则调用删除方法 条件是 resourceid 和 文件类型
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resourceid", resourceid);
			map.put("fileType", convertResource.getFileType());
			List<ConvertResource> list = this.convertResourceService.getList(map, "");
			
			if(list!=null&&list.size()>0){
				ConvertResource delObj = list.get(0);
				this.convertResourceService.delete(delObj.getId());
			}
			
			Resource resource = this.resourceService.findById(resourceid);
			Set<XmlNode> xmlNodeList = resource.getNode();
			String fileNameContent = resource.getResourceName();
			fileNameContent = fileNameContent.substring(0,fileNameContent.indexOf(".xml"));
			StringBuffer sb = new StringBuffer(fileNameContent);
			sb.append("\n");
			for (XmlNode xmlNode : xmlNodeList) {
				String nodeval = xmlNode.getNodeValue();
				if(nodeval!=null&&!"".equals(nodeval)){
					sb.append(xmlNode.getNodeValue());
					sb.append("\n");
				}
			}
			File f = new File("");
			String fileName = null;
			//查询数据节点集合
			if(".pdf".equals(convertResource.getFileType())){
				f = new File(resource.getFilePath()+File.separator+"pdf");
				fileName = resource.getResourceName().replace(".xml", ".pdf");
				if(!f.exists()){
					f.mkdirs();
				}
				FileOutputStream os = new FileOutputStream(f.toString()+File.separator+fileName);
				Document document = new Document();
				BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				Font fontChinese =  new  Font(baseFontChinese , 12 , Font.NORMAL);
				PdfWriter.getInstance(document, os);
				document.open();
				document.add(new Paragraph(sb.toString(),fontChinese));
				document.close();
				
			}else if(".doc".equals(convertResource.getFileType())){
				f = new File(resource.getFilePath()+File.separator+"doc");
				if(!f.exists()){
					f.mkdirs();
				}
				fileName = resource.getResourceName().replace(".xml", ".doc");
				DOCHelper.toDoc(sb.toString(), f.toString()+File.separator+fileName, "UTF-8");
			}
			//封装属性
			convertResource.setFileName(fileName);
			convertResource.setFilePath(f.toString());
			convertResource.setUpdateDate(new Date());
			convertResource.setResource(resource);
			//保存转换记录
			this.convertResourceService.insert(convertResource);
			form.setIsSuccess(SUCCESS);
			form.setMsg("转换成功");
		}catch(Exception e){
			e.printStackTrace();
            form.setIsSuccess("err");
            form.setMsg("转换失败");
		}
		form.setObj(null);
		return form;
	}
	
	@RequestMapping(value="/form/readonline")
	public ModelAndView readonline()throws Exception {
		String id = request.getParameter("id");
		ConvertResource converResource = this.convertResourceService.findById(id);
		if(converResource!=null){
			if(".pdf".equals(converResource.getFileType())){
				response.setContentType("application/pdf");  
			}else{
				response.setContentType("application/msword");  
			}
		  
		   try {  
		    String strPdfPath = new String(converResource.getFilePath()+File.separator+converResource.getFileName());
		    System.out.println(strPdfPath);
		    //判断该路径下的文件是否存在  
		    File file = new File(strPdfPath);  
		    if (file.exists()) {  
		     DataOutputStream temps = new DataOutputStream(response  
		       .getOutputStream());  
		     DataInputStream in = new DataInputStream(  
		       new FileInputStream(strPdfPath));  
		  
		     byte[] b = new byte[2048];  
		     while ((in.read(b)) != -1) {  
		      temps.write(b);  
		      temps.flush();  
		     }  
		  
		     in.close();  
		     temps.close();  
		    }  
		  
		   } catch (Exception e) {  
		   }  
		}
		return new ModelAndView("convertresource/readonline.jsp");
	}
}
