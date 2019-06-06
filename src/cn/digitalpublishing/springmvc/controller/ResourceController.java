package cn.digitalpublishing.springmvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.config.ProcessQueue;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.springmvc.form.ResourceForm;
import cn.digitalpublishing.util.DOCHelper;
import cn.digitalpublishing.util.FileUtil;
import cn.digitalpublishing.util.PdfHelper;
import cn.digitalpublishing.util.TreeNode;
import cn.digitalpublishing.util.XMLHelper;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * 
 * @author jinyanjiang
 */
@Controller
@RequestMapping("/pages/resource")
public class ResourceController extends BaseController {


	/**
	 * 所有的资源
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		String forwardString = "resource/resource.ftl";
		return new ModelAndView(forwardString);
	}
	/**
	 * 正常的资源
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/statusIs3")
	public ModelAndView statusIs3() throws Exception {
		String forwardString = "resource/resourceStatusIs3.ftl";
		return new ModelAndView(forwardString);
	}
	
	
	@RequestMapping("/form/indexList")
	public ModelAndView indexList() throws Exception {
		String forwardString = "resource/show";
		String resourceid = request.getParameter("xmlId");
		request.setAttribute("xmlId", resourceid);
		return new ModelAndView(forwardString);
	}
	
	@RequestMapping("/form/editResourceContent")
	public ModelAndView editResourceContent(ResourceForm form) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		forwardString = "resource/resourceContentEdit.ftl";
		try {
			System.out.println(form.getId());
			if (null != form.getId() && !"".equals(form.getId())) {
				
				Resource resource = this.resourceService.findById(form.getId());
				System.out.println("判断前============="+resource.getFlag());
				
				if(resource.getFlag()==null){
					
					String filePath = resource.getFilePath()+ resource.getBookName();
					
					String fileName = resource.getBookName().toLowerCase();
					
					System.out.println(filePath);
					
					String resourceContent = "";
					System.out.println(fileName.endsWith(".pdf"));
					if(fileName.endsWith(".pdf")){
						resourceContent = PdfHelper.getText(new File(filePath));
						System.out.println(resourceContent);
					}else if(fileName.endsWith(".doc")){
						
						resourceContent = DOCHelper.getContent(filePath);
						System.out.println(resourceContent);
						
					}else if(fileName.endsWith(".docx")){
						
						resourceContent = DOCHelper.extractTextFromDOC2007(filePath);
						System.out.println(resourceContent);
					}else if(fileName.endsWith(".txt")){
						
						resourceContent = FileUtil.txtToString(filePath, "UTF-8");
						System.out.println(resourceContent);
					}
					
					
					resource.setResouceContent(resourceContent);
					
					System.out.println("判断后============="+resource.getFlag());
					
					resource.setFlag(1);
					
					System.out.println("设置后============="+resource.getFlag());
					
				}else{
					resource.getResouceContent();
				}
				
				form.setObj(resource);
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
	@RequestMapping("/form/editResourceContentSubmit")
	public ModelAndView editResourceContentSubmit(ResourceForm form)throws Exception {
		
		Resource resource = form.getObj();
		try {
			this.resourceService.update(resource, resource.getId(), null);
			form.setMsg("修改成功");
			form.setIsSuccess(SUCCESS);

		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}

		return new ModelAndView("redirect:/pages/resource/form/statusIs3");
	}
	/**
	 * 所有资源列表
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	public ResourceForm manager(ResourceForm form) throws Exception {

		Map<String, Object> condition = form.getCondition();

		if (form.getKeyWord() != null && !"".equals(form.getKeyWord())) {
			condition.put("keyWord", "%" + form.getKeyWord() + "%");
		}

		if (form.getResourceName() != null
				&& !"".equals(form.getResourceName())) {
			condition.put("resourceName", "%" + form.getResourceName() + "%");

		}


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
	
	/**
	 * 正常资源列表
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/stautsIs3Manager", headers = "Accept=application/json")
	public ResourceForm stautsIs3Manager(ResourceForm form) throws Exception {

		Map<String, Object> condition = form.getCondition();

		if (form.getKeyWord() != null && !"".equals(form.getKeyWord())) {
			condition.put("keyWord", "%" + form.getKeyWord() + "%");
		}

		if (form.getResourceName() != null
				&& !"".equals(form.getResourceName())) {
			condition.put("resourceName", "%" + form.getResourceName() + "%");

		}

		condition.put("status", 3);

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


	/**
	 * 删除
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/delete", headers = "Accept=application/json")
	@ResponseBody
	public ResourceForm delete(ResourceForm form) throws Exception {

		try {
			this.resourceService.delete(form.getId());
			form.setIsSuccess(SUCCESS);
			form.setMsg("删除成功");

		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		return form;
	}

	/**
	 * 逻辑删除
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/delete1", headers = "Accept=application/json")
	public ResourceForm delete1(ResourceForm form) throws Exception {
		Resource resource = form.getObj();
		resource.setDeleteMark("0");
		try {
			this.resourceService.update(resource, resource.getId(), null);
			form.setMsg("删除成功");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		return form;
	}

	/**
	 * 添加修改关键字跳转页面
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/editkeyword")
	public ModelAndView editkeyword(ResourceForm form) throws Exception {
		Resource obj = null;
		forwardString = "resource/resourceEditKeyWord.ftl";
		Map<String, Object> model = new HashMap<String, Object>();
		String id = form.getId();
		try {
			if (id != null && !"".equals(id)) {
				obj = this.resourceService.findById(id);
			}
			form.setObj(obj);
			form.setId(id);
			model.put("form", form);
		} catch (Exception e) {
			request.setAttribute(
					"message",
					(e instanceof CcsException) ? Lang.getLanguage(
							((CcsException) e).getPrompt(), request
									.getSession().getAttribute("lang")
									.toString()) : e.getMessage());
			forwardString = "error";
		}
		return new ModelAndView(forwardString, model);
	}

	/**
	 * 提交关键字添加或修改
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/editkeywordSubmit")
	public ResourceForm editkeywordSubmit(ResourceForm form) throws Exception {
		Resource resource = form.getObj();
		try {
			// 修改
			this.resourceService.update(resource, resource.getId(), null);
			form.setMsg("关键字编辑成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e)
					.getPrompt() : e.getMessage());
		}
		return form;
	}

	/**
	 * 添加测试数据入口 只为了测试数据用而已
	 */
	@ResponseBody
	@RequestMapping(value = "/form/editSubmit")
	public ResourceForm editSubmit(ResourceForm form) throws Exception {
		Resource resource = form.getObj();
		try {
			if (form.getId() != null && !"".equals(form.getId())) {
				// 修改
				this.resourceService.update(resource, resource.getId(), null);
				form.setMsg("模板修改成功");
			} else {
				// 用户模板文件存储路径
				String filePath = ProcessQueue.WEBROOT + File.separator
						+ ProcessQueue.UPLOADROOT + File.separator
						+ ProcessQueue.TEMPLATEHOME + File.separator;
				// 文件原名
				String OriginalFilename = form.getUpFile()
						.getOriginalFilename();
				// 文件名称 通过系统时间得到
				String fileName = FileUtil.getFileName(OriginalFilename);
				// 获取上传的文件流对象 上传文件
				FileUtil.writeFile(filePath, fileName, form.getUpFile()
						.getFileItem().get());

				resource.setFilePath(filePath);
				resource.setResourceName(fileName);
				// 保存
				this.resourceService.addObj(resource);
				form.setMsg("模板添加成功");

				// 添加模板成功后启动解析模板线程
				this.xmlNodeService.analysisTemplateAddNode(resource);
			}
			form.setIsSuccess("true");
			form.setUpFile(null);
		} catch (Exception e) {
			form.setMsg((e instanceof CcsException) ? Lang.getLanguage(
					((CcsException) e).getPrompt(), request.getSession()
							.getAttribute("lang").toString()) : e.getMessage());
		}
		return form;
	}

	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(ResourceForm form) throws Exception {
		Resource obj = null;
		forwardString = "resource/resourceEdit.ftl";
		Map<String, Object> model = new HashMap<String, Object>();
		String id = form.getId();
		try {
			if (id != null && !"".equals(id)) {
				obj = this.resourceService.findById(id);
			}
			form.setObj(obj);
			form.setId(id);
			model.put("form", form);
		} catch (Exception e) {
			request.setAttribute(
					"message",
					(e instanceof CcsException) ? Lang.getLanguage(
							((CcsException) e).getPrompt(), request
									.getSession().getAttribute("lang")
									.toString()) : e.getMessage());
			forwardString = "error";
		}
		return new ModelAndView(forwardString, model);
	}

