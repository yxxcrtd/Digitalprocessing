package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.po.FtpFolder;


public class FtpFolderForm extends DataTableForm<FtpFolder>{
	
	//ftp文件夹
	private FtpFolder obj;
	//ftp文件夹名
	private String folderName;
	//ftp服务器名
	private String ftpName;
	
	//ftpconfig
	private FtpConfig ftpConfig;
	//ftpconfigid
	private String ftpid;
	
	public FtpFolder getObj() {
		return obj;
	}
	public void setObj(FtpFolder obj) {
		this.obj = obj;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.getCondition().put("folderName", folderName);
		this.folderName = folderName;
	}
	public FtpConfig getFtpConfig() {
		return ftpConfig;
	}
	public void setFtpConfig(FtpConfig ftpConfig) {
		this.ftpConfig = ftpConfig;
	}

	
	public String getFtpid() {
		return ftpid;
	}
	public void setFtpid(String ftpid) {
		this.ftpid = ftpid;
	}
	
	
	public String getFtpName() {
		return ftpName;
	}
	public void setFtpName(String ftpName) {
		this.getCondition().put("ftpName", ftpName);
		this.ftpName = ftpName;
	}


}
