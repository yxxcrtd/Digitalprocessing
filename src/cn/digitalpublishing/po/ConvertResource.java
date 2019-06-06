package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import cn.digitalpublishing.util.DateFormatUitl;


@SuppressWarnings("serial")
public class ConvertResource implements Serializable {
	/**
	 * 主键
	 */
	private String id;

	@JsonIgnore
	private Resource resource;
	
	private String fileType;
	
	private Date updateDate;
	
	private String updateDateStr;

	

	private String filePath;
	
	private String fileName;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		this.updateDateStr = DateFormatUitl.formatDate(updateDate);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
		
	}
}