	/**
	 * 导出格式选择层
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/transform")
	public ModelAndView transform() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String forwardString = "resource/ResourceTransform.ftl";
		model.put("id", id);
		return new ModelAndView(forwardString, model);
	}

	/**
	 * 导出
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/transformSubmit")
	public ResponseEntity<byte[]> transformSubmit(ResourceForm form)
			throws Exception {

		String id = form.getObj().getId();
		System.out.println(id);
		int formatFlag = form.getFormatFlag();
		System.out.println(formatFlag);
		byte[] data = null;
		HttpHeaders header = new HttpHeaders();
		String filePath = "";
		String fileName = "";
		XMLHelper helper;
		try {
			//
			Resource resource = this.resourceService.findById(id);
			// 获取文件路径
			String path = resource.getFilePath();
			// 获取文件名
			String resourceName = resource.getResourceName();

			switch (formatFlag) {

			// 转换成xml
			case 1:
				fileName = path + resourceName;
				filePath = resourceName;
				copyFile(fileName, filePath);
				break;
			// 转换成pdf
			case 2:
				fileName = path + resourceName;
				filePath = resourceName.replace(".xml", "") + ".pdf";
				helper = new XMLHelper();
				// String xmlContent = helper.parseXml(fileName);
				String xmlContent = fileToString(fileName, "UTF-8");
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(filePath));
				document.open();
				BaseFont baseFontChinese = BaseFont.createFont("STSong-Light",
						"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				Font fontChinese = new Font(baseFontChinese, 12, Font.NORMAL);
				Paragraph graph = new Paragraph(xmlContent, fontChinese);
				document.add(graph);
				document.close();
				break;
			// 转换成doc
			case 3:
				fileName = path + resourceName;
				filePath = resourceName.replace(".xml", "") + ".doc";
				helper = new XMLHelper();
				// String xmlContent1 = helper.parseXml(fileName);
				String xmlContent1 = fileToString(fileName, "UTF-8");
				DOCHelper.toDoc(xmlContent1, filePath, "UTF-8");
				break;
			}

			String name = new String(filePath.getBytes("gbk"), "iso-8859-1");

			header.setContentType(MediaType
					.parseMediaType("application/x-msdownload"));

			header.set("Content-Disposition", "attachment; filename=" + name);

			data = FileUtils.readFileToByteArray(new File(filePath));

			form.setMsg("导出成功！");
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
	 * 文件读写
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public void copyFile(String src, String dest) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			int byteread;
			byte buffer[] = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				for (int i = 0; i < byteread; i++)
					out.write(buffer[i]);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			in.close();
			out.close();

		}
	}

	/**
	 * 文件内容转换成字符串
	 * 
	 * @param src
	 * @param enCoding
	 * @return
	 * @throws IOException
	 */
	public String fileToString(String src, String enCoding) throws IOException {

		InputStreamReader in = null;
		String fileStr = "";
		String str2 = "";
		try {
			in = new InputStreamReader(new FileInputStream(src), enCoding);
			int i = -1;
			while ((i = in.read()) != -1) {
				char m = (char) i;
				str2 = str2.valueOf(m);
				fileStr = fileStr + str2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return fileStr;
	}

	
	@ResponseBody
	@RequestMapping(value = "/form/getMenuZTree")
	public List<TreeNode> getList(ResourceForm form) throws Exception {


		String resourceid = request.getParameter("xmlId");
		String fatherId = request.getParameter("id");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("resourceid",resourceid);
		if(fatherId==null||"".equals(fatherId)){
			condition.put("parentId","0");
		}else{
			condition.put("parentId",fatherId);
		}
		
		List<XmlNode> xmlNodelist = this.xmlNodeService.getList(condition);
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if (xmlNodelist != null && xmlNodelist.size() != 0) {
			
			for (XmlNode xmlNode : xmlNodelist) {
				TreeNode node = null;
				if(xmlNode.getCount()>0){
					node = new TreeNode(xmlNode.getId(),xmlNode.getNodeCode(), xmlNode.getNodeName(), true, false);
				}else{
					node = new TreeNode(xmlNode.getId(),xmlNode.getNodeCode(),xmlNode.getNodeName(), false, false);
				}
				nodes.add(node);
			}
			
		}
		return nodes;
	}
	
	
	/**
	 * 在线预览
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/preview")
	public ModelAndView preview() throws Exception {
		String id = request.getParameter("id");
		Resource resource = this.resourceService.findById(id);
		String filePath = (resource.getFilePath() + resource.getBookName()).toLowerCase();
		

		if (filePath != null) {
			if (filePath.endsWith(".pdf")) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/pdf");
			}

			else if (filePath.endsWith(".txt")) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				
			}else {
				String filename = resource.getBookName();
				response.setHeader("Content-Disposition","attachment;filename=" + filename);
			}
			
			OutputStream os = null;
			InputStream in = null;
			try {
				String strPdfPath = filePath;
				File file = new File(strPdfPath);
				if (file.exists()) {
					os = response.getOutputStream();
					in = new FileInputStream(strPdfPath);
					byte[] b = new byte[2048];
					while ((in.read(b)) != -1) {
						os.write(b);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					os.close();
				}
				if (in != null) {
					in.close();
				}
			}
		}
		return new ModelAndView("resource/preview.jsp");
	}
	
	
	public static void main(String[] args) {
		String filePath = "d://ITextTest.pdf";
		String str = "";
		try {
			str = FileUtil.getStringText(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
