package cn.digitalpublishing.springmvc.form;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.springmvc.form.BaseForm;

public class TemplateForm extends DataTableForm<Template> {
	private Template obj = new Template();

	private String name;

	private String originalName;

	private Map<String, Object> condition = new HashMap<String, Object>();

	private String ftpid;

	private Map<String, String> templateTypeMap = new HashMap<String, String>();

	private String sourceId;

	private String targetId;

	private CommonsMultipartFile upFile = null;
	
	public CommonsMultipartFile getUpFile() {
		return upFile;
	}

	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}


	public Map<String, String> getTemplateTypeMap() {
		return templateTypeMap;
	}

	public void setTemplateTypeMap(Map<String, String> templateTypeMap) {
		this.templateTypeMap = templateTypeMap;
	}

	public String getFtpid() {
		return ftpid;
	}

	public void setFtpid(String ftpid) {
		this.ftpid = ftpid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.getCondition().put("name", "%"+name+"%");
		System.out.println(name);
		this.name = name;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public Template getObj() {
		return obj;
	}

	public void setObj(Template obj) {
		this.obj = obj;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
		this.getCondition().put("originalName", originalName);
	}

	public String getSourceId() {
		return sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
		this.getCondition().put("sourceId", sourceId);
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
		this.getCondition().put("targetId", targetId);
	}


}
