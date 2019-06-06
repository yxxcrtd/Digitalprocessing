package cn.digitalpublishing.po;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * FtpConfig 对象
 * 
 * @author zhouwenqian
 */
public class FtpConfig {
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 标识
	 */
	private String ident;
	/**
	 * ftp名称
	 */
	private String ftpName;
	
	/**
	 * ip
	 */
	private String ip;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 端口
	 */
	private Integer port;
	//ftpFolder
	
	@JsonIgnore
	private Set<FtpFolder> ftpFolders = new HashSet<FtpFolder>();
	
	public Set<FtpFolder> getFtpFolders() {
		return ftpFolders;
	}
	public void setFtpFolders(Set<FtpFolder> ftpFolders) {
		this.ftpFolders = ftpFolders;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getFtpName() {
		return ftpName;
	}
	public void setFtpName(String ftpName) {
		this.ftpName = ftpName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
}
