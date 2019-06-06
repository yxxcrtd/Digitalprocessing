package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
public class TemplateNode implements Serializable {
	
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 节点编码
	 */
	private String nodeCode;
	/**
	 * 节点路径
	 */
	private String nodePath;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * 节点描述
	 */
	private String Description;
	/**
	 * 用户模板节点路径是否唯一
	 */
	private Boolean isOnly;
	/**
	 * 是否必填
	 */
	private Boolean isNecessary;
	/**
	 * 默认值
	 */
	private String defualtValue;
	/**
	 * 父类对象
	 */
	private TemplateNode parent;
	/**
	 * 子类对象集合
	 */
	@JsonIgnore
	private Set<TemplateNode> children = new HashSet<TemplateNode>();

	/**
	 * 用户模板对象
	 */
	private Template template;


	private List<XmlNode> xmlNodeList;
	
	private Map<String,String> templateMappingMap;
	
	private String resourceid;
	
	private String templateid;
	
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

	public Map<String, String> getTemplateMappingMap() {
		return templateMappingMap;
	}

	public void setTemplateMappingMap(Map<String, String> templateMappingMap) {
		this.templateMappingMap = templateMappingMap;
	}

	public List<XmlNode> getXmlNodeList() {
		return xmlNodeList;
	}

	public void setXmlNodeList(List<XmlNode> xmlNodeList) {
		this.xmlNodeList = xmlNodeList;
	}


	public TemplateNode getParent() {
		return parent;
	}

	public void setParent(TemplateNode parent) {
		this.parent = parent;
	}

	public Set<TemplateNode> getChildren() {
		return children;
	}

	public void setChildren(Set<TemplateNode> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Boolean getIsOnly() {
		return isOnly;
	}

	public void setIsOnly(Boolean isOnly) {
		this.isOnly = isOnly;
	}

	public Boolean getIsNecessary() {
		return isNecessary;
	}

	public void setIsNecessary(Boolean isNecessary) {
		this.isNecessary = isNecessary;
	}

	public String getDefualtValue() {
		return defualtValue;
	}

	public void setDefualtValue(String defualtValue) {
		this.defualtValue = defualtValue;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}
