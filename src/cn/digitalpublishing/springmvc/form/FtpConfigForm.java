package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.FtpConfig;


public class FtpConfigForm extends DataTableForm<FtpConfig>{
	private FtpConfig obj;

	private String ident;
	
	private String ftpName;

	public String getFtpName() {
		return ftpName;
	}

	public void setFtpName(String ftpName) {
		this.getCondition().put("ftpName", ftpName);

		this.ftpName = ftpName;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.getCondition().put("ident", ident);
		this.ident = ident;
	}

	public FtpConfig getObj() {
		return obj;
	}

	public void setObj(FtpConfig obj) {
		this.obj = obj;
	}

}
