package cn.digitalpublishing.service.impl;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.po.BSubRelation;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.PCSRelation;
import cn.digitalpublishing.service.SubjectService;
import cn.digitalpublishing.springmvc.form.SubjectForm;

public class SubjectServiceImpl extends BaseServiceImpl implements SubjectService {
	
	public BSubject getSubject(String id) throws Exception {
		BSubject bSubject = null;
		try {
			bSubject = (BSubject)this.daoFacade.getSubjectDao().get(BSubject.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "BSubject.info.get.error", e);//获取分类信息失败！
		}
		return bSubject;
	}

	public void deleteSubject(String id) throws Exception {
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("parentId", id);
			if(this.daoFacade.getSubjectDao().getCount(condition)>0){
				throw new CcsException("存在子分类信息,禁止删除");//存在子分类信息,禁止删除
			}
			this.daoFacade.getSubjectDao().delete(BSubject.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "删除失败", e);//删除分类信息失败！
		}
	}
	
	/**
	 * 添加主分类信息
	 */
	public void addSubject(BSubject obj) throws Exception {
		try {
			Map<String,Object> codeMap = new HashMap<String,Object>();
		    codeMap.put("parentId", obj.getParentSubject() == null ? "0" : obj.getParentSubject().getId());
	    	String code = this.daoFacade.getSubjectDao().getNextCode(codeMap," order by a.treeCode desc ");
	    	obj.setTreeCode(code);
	    	obj.setOrder(1);
			this.daoFacade.getSubjectDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ?((CcsException)e).getPrompt(): "BSubject.info.add.error", e);//添加分类信息失败！
		}
	}

	public List<BSubject> getSubjectList(Map<String, Object> condition, String sort)	throws Exception {
		List<BSubject> list = null;
		try {
			list = this.daoFacade.getSubjectDao().getList(condition, sort);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.list.error", e);//获取分类信息列表失败！
		}
		return list;
	}

	public List<BSubject> getSubjectPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<BSubject> list = null ;
		try {
			list = this.daoFacade.getSubjectDao().getPagingList(condition, sort, pageCount, page);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "获取分类信息分页列表失败", e);//获取分类信息分页列表失败！
		}
		return list;
	}

	public Integer getSubjectCount(Map<String, Object> condition)throws Exception {
		Integer num = 0;
		try {
			num = this.daoFacade.getSubjectDao().getCount(condition);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.count.error", e);//获取分类信息总数失败！
		}
		return num;
	}

	public String insertSubject(BSubject obj) throws Exception {
	    String id = "";
	    try {
	      Map<String,Object> codeMap = new HashMap<String,Object>();
	      codeMap.put("parentId", obj.getParentSubject() == null ? "0" : obj.getParentSubject().getId());
//	      codeMap.put("", value);
	      String code = this.daoFacade.getSubjectDao().getNextCode(codeMap," order by a.treeCode desc ");
	      Integer order = this.daoFacade.getSubjectDao().getNextOrder(codeMap," order by a.order desc ");
	      obj.setOrder(order);
	      obj.setTreeCode(code);
	      this.daoFacade.getSubjectDao().insertSubject(obj);
	      id = obj.getId()+";"+obj.getOrder()+";"+(obj.getCode()+"-"+obj.getName());
	    } catch (Exception e) {
	    	throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.add.error", e);//添加分类信息失败！
	    }
	    return id;
	  }
	
	
	public void saveObj(BSubRelation obj) throws Exception {
	    try {
	      this.daoFacade.getSubRelationDao().insert(obj);
	    } catch (Exception e) {
	    	throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.add.error", e);//添加分类信息失败！
	    }
	  }
	

	  public boolean updateSubject(BSubject obj, String id, String[] properties) throws Exception
	  {
	    boolean isSuccess = false;
	    try{
	    	this.daoFacade.getSubjectDao().updateSubject(obj, id, properties);
	    	isSuccess = true;
	    } catch (Exception e) {
	    	throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.update.error", e);//更新分类信息失败！
	    }
	    return isSuccess;
	  }

	public boolean updateBySql(BSubject obj) throws Exception {
		boolean result = false;
		try {
			result = this.daoFacade.getSubjectDao().updateSubjectBySql(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.update.error", e);//更新分类信息失败！
		}
		return result;
	}

	public List<BSubject> getSubList(Map<String, Object> condition, String sort)throws Exception {
		List<BSubject> list = null;
		try {
			list = this.daoFacade.getSubjectDao().getSubList(condition,sort);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.list.error", e);//更新分类信息失败！
		}
		return list;
	}

	public String generateXML(Map<String, Object> condition, String sort,String path)throws Exception {
		try {
			//1、查询主分类信息
			List<BSubject> list = this.daoFacade.getSubjectDao().getList(condition, sort);
			//利用dom4j进行xml生成
			String dir=path+Param.getParam("BSubject.directory.config").get("subjectSource")+"\\"+Param.getParam("BSubject.directory.config").get("subjectXML");
			XMLWriter writer = new XMLWriter(new FileOutputStream(dir));
			Document doc = DocumentHelper.createDocument();
			//创建根节点
			Element root = doc.addElement("subject_codes");
			//添加子节点
			if(list!=null&&list.size()>0){
				for(BSubject obj:list){
					Element childEl = root.addElement("subject_code");
					Element code = childEl.addElement("code");
					code.setText(obj.getCode()==null?"":obj.getCode());
					Element fullname = childEl.addElement("fullname");
					fullname.setText(obj.getNameEn()==null?"":obj.getNameEn());
					Element fullnamechn = childEl.addElement("fullnamechn");
					fullnamechn.setText(obj.getName()==null?"":obj.getName());
					if(obj.getParentSubject()!=null&&obj.getParentSubject().getCode()!=null&&!"".equals(obj.getParentSubject().getCode())){
						Element parentsubject = childEl.addElement("parentsubject");
						parentsubject.setText(obj.getParentSubject().getCode()==null?"":obj.getParentSubject().getCode());
					}
				}
			}
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.main.generate.xml.error", e);//主分类法生成xml文件失败！
		}
		return Param.getParam("BSubject.directory.config").get("subjectSource")+"/"+Param.getParam("BSubject.directory.config").get("subjectXML");
	}

	public void subjectPosChange(SubjectForm form) throws Exception {
//			this.daoFacade.getSubjectDao().posChange(form);
        String moveType=form.getMoveType();
        String oldTreeCode = "";
        String treeCode = "";
        Integer order = 1;
        BSubject posObj = null;//移动的对象
        BSubject targetObj = null;//移动位置对象
        try {
            //创建要移动对象 和 移动位置对象
            posObj = (BSubject)this.daoFacade.getSubjectDao().get(BSubject.class.getName(), form.getChangeId());
            targetObj = (BSubject)this.daoFacade.getSubjectDao().get(BSubject.class.getName(), form.getId());
            oldTreeCode = posObj.getTreeCode();

                //要移动的目标的pId=移动位置ID
                //要移动的目标的order=移动位置下子分类的最后一个order+1
                //要移动的目标的treecode=移动位置下子分类的最后一个treecode+1
                Map<String,Object> codeMap = new HashMap<String,Object>();
                codeMap.put("parentId", form.getId());
                //根据moveType进行处理
                if(moveType.equalsIgnoreCase("inner")){
                    treeCode = this.daoFacade.getSubjectDao().getNextCode(codeMap," order by a.treeCode desc ");
                    order = this.daoFacade.getSubjectDao().getNextOrder(codeMap," order by a.order desc ");
                }else{
                    //查询目标位置的所有同级分类
                    Integer target = Integer.valueOf(targetObj.getTreeCode().substring(targetObj.getParentSubject().getTreeCode().length()));
                    if(moveType.equalsIgnoreCase("next")){
                        order = targetObj.getOrder()+1;
                        treeCode = this.daoFacade.getSubjectDao().getTreeCode(targetObj.getParentSubject().getTreeCode(),targetObj.getTreeCode());
                    }else{
                        order = targetObj.getOrder();
                        treeCode = targetObj.getTreeCode();
                    }
                    codeMap.put("parentId", targetObj.getParentSubject()==null?"0":targetObj.getParentSubject().getId());
                    List<BSubject> list = this.getSubList(codeMap, " order by a.order ");
                    if(list!=null&&list.size()>0){
                        for(BSubject obj:list){
                            //修改同级的treecode和order
                            String objTCode = obj.getParentSubject().getTreeCode();
                            int l = objTCode.equals("")?0:objTCode.length();
                            Integer other = Integer.valueOf(obj.getTreeCode().substring(l));
                            if(target<=other){
                                obj.setTreeCode(this.daoFacade.getSubjectDao().getTreeCode(objTCode,obj.getTreeCode()));
                            }
                            if(order<=obj.getOrder()){
                                obj.setOrder(obj.getOrder()+1);
                            }
                            //保存修改
                            this.daoFacade.getSubjectDao().updateSubjectBySql(obj);
                        }
                    }
                }
                posObj.setOrder(order);
                BSubject parent = new BSubject();
                if(moveType.equalsIgnoreCase("inner")){
                    parent.setId(form.getId());
                }else{
                    parent.setId(targetObj.getParentSubject().getId());
                }
                posObj.setParentSubject(parent);
                posObj.setTreeCode(treeCode);
                //更新要移动的对象
                this.daoFacade.getSubjectDao().updateSubjectBySql(posObj);
                //更新移动目标下边的分类的treecode
                this.daoFacade.getSubjectDao().batchUpTreeCode(posObj.getTreeCode(), oldTreeCode);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.pos.change.error", e);//移动分类失败！
		}
	}
	
	public BSubject getSubjectByCode(String code,String typeCode)throws Exception{
		BSubject BSubject = null;
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("code",code);
			condition.put("typeCode", typeCode);
			List<BSubject> list = this.getSubjectList(condition,"");
			if(list!=null&&!list.isEmpty()&&list.size()==1){
				BSubject = list.get(0);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "BSubject.info.get.error", e);//获取分类信息失败！
		}
		return BSubject;
	}
	
	public BSubject getSubjectTypeByCode(String typeCode)throws Exception{
		BSubject BSubject = null;
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("parentId", "0");
			condition.put("code", typeCode);
			List<BSubject> typeList = this.getSubjectList(condition,"");
			if(typeList!=null&&!typeList.isEmpty()&&typeList.size()==1){
				BSubject = typeList.get(0);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "BSubject.info.get.error", e);//获取分类信息失败！
		}
		return BSubject;
	}

	public List<BSubject> getSubjectListToContent(
			Map<String, Object> condition, String sort) throws Exception {
		List<BSubject> list = null;
		try {
			list = this.daoFacade.getSubjectDao().getListToContent(condition,sort);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "BSubject.info.get.error", e);//获取分类信息失败！
		}
		return list;
	}
	public List<PCSRelation> getPCsRelationList(Map<String, Object> condition,
			String sort) throws Exception {
		List<PCSRelation> list = null;
		try {
//			list = this.daoFacade.getPcsRelationDao().getList(condition, sort);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "PCsRelation.Parser.BSubject.Miss", e);//查询产品分类关系信息失败
		}
		return list;
	}

	public List<BSubject> getPubSubjectList(Map<String, Object> condition,
			String sort) throws Exception {
		List<BSubject> list = null;
		try {
			list = this.daoFacade.getSubjectDao().getPubSubList(condition, sort);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BSubject.info.list.error", e);//获取分类信息列表失败！
		}
		return list;
	}
	public List<BSubject> getDistinctCodeList()
			throws Exception {
		List<BSubject> list= null;
		try {
			list = this.daoFacade.getbSubjectDao().getDistinctCodeList();
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "Subject.info.list.error", e);//获取分类信息列表失败！
		}
		return list;
	}
	public List<BSubject> getDistinctNameList()
			throws Exception {
		List<BSubject> list= null;
		try {
			list = this.daoFacade.getbSubjectDao().getDistinctNameList();
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "Subject.info.list.error", e);//获取分类信息列表失败！
		}
		return list;
	}
	public Integer getRelationCount(Map<String, Object> condition)throws Exception {
		Integer num = 0;
		try {
			System.out.println(this.daoFacade.getSubRelationDao());
			num = this.daoFacade.getSubRelationDao().getRelationCount(condition);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "subject.relation.count.error", e);//获取分类关系总数失败！
		}
		return num;
	}
	public List<BSubRelation> getRelationPagingList(Map<String, Object> condition,String sort,Integer pageCount,Integer page)
			throws Exception {
		List<BSubRelation> list = null;
		try {
			list = this.daoFacade.getSubRelationDao().getRelationPagingList(condition,sort,pageCount,page);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "subject.relation.page.list.error", e);//获取分类关系列表失败！
		}
		return list;
	}
	
}
