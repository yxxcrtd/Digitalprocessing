package cn.digitalpublishing.po;

import java.util.Date;
import java.util.Set;

import cn.digitalpublishing.util.DateFormatUitl;

/**
 * Resource 对象
 * 
 * @author jinyanjiang
 */
public class Resource {
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 资源名称
	 */
	private String resourceName;
	
	/**
	 * 创建时间
	 */
	private Date creatDate = new Date();
	/**
	 * 创建时间字符串型
	 */
	private String creatDateStr;

	/**
	 * 逻辑删除标示
	 */
	private String deleteMark;
	
	/**
	 * 关联节点
	 */
	private Set<XmlNode> node;
	
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 状态 1-待解析 2-待下载 3-合法
	 */
	private Integer status;
	/**
	 * ftp文件夹目录
	 */
	private String ftpFileDir;
	
	/**
	 * 元文件内容
	 */
	private String resouceContent;
	/**
	 * 读取元文件标识 
	 */
	private Integer flag;
	
	/**
	 * ftp标识
	 */
	private String ftpcode;

	private String password;
	
	private String ip;
	
	private Integer port;
	
	private String username;
	
	private Resource source;

	/**
	 * 关键字
	 */
	private String keyWord;
	
	/**
	 * 源书名
	 */
	private String bookName;
	
	/**
	 * 源书封面
	 */
	private String bookCover;

	/**
	 * 源书插图
	 */
	private String bookImage;
	
	public String getCreatDateStr() {
		return creatDateStr;
	}

	public void setCreatDateStr(String creatDateStr) {
		this.creatDateStr = creatDateStr;
	}
	
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Resource getSource() {
		return source;
	}

	public void setSource(Resource source) {
		this.source = source;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFtpFileDir() {
		return ftpFileDir;
	}

	public void setFtpFileDir(String ftpFileDir) {
		this.ftpFileDir = ftpFileDir;
	}

	public String getFtpcode() {
		return ftpcode;
	}

	public void setFtpcode(String ftpcode) {
		this.ftpcode = ftpcode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<XmlNode> getNode() {
		return node;
	}

	public void setNode(Set<XmlNode> node) {
		this.node = node;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
		this.creatDateStr = DateFormatUitl.formatDate(creatDate);
	}

	public String getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(String deleteMark) {
		this.deleteMark = deleteMark;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getResouceContent() {
		return resouceContent;
	}

	public void setResouceContent(String resouceContent) {
		this.resouceContent = resouceContent;
	}
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


}
