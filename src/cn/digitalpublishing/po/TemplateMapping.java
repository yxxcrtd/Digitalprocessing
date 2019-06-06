package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;


@SuppressWarnings("serial")
public class TemplateMapping implements Serializable {
	/**
	 * 主键
	 */
	private String id;

	private String templateid;
	
	private String resourceid;
	
	private String xmlNodeid;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getXmlNodeid() {
		return xmlNodeid;
	}

	public void setXmlNodeid(String xmlNodeid) {
		this.xmlNodeid = xmlNodeid;
	}

	public String getTemplateNodeid() {
		return templateNodeid;
	}

	public void setTemplateNodeid(String templateNodeid) {
		this.templateNodeid = templateNodeid;
	}

	private String templateNodeid;
}
