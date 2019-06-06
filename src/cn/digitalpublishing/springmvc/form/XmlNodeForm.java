package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.XmlNode;


public class XmlNodeForm extends DataTableForm<XmlNode>{
	
	private String nodePath;
	
	private XmlNode obj;

	private String nodeValue;
	
	private String updateTime;
	
	private String xmlId;
	
	private String name;

	private String pId;
	
	private String nodeCode;
	
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	public String getName() {
		return name;
	}
	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public XmlNode getObj() {
		return obj;
	}

	public void setObj(XmlNode obj) {
		this.obj = obj;
	}

	public String getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getXmlId() {
		return xmlId;
	}

	public void setXmlId(String xmlId) {
		this.getCondition().put("xmlId", xmlId);
		this.xmlId = xmlId;
	}

}
