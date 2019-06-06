package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.ConvertResource;


public class ConvertForm extends DataTableForm<ConvertResource>{
	private ConvertResource obj;

	private String fileName;
	
	private String fileType;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public ConvertResource getObj() {
		return obj;
	}

	public void setObj(ConvertResource obj) {
		this.obj = obj;
	}
	
}
