package cn.digitalpublishing.springmvc.form;

import java.util.List;

import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.po.TemplateNode;
import cn.digitalpublishing.po.XmlNode;

public class TemplateMappingForm extends DataTableForm<TemplateNode> {
	/**
	 * 标准模板id
	 */
	private String templateid;
	/**
	 * 数据模板id
	 */
	private String resourceid;

	
	private List<XmlNode> xmlNodeList;
	
	private String templateNodeid;
	
	private String xmlNodeid;
	
	private List<TemplateNode> templateNodeList;

	private List<Resource> resourceList;
	
	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public List<Template> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}

	private List<Template> templateList;
	
	public List<XmlNode> getXmlNodeList() {
		return xmlNodeList;
	}

	public void setXmlNodeList(List<XmlNode> xmlNodeList) {
		this.xmlNodeList = xmlNodeList;
	}

	public List<TemplateNode> getTemplateNodeList() {
		return templateNodeList;
	}

	public void setTemplateNodeList(List<TemplateNode> templateNodeList) {
		this.templateNodeList = templateNodeList;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}
	
	public String getTemplateNodeid() {
		return templateNodeid;
	}

	public void setTemplateNodeid(String templateNodeid) {
		this.templateNodeid = templateNodeid;
	}

	public String getXmlNodeid() {
		return xmlNodeid;
	}

	public void setXmlNodeid(String xmlNodeid) {
		this.xmlNodeid = xmlNodeid;
	}

}
