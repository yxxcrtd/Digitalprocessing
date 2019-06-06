package cn.digitalpublishing.springmvc.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.digitalpublishing.po.Resource;


public class ResourceForm extends DataTableForm<Resource>{
	
	private String resourceName;
	
	private String keyWord;
	
	private Resource obj;

	private String creatDate;
	
	private int order;
	
	private String deleteMark;
	
	private String bookName;

	
	private CommonsMultipartFile upFile = null;
	
	/**
	 * 导出标记
	 * 1：xml
	 * 2：pdf
	 * 3：DOC
	 */
	private int formatFlag;

	
	public int getFormatFlag() {
		return formatFlag;
	}

	public void setFormatFlag(int formatFlag) {
		this.formatFlag = formatFlag;
	}

	public CommonsMultipartFile getUpFile() {
		return upFile;
	}

	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}
	
	public String getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(String deleteMark) {
		this.deleteMark = deleteMark;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Resource getObj() {
		return obj;
	}

	public void setObj(Resource obj) {
		this.obj = obj;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
