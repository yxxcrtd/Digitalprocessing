package cn.digitalpublishing.springmvc.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BSubRelation;
import cn.digitalpublishing.po.BSubject;

public class BSubRelationForm extends DataTableForm<BSubRelation> {
	
	private BSubRelation obj;
	
	public BSubRelation getObj() {
		return obj;
	}

	public void setObj(BSubRelation obj) {
		this.obj = obj;
	}

	private Map<String,String> loadType =new HashMap<String,String>();
	private Map<String,String> loadStandard =new HashMap<String,String>();
	/**
	 * 分类列表
	 */
	private List<BSubject> subList = new ArrayList<BSubject>();

	/**
	 * 其他分类顶级信息列表
	 */
	private List<BSubject> elseList = new ArrayList<BSubject>();
	
	/**
	 * 编码集合
	 */
	private String[] coopCodes;
	
	/**
	 * ID集合
	 */
	private String[] coopIds;
	
	/**
	 * 映射ID集合
	 */
	private String[] CLCIds;
	/**
	 * ztree树形结构
	 * */
	private String name;
	private String nameEn;
	private String pId;
	private String code;
	private boolean isParent=false; 
	private boolean open=false;
	private String order;
	

	/**
	 * 移动类型 prev、next、inner
	 */
	private String moveType;
	
	/**
	 * 要移动的节点名
	 */
	private String changeName;
	/**
	 * 要移动的节点ID
	 */
	private String changeId;
	/**
	 * 要移动的节点的pId 
	 */
	private String changePid;
	
	/**
	 * 分类Id
	 */
	private String subId;
	/**
	 * 父类code
	 */
	private String baseCode;
	/**
	 * 树编码
	 */
	private String treeCode ;
	/**
	 * 是否父类查询
	 */
	private String isp;
	/**
	 * 原有code
	 */
	private String oldCode;
	
	private String pubId;//产品ID
    /**
     *描述
     */
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPubId() {
		return pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.getCondition().put("name", name);
		this.name = name;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, String> getLoadType() {
		return loadType;
	}

	public void setLoadType(Map<String, String> loadType) {
		this.loadType = loadType;
	}

	public Map<String, String> getLoadStandard() {
		return loadStandard;
	}

	public void setLoadStandard(Map<String, String> loadStandard) {
		this.loadStandard = loadStandard;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}


	public String[] getCoopCodes() {
		return coopCodes;
	}

	public void setCoopCodes(String[] coopCodes) {
		this.coopCodes = coopCodes;
	}

	public String[] getCoopIds() {
		return coopIds;
	}

	public void setCoopIds(String[] coopIds) {
		this.coopIds = coopIds;
	}

	public String[] getCLCIds() {
		return CLCIds;
	}

	public void setCLCIds(String[] cLCIds) {
		CLCIds = cLCIds;
	}


	public String getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getChangePid() {
		return changePid;
	}

	public void setChangePid(String changePid) {
		this.changePid = changePid;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	
	
	public List<BSubject> getSubList() {
		return subList;
	}

	public void setSubList(List<BSubject> subList) {
		this.subList = subList;
	}

	public List<BSubject> getElseList() {
		return elseList;
	}

	public void setElseList(List<BSubject> elseList) {
		this.elseList = elseList;
	}
	
}
