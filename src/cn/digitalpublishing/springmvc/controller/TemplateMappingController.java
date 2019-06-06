package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.po.TemplateMapping;
import cn.digitalpublishing.po.TemplateNode;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.springmvc.form.TemplateForm;
import cn.digitalpublishing.springmvc.form.TemplateMappingForm;

@Controller
@RequestMapping("/pages/templatemapping")
public class TemplateMappingController extends BaseController {
	
	
	@RequestMapping(value="/form/index")
	public ModelAndView index(TemplateForm form)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		//资源集合
		List<Resource>resourceList = null; 
		//标准模板集合
		List<Template>templateList = null;
		
		//查询所有的资源数据
		Map<String,Object> resourceCondition = new HashMap<String,Object>();
		resourceList = this.resourceService.getList(resourceCondition, "");
		//查询模板数据
		Map<String,Object> templateCondition = new HashMap<String,Object>();
		templateList = this.templateService.getList(templateCondition, "");
		
		model.put("resourceList", resourceList);
		model.put("templateList", templateList);
		
		forwardString="templatemapping/templatemappingList.ftl";
		return new ModelAndView(forwardString, model);
	}
	
	@ResponseBody
	@RequestMapping(value="/form/manager")
	public TemplateMappingForm manager(TemplateMappingForm form)throws Exception {
		
		try{
			//通过选择的数据模板id查询数据模板节点列表
			List<XmlNode> xmlNodeList = new ArrayList<XmlNode>();
			String resourceid = form.getResourceid();
			if(resourceid!=null&&!"".equals(resourceid)){
				Map<String,Object> xmlNodeCondition = new HashMap<String,Object>();
				xmlNodeCondition.put("resourceid", resourceid);
				xmlNodeList = this.xmlNodeService.getList(xmlNodeCondition);
			}
			//通过选在的标准模板id查新标准模板节点列表
			List<TemplateNode> templateNodeList = new ArrayList<TemplateNode>();
			String templateid = form.getTemplateid();
			
			//映射表数据集合
			Map<String,String> map = new HashMap<String,String>();
			
			if(templateid!=null&&!"".equals(templateid)){
				
				Map<String,Object> templateNodeCondition = new HashMap<String,Object>();
				templateNodeCondition.put("templateid", templateid);
				int dataCount = this.templateNodeService.getCount(templateNodeCondition);
				form.setiTotalRecords(dataCount);
				form.setiTotalDisplayRecords(form.getiTotalRecords());
				if(dataCount>0){
					templateNodeList = this.templateNodeService.getPagingList(templateNodeCondition, "", 
							form.getiDisplayLength(), form.getiDisplayStart());
					
					//通过resourceid 和templeid查询返回映射数据集合
					Map<String,Object> templateMappingCondition = new HashMap<String,Object>();
					templateMappingCondition.put("resourceid", resourceid);
					templateMappingCondition.put("templateid", templateid);
					List<TemplateMapping> templateMappingList = this.templateMappingService.getList(templateMappingCondition, "");
					//循环  将数据封装到map中  key templateNodeid  value xmlNodexid
					for (TemplateMapping templateMapping : templateMappingList) {
						map.put(templateMapping.getTemplateNodeid(), templateMapping.getXmlNodeid());
					}
					
					//封装template的xmlnodeList属性
					for (TemplateNode templateNode : templateNodeList) {
							templateNode.setXmlNodeList(xmlNodeList);
							templateNode.setTemplateMappingMap(map);	
							//循环templateNodeList 封装resourceid属性
							templateNode.setResourceid(resourceid);
							//循环templateNodeList 封装templateid属性
							templateNode.setTemplateid(templateid);
						}
				}
			}else{
				form.setiTotalRecords(0);
				form.setiTotalDisplayRecords(form.getiTotalRecords());
			}
			
			form.setAaData(templateNodeList);
			
			//回执页面条件值
			form.setResourceid(resourceid);
			form.setTemplateid(templateid);
			
		}catch(Exception e){
			e.printStackTrace();
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
            forwardString="error";
		}
		return form;
	}
	
	/**
	 * 添加或修改映射关系
	 */
	@ResponseBody
	@RequestMapping(value="/form/editsubmit")
	public TemplateMappingForm editsubmit(TemplateMappingForm form)throws Exception {
		try {
			String xmlNodeidnew = request.getParameter("xmlNodeidnew");
			String xmlNodeidold = request.getParameter("xmlNodeidold");
			String templateNodeid = request.getParameter("templateNodeid");
			String resourceid = request.getParameter("resourceid");
			String templateid = request.getParameter("templateid");
					
					
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("xmlNodeid",xmlNodeidold);
			condition.put("templateNodeid", templateNodeid);
			//通过xmlNodeid 和 templateNodeid 查询 ，如果存在则删除
			if(xmlNodeidold!=null&&!"".equals(xmlNodeidold)){
				List<TemplateMapping> list = this.templateMappingService.getList(condition, "");
				if(list!=null&&list.size()>0){
					this.templateMappingService.delete(list.get(0).getId());
				}
			}
			//判断xmlnode 是不是null 或“” 否则进行添加操作
			if(xmlNodeidnew!=null&&!"".equals(xmlNodeidnew)){
				//添加
				TemplateMapping templateMapping = new TemplateMapping();
				templateMapping.setResourceid(resourceid);
				templateMapping.setTemplateid(templateid);
				templateMapping.setXmlNodeid(xmlNodeidnew);
				templateMapping.setTemplateNodeid(templateNodeid);
				this.templateMappingService.add(templateMapping);
			}
		} catch (Exception e) {
			form.setMsg((e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
		}
		return form;
	}
	
}
