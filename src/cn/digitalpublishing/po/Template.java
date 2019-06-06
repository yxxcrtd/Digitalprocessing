package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.exolab.castor.xml.handlers.DateFieldHandler;

import cn.digitalpublishing.util.DateFormatUitl;


@SuppressWarnings("serial")
public class Template implements Serializable {
	/**
	 * 主键
	 */
	private String id;

	/**
	 * 模板原名称
	 */
	private String originalName;
	
	/**
	 * 用户模板名称
	 */
	private String name;
	/**
	 * 模板文件在服務器上存放的名称
	 */
	private String fileName;
	
	/**
	 * 模板上传时间
	 */
	private Date createTime; 
	/**
	 * 时间格式化 格式化到秒
	 */
	private String strTime;
	
	/**
	 * 模板存储路径
	 */
	private String path;
	
	/**
	 * ftp对象
	 */
	private FtpConfigure ftpConfigure;
	/**
	 * 模板节点对象
	 */
	@JsonIgnore
	private Set<TemplateNode>  templateNodes = new LinkedHashSet<TemplateNode>();
	
	
	/**
	 * 模板文件路径
	 */
	private String templatePath;
	
	
	public FtpConfigure getFtpConfigure() {
		return ftpConfigure;
	}
	public void setFtpConfigure(FtpConfigure ftpConfigure) {
		this.ftpConfigure = ftpConfigure;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date date) {
		this.createTime = date;
		this.strTime = DateFormatUitl.formatDate(date);
	}
	public String getStrTime() {
		return strTime;
	}
	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}
	
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	
	public Set<TemplateNode> getTemplateNodes() {
		return templateNodes;
	}
	public void setTemplateNodes(Set<TemplateNode> templateNodes) {
		this.templateNodes = templateNodes;
	}
}
