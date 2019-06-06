package cn.digitalpublishing.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.config.ProcessQueue;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.springmvc.form.TemplateForm;
import cn.digitalpublishing.thread.AnalysisTemplateListener;
import cn.digitalpublishing.util.FileUtil;

@Controller
@RequestMapping("/pages/template")
public class TemplateController extends BaseController {

	@RequestMapping(value="/form/index")
	public ModelAndView index(TemplateForm form)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		forwardString="template/templateList.ftl";
		return new ModelAndView(forwardString, model);
	}
	
	@ResponseBody
	@RequestMapping(value="/form/manager")
	public TemplateForm manager(TemplateForm form)throws Exception {
		List<Template> list = new ArrayList<Template>();
		try{
			int dataCount = this.templateService.getDataCount(form.getCondition());
			form.setiTotalRecords(dataCount);
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if(dataCount>0){
				list = this.templateService.getTemplatePagingList(form.getCondition(),"",form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setAaData(list);
		}catch(Exception e){
			e.printStackTrace();
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
            forwardString="error";
		}
		return form;
	}
	
	@RequestMapping(value="/form/edit")
	public ModelAndView edit(TemplateForm form)throws Exception {
		Template obj = null;
		forwardString="template/templateEdit.ftl";
		Map<String,Object> model = new HashMap<String,Object>();
		String id = form.getId();
		try{
			if(id!=null&&!"".equals(id)){
				obj = this.templateService.findById(id);
			}
			form.setObj(obj);
			form.setId(id);
			model.put("form", form);
		}catch(Exception e){
            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
			forwardString="error";
		}
		return new ModelAndView(forwardString,model);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/form/editSubmit")
	public TemplateForm editSubmit(TemplateForm form) throws Exception {
		Template template = form.getObj();
		System.out.println(form.getId());
		try{
			if(form.getId()!=null && !"".equals(form.getId())){
				//修改
				this.templateService.updateTemplate(template, template.getId(), null);
				form.setMsg("模板修改成功");
			}else{
				//用户模板文件存储路径
				String filePath=ProcessQueue.WEBROOT+File.separator+ProcessQueue.UPLOADROOT+File.separator+ProcessQueue.TEMPLATEHOME+File.separator;
				//文件原名
				String OriginalFilename = form.getUpFile().getOriginalFilename();
				//文件名称 通过系统时间得到
				String fileName = FileUtil.getFileName(OriginalFilename);
				//获取上传的文件流对象 上传文件
				FileUtil.writeFile(filePath,fileName, form.getUpFile().getFileItem().get());
				
				template.setPath(filePath);
				template.setOriginalName(OriginalFilename);
				template.setFileName(fileName);
				template.setCreateTime(new Date());
				//保存
				this.templateService.addTemplate(template);
				form.setMsg("模板添加成功");
				
				//添加模板成功后启动解析模板线程
				AnalysisTemplateListener templateThread = new AnalysisTemplateListener();
				templateThread.executeScan(template);
				
			}
			form.setIsSuccess("true");
			form.setUpFile(null);
		}catch(Exception e){
			form.setMsg((e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
		}
		return form;
	}
	@ResponseBody
	@RequestMapping(value="/form/delete")
	public TemplateForm delete(TemplateForm form) throws Exception {
		String id = request.getParameter("id");
		try {
			this.templateService.deleteTemplate(id);
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		return form;
	}
}
