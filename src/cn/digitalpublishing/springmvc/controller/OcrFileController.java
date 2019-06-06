package cn.digitalpublishing.springmvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.config.ProcessQueue;
import cn.digitalpublishing.po.OcrFiles;
import cn.digitalpublishing.springmvc.form.OcrFileForm;
import cn.digitalpublishing.util.DOCHelper;
import cn.digitalpublishing.util.PdfHelper;
import cn.digitalpublishing.util.XMLHelper;

/**
 * Ocr文件管理
 * 
 * @author zhouwenqian
 */
@Controller
@RequestMapping("/pages/OcrFileManage")
public class OcrFileController extends BaseController {

	/**
	 * 显示首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {

		String forwardString = "OcrFileManage/OcrFileList.ftl";

		return new ModelAndView(forwardString);

	}

	/**
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	public OcrFileForm manager(OcrFileForm form) throws Exception {

		Map<String, Object> condition = form.getCondition();
		List<OcrFiles> list = new ArrayList<OcrFiles>();

		try {
			form.setiTotalRecords(this.ocrFileService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (0 < form.getiTotalRecords()) {
				list = this.ocrFileService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		form.setAaData(list);
		return form;
	}

	/**
	 * 删除
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/form/delete")
	public OcrFileForm delete(OcrFileForm form) throws Exception {
		String id = request.getParameter("id");
		try {
			this.ocrFileService.delete(id);
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getMessage() : e.getMessage());
		}
		return form;
	}

	/**
	 * 修改页
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/edit")
	public ModelAndView edit(OcrFileForm form) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		forwardString = "OcrFileManage/OcrFileEdit.ftl";
		try {
			System.out.println(form.getId());
			if (null != form.getId() && !"".equals(form.getId())) {
				OcrFiles ocrFiles = this.ocrFileService.findbyid(form.getId());
				form.setObj(ocrFiles);
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		map.put("form", form);
		return new ModelAndView(forwardString, map);
	}

	/**
	 * 修改后保存
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/editSubmit")
	public ModelAndView editSubmit(OcrFileForm form) throws Exception {

		OcrFiles ocrFiles = form.getObj();
		try {
			this.ocrFileService.update(ocrFiles, ocrFiles.getId(), null);
			form.setMsg("修改成功");
			form.setIsSuccess(SUCCESS);

		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		return new ModelAndView("redirect:/pages/OcrFileManage/form/index");
	}

	/**
	 * 转换选择层
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/transform")
	public ModelAndView transform() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String forwardString = "OcrFileManage/OcrFileTransform.ftl";
		model.put("id", id);
		return new ModelAndView(forwardString, model);
	}

	/**
	 * 转换
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/transformSubmit")
	public ResponseEntity<byte[]> transformSubmit(OcrFileForm form)
			throws Exception {

		String id = form.getObj().getId();

		int formatFlag = form.getFormatFlag();

		byte[] data = null;
		HttpHeaders header = new HttpHeaders();

		String filePath = "";
		try {
			// 获取待转换的内容
			OcrFiles ocrFiles = this.ocrFileService.findbyid(id);
			String content = ocrFiles.getContent();
			String fileName = "";
			switch (formatFlag) {
			// 转换成pdf
			case 1:
				// 转换成html文件，并存储
				content = PdfHelper.stringHTML(content);
				File htmlFile = new File(ProcessQueue.WEBROOT + File.separator
						+ ProcessQueue.UPLOADROOT + File.separator
						+ ProcessQueue.HTMLPATH);
				if (!htmlFile.exists()) {
					htmlFile.mkdirs();
				}
				String htmlPath = htmlFile + File.separator + id + ".html";
				PdfHelper.createHTML(htmlPath, content, "UTF-8");
				// 转换成pdf文件，并存储
				File pdfFile = new File(ProcessQueue.WEBROOT + File.separator
						+ ProcessQueue.UPLOADROOT + File.separator
						+ ProcessQueue.PDFPATH);
				if (!pdfFile.exists()) {
					pdfFile.mkdirs();
				}
				fileName = ocrFiles.getFileName().replace(".txt", "") + ".pdf";
				filePath = pdfFile + File.separator + id + ".pdf";
				this.pdfService.createPDF(htmlPath, filePath, "UTF-8");
				break;
			// 转换成xml
			case 2:
				File xmlFile = new File(ProcessQueue.WEBROOT + File.separator
						+ ProcessQueue.UPLOADROOT + File.separator
						+ ProcessQueue.XMLPATH);
				content = ocrFiles.getContentNoStyle();
				if (!xmlFile.exists()) {
					xmlFile.mkdirs();
				}
				fileName = ocrFiles.getFileName().replace(".txt", "") + ".xml";
				filePath = xmlFile + File.separator + id + ".xml";
				XMLHelper.txtToXML(content, filePath, "UTF-8");
				break;
			// 转换成doc
			case 3:
				File docFile = new File(ProcessQueue.WEBROOT + File.separator
						+ ProcessQueue.UPLOADROOT + File.separator
						+ ProcessQueue.DOCPATH);
				content = ocrFiles.getContentNoStyle();
				if (!docFile.exists()) {
					docFile.mkdirs();
				}
				fileName = ocrFiles.getFileName().replace(".txt", "") + ".doc";
				filePath = docFile + File.separator + id + ".doc";
				DOCHelper.toDoc(content, filePath, "UTF-8");
				break;
			}

			String name = new String(fileName.getBytes("gbk"), "iso-8859-1");

			header.setContentType(MediaType
					.parseMediaType("application/x-msdownload"));

			header.set("Content-Disposition", "attachment; filename=" + name);

			data = FileUtils.readFileToByteArray(new File(filePath));

			form.setMsg("转换成功");
			form.setIsSuccess(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
			forwardString = "msg";
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}

		return new ResponseEntity<byte[]>(data, header, HttpStatus.OK);
	}

	/**
	 * 在线预览
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/form/preview")
	public ModelAndView preview()throws Exception {
		String id = request.getParameter("id");
		OcrFiles ocrFile = this.ocrFileService.findbyid(id);
		String filePath = ocrFile.getOriginalFilePath();
		int filePathLen = filePath.length();
		String fileType = filePath.substring(filePathLen-4, filePathLen);
		
		if(filePath!=null){
			if(".pdf".equals(fileType)){
				response.setContentType("application/pdf");  
			}
			 else {
				response.setHeader("Content-Disposition",
						"attachment;filename=" + filePath.substring(filePath.indexOf("\\")+1, filePath.length()));
			}
			OutputStream os = null ;
			InputStream in = null ;
		   try {  
			    String strPdfPath = filePath;
			    File file = new File(strPdfPath);  
			    if (file.exists()) {  
			     os =response.getOutputStream();  
			     in	= new FileInputStream(strPdfPath);  
			     byte[] b = new byte[2048];  
			     while ((in.read(b)) != -1) {  
			     os.write(b);  
		            
			     }  
		  
		    }  } catch (Exception e) {  
			   e.printStackTrace();
		   }finally{
			   if(os!= null){
				   os.close();
			   }
			   if(in!= null){
				   in.close();
			   }
		   }
		}
			
		return new ModelAndView("OcrFileManage/preview.jsp");
	}	
}
