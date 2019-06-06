package cn.digitalpublishing.po;
/**
 * FtpFolder 对象
 * 
 * @author zhouwenqian
 */
public class FtpFolder {
	/**
	 * 主键id
	 */
	private String id;
	
	
	/**
	 * 文件夹名称
	 */
	private String folderName;
	
	/**
	 * 配置路径
	 */
	private String url;
	/**
	 * 文件夹描述
	 */
	private String depict;
	
	/**
	 * FTPConfig
	 */
	private FtpConfig ftpConfig;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public FtpConfig getFtpConfig() {
		return ftpConfig;
	}

	public void setFtpConfig(FtpConfig ftpConfig) {
		this.ftpConfig = ftpConfig;
	}

	
	
	
}
