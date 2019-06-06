package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.OcrFiles;


public class OcrFileForm extends DataTableForm<OcrFiles>{
	
	private OcrFiles obj;

	private String fileName;
	
	
	/**
	 * 转换标记
	 * 1：pdf
	 * 2：xml
	 * 3：doc
	 */
	private int formatFlag;

	/**
	 * @return the formatFlag
	 */
	public int getFormatFlag() {
		return formatFlag;
	}

	/**
	 * @param formatFlag the formatFlag to set
	 */
	public void setFormatFlag(int formatFlag) {
		this.formatFlag = formatFlag;
	}

	/**
	 * @return the obj
	 */
	public OcrFiles getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(OcrFiles obj) {
		
		this.obj = obj;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.getCondition().put("fileName", fileName);
		this.fileName = fileName;
	}


}
