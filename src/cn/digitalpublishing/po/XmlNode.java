package cn.digitalpublishing.po;

import java.util.Date;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * XmlNode 对象
 * 
 * @author jinyanjiang
 */
public class XmlNode {
	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 单个节点名
	 */
	private String nodeName;

	/**
	 * Xml节点
	 */
	private String nodePath;
	

	/**
	 * Xml节点值
	 */
	private String nodeValue;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * resource对象
	 */
	private Resource resource;

	/**
	 * 父节点
	 */
	@JsonIgnore
	private XmlNode parent;

	/**
	 * 子集合
	 */
	private Set<XmlNode> children;
	
	/**
	 * 节点编码
	 */
	private String nodeCode;
	
	private Integer count;
	
	
	private String nodeKey;
	
	public String getNodeKey() {
		return nodeKey;
	}

	public void setNodeKey(String nodeKey) {
		this.nodeKey = nodeKey;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}


	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public XmlNode getParent() {
		return parent;
	}

	public void setParent(XmlNode parent) {
		this.parent = parent;
	}

	public Set<XmlNode> getChildren() {
		return children;
	}

	public void setChildren(Set<XmlNode> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public String getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
}
