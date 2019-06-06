package cn.digitalpublishing.po;


/**
 * OcrFiles 对象
 * 
 * @author zhouwenqian
 */
public class OcrFiles {
	
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 文件内容
	 */
	private String content;
	/**
	 * 无样式的文件内容
	 */
	private String contentNoStyle;
	/**
	 * 接收文件路径
	 */
	private String receiveFilePath;
	/**
	 * 原始文件路径
	 */
	private String  originalFilePath;
	
	public String getOriginalFilePath() {
		return originalFilePath;
	}
	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}
	public String getReceiveFilePath() {
		return receiveFilePath;
	}
	public void setReceiveFilePath(String receiveFilePath) {
		this.receiveFilePath = receiveFilePath;
	}
	/**
	 * @return the contentNoStyle
	 */
	public String getContentNoStyle() {
		return contentNoStyle;
	}
	/**
	 * @param contentNoStyle the contentNoStyle to set
	 */
	public void setContentNoStyle(String contentNoStyle) {
		this.contentNoStyle = contentNoStyle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
