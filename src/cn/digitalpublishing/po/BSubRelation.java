package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BSubRelation implements Serializable {

	private String id;

	private BSubject mainSub;// 主分类
	private BSubject elseSub;// 其他分类
	private String mainCode;
	private String elseCode;
	
	private List<BSubject> listBS;
	public List<BSubject> getListBS() {
		return listBS;
	}
	public void setListBS(List<BSubject> listBS) {
		this.listBS = listBS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BSubject getMainSub() {
		return mainSub;
	}
	public void setMainSub(BSubject mainSub) {
		this.mainSub = mainSub;
	}
	public BSubject getElseSub() {
		return elseSub;
	}
	public void setElseSub(BSubject elseSub) {
		this.elseSub = elseSub;
	}
	public String getMainCode() {
		return mainCode;
	}
	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}
	public String getElseCode() {
		return elseCode;
	}
	public void setElseCode(String elseCode) {
		this.elseCode = elseCode;
	}
}
