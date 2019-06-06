package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class BSubject implements Serializable {

	private String id;
	private String code;
	private String name;
	private String nameEn;//英文名称
	private Integer type;//1-主要分类法 2-其他分类法
	private Integer order;
	private BSubject parentSubject ;
	private Set<BSubject> chilrenSubject ;
	
	private String desc;
	private String treeCode;
	private Integer standard;//1-标准 2-自定义
	/**
	 * 查看是否含有子类
	 */
	private Integer isParent=0;
	/**
	 * 匹配模式 1-精确匹配 2-向上匹配
	 */
	private Integer matchMode = 1;
	
	/**
	 * 关系
	 */
	private Set<PCSRelation> csRelations;
	//自定义字段
	private Integer checked;//是否是跟产品关联的
	
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	public Set<PCSRelation> getCsRelations() {
		return csRelations;
	}
	public void setCsRelations(Set<PCSRelation> csRelations) {
		this.csRelations = csRelations;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public BSubject getParentSubject() {
		return parentSubject;
	}
	public void setParentSubject(BSubject parentSubject) {
		this.parentSubject = parentSubject;
	}
	public Set<BSubject> getChilrenSubject() {
		return chilrenSubject;
	}
	public void setChilrenSubject(Set<BSubject> chilrenSubject) {
		this.chilrenSubject = chilrenSubject;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTreeCode() {
		return treeCode;
	}
	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public Integer getMatchMode() {
		return matchMode;
	}
	public void setMatchMode(Integer matchMode) {
		this.matchMode = matchMode;
	}

}
