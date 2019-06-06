package cn.digitalpublishing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.util.CollectionsUtil;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.springmvc.form.SubjectForm;

public class BSubjectDao extends CommonDao<BSubject, String> {

	/**
	 * 条件
	 * @param map
	 * @return
	 */
	private Map<String,Object> getWhere(Map<String,Object> map){
		Map<String,Object> table=new HashMap<String,Object>();
		String whereString="";
		List<Object> condition=new ArrayList<Object>();
		int flag=0;
		/**
		 * 1.type
		 */
		if(CollectionsUtil.exist(map, "type")&&!"".equals(map.get("type"))){
			if(flag==0){
				whereString+=" where a.type = ?";
				flag=1;
			}else{
				whereString+=" and a.type = ?";
			}
			condition.add(map.get("type"));
		}
		/**
		 * 2.changOrder
		 */
		if(CollectionsUtil.exist(map, "changOrder")&&!"".equals(map.get("changOrder"))){
			if(flag==0){
				whereString+=" where a.order >= ?";
				flag=1;
			}else{
				whereString+=" and a.order >= ?";
			}
			condition.add(Integer.valueOf(map.get("changOrder").toString()));
		}
		/**
		 * 3.parentId
		 * */
		if(CollectionsUtil.exist(map, "parentId")&&!"".equals(map.get("parentId"))){
			if (map.get("parentId").toString().equals("0")) {
				if (flag == 0) {
					whereString = whereString + " where b.id is null";
			        flag = 1;
			    } else {
			        whereString = whereString + " and b.id is null";
			    }
			}else if(map.get("parentId").toString().equals("-1")){
				if (flag == 0) {
					whereString = whereString + " where b.id is not null";
			        flag = 1;
			    } else {
			        whereString = whereString + " and b.id is not null";
			    }
			}else{
		        if (flag == 0) {
		          whereString = whereString + " where b.id = ?";
		          flag = 1;
		        } else {
		          whereString = whereString + " and b.id = ?";
		        }
		        condition.add(map.get("parentId").toString());
		    }
		}
		/**
		 * 4.subId
		 */
		if(CollectionsUtil.exist(map, "subId")&&!"".equals(map.get("subId"))){
			if(flag==0){
				whereString+=" where a.id = ?";
				flag=1;
			}else{
				whereString+=" and a.id = ?";
			}
			condition.add(map.get("subId").toString());
		}
		
		/**
		 * 5.uniqueId
		 */
		if(CollectionsUtil.exist(map, "uniqueId")&&!"".equals(map.get("uniqueId"))){
			if(flag==0){
				whereString+=" where a.id <> ?";
				flag=1;
			}else{
				whereString+=" and a.id <> ?";
			}
			condition.add(map.get("uniqueId"));
		}
		/**
		 * code
		 */
		if(CollectionsUtil.exist(map, "code")&&!"".equals(map.get("code"))){
			if(flag==0){
				whereString+=" where a.code =  ?";
				flag=1;
			}else{
				whereString+=" and a.code =  ?";
			}
			condition.add(map.get("code").toString().trim());
		}
		/**
		 * code
		 */
		if(CollectionsUtil.exist(map, "lowerCode")&&!"".equals(map.get("lowerCode"))){
			if(flag==0){
				whereString+=" where lower(a.code) =  ?";
				flag=1;
			}else{
				whereString+=" and lower(a.code) =  ?";
			}
			condition.add(map.get("lowerCode").toString().toLowerCase().trim());
		}
		/**
		 * checkTreeCode
		 */
		if(CollectionsUtil.exist(map, "checkTreeCode")&&!"".equals(map.get("checkTreeCode"))){
			if(flag==0){
				whereString+=" where a.treeCode like ?";
				flag=1;
			}else{
				whereString+=" and a.treeCode like ?";
			}
			condition.add(map.get("checkTreeCode").toString().substring(0, 3)+"%");
		}
		
		/**
		 * 6.code
		 */
		if(CollectionsUtil.exist(map, "allcode")&&!"".equals(map.get("allcode"))&&map.get("allcode")!=null){
			boolean isPrecise=CollectionsUtil.exist(map, "isPrecise")?Boolean.valueOf(map.get("isPrecise").toString()):true;
			if(isPrecise){
				if(flag==0){
					whereString+=" where lower(a.code) = ?";
					flag=1;
				}else{
					whereString+=" and lower(a.code) = ?";
				}
				condition.add(map.get("allcode").toString().trim().toLowerCase());
			}else{
				if(flag==0){
					whereString+=" where lower(a.code) like ?";
					flag=1;
				}else{
					whereString+=" and lower(a.code) like ?";
				}
				condition.add("%"+map.get("allcode").toString().trim().toLowerCase()+"%");
			}
		}
		
		/**
		 * 7.typeCode
		 */
		if(CollectionsUtil.exist(map, "typeCode")&&!"".equals(map.get("typeCode"))){
			if(flag==0){
				whereString+=" where substring(a.treeCode,1,3) = (Select c.treeCode from BSubject c where c.parentSubject is null and c.code = ?)";
				flag=1;
			}else{
				whereString+=" and substring(a.treeCode,1,3) = (Select c.treeCode from BSubject c where c.parentSubject is null and c.code = ?)";
			}
			condition.add(map.get("typeCode"));
		}
		
		/**
		 * 8.nameEn
		 */
		if(CollectionsUtil.exist(map, "nameEn")&&!"".equals(map.get("nameEn"))){
			if(flag==0){
				whereString+=" where a.nameEn = ?";
				flag=1;
			}else{
				whereString+=" and a.nameEn = ?";
			}
			condition.add(map.get("nameEn"));
		}
		
		/**
		 * 9.matchMode
		 */
		if(CollectionsUtil.exist(map, "matchMode")&&!"".equals(map.get("matchMode"))){
			if(flag==0){
				whereString+=" where a.matchMode = ?";
				flag=1;
			}else{
				whereString+=" and a.matchMode = ?";
			}
			condition.add(map.get("matchMode"));
		}
		
		/**
		 * 10.code
		 */
		if(CollectionsUtil.exist(map, "codeArray")&&map.get("codeArray")!=null){
			boolean isPrecise=CollectionsUtil.exist(map, "isPrecise")?Boolean.valueOf(map.get("isPrecise").toString()):false;//默认为非精确匹配
			String[] codeArray = (String[])map.get("codeArray");
			String where_ = "";
			String where = "";
			String _where = ") ";
			String aCode=isPrecise?"a.code":"lower(a.code)";
			if(flag == 0)
			{
				where_ += " where "+aCode+" in ( ";
				flag = 1;
			}else
			{
				where_ +=" and "+aCode+" in ( ";
			}
			if(codeArray!=null){
				int l = codeArray.length;
				for (int i = 0; i < l; i++) {
					where += " ? ";
					if(i+1!=l){
						where += ",";
					}
					condition.add(isPrecise?codeArray[i]:codeArray[i].toLowerCase());
				}
			}
			whereString += where_+where+_where;
		}

		table.put("where",whereString);
		table.put("condition", condition);
		return table;
	}
	
	/**
	 * 获取列表
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BSubject> getList(Map<String,Object> condition,String sort)throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a left join a.parentSubject b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,nameEn,code,name,type,order,desc,treeCode,standard" +
				",parentSubject.id,parentSubject.name,isParent,parentSubject.code,matchMode";
		String field="a.id,a.nameEn,a.code,a.name,a.type,a.order,a.desc,a.treeCode,a.standard" +
				",b.id,b.name,(select cast(count(*) as int ) from BSubject c where c.parentSubject.id=a.id),b.code,a.matchMode";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	/**
	 * 查询编号
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BSubject> getCodeList(Map<String,Object> condition,String sort)throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a  ";
		Map<String,Object> t=this.getWhere(condition);
		String property="code,name" ;
		String field="a.code,a.name" ;
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	/**
	 * 查询编号
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BSubject> getDistinctCodeList()throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a  ";
		Map<String,Object> t=this.getWhere(null);
		String property="code" ;
		String field="distinct a.code" ;
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray()," order by a.code ", BSubject.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	/**
	 * 查询分类名
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BSubject> getDistinctNameList()throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a  ";
		Map<String,Object> t=this.getWhere(null);
		String property="name" ;
		String field="distinct a.name" ;
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray()," order by a.name ", BSubject.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BSubject> getSubList(Map<String,Object> condition,String sort)throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a left join a.parentSubject b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,nameEn,code,name,type,order,desc,treeCode,standard" +
				",parentSubject.id,parentSubject.name,treeCode,isParent,parentSubject.treeCode,parentSubject.order,matchMode";
		String field="a.id,a.nameEn,a.code,a.name,a.type,a.order,a.desc,a.treeCode,a.standard" +
				",b.id,b.name,a.treeCode,(select cast(count(*) as int ) from BSubject c where c.parentSubject.id=a.id),b.treeCode,b.order,a.matchMode";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	
	/**
	 * 获取分页信息
	 * @param condition
	 * @param sort
	 * @param pageCount
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BSubject> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a left join a.parentSubject b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,nameEn,code,name,type,order,desc,treeCode,standard" +
				",parentSubject.id,parentSubject.name,treeCode,isParent,parentSubject.treeCode,parentSubject.order,matchMode";
		String field="a.id,a.nameEn,a.code,a.name,a.type,a.order,a.desc,a.treeCode,a.standard" +
				",b.id,b.name,a.treeCode,(select cast(count(*) as int ) from BSubject c where c.parentSubject.id=a.id),b.treeCode,b.order,a.matchMode";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName(),pageCount,page*pageCount);
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	/**
	 * 获取总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(Map<String,Object> condition)throws Exception{
		List<BSubject> list=null;
		Map<String,Object> t=this.getWhere(condition);
		String hql=" from BSubject a left join a.parentSubject b ";
		try{
			list=this.hibernateDao.getListByHql("id","cast(count(*) as string)", hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),"", BSubject.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list==null?0:Integer.valueOf(list.get(0).getId());
	}
	
	 /**
	  * 获取排序数
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Integer getNextOrder(Map<String,Object> condition, String sort)throws Exception{
		Integer order = Integer.valueOf(1);
		try {
		   List<BSubject> list = null;
		   Map<String,Object> t=this.getWhere(condition);
		   String hql = " from BSubject a left join a.parentSubject b";
		   list = this.hibernateDao.getListByHql("order", "a.order", hql + t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(), sort, BSubject.class.getName(), 1, 0);
		   order = Integer.valueOf((list == null) || (list.isEmpty()) ? 1 : list.get(0) == null ? 1 : ((BSubject)list.get(0)).getOrder().intValue() + 1);
		 } catch (Exception e) {
		   throw e;
		 }
		return order;
	}

	/**
	* 获取编码
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getNextCode(Map<String,Object> condition, String sort)throws Exception{
		String code = "";
		try {
		  String parCode = "";
		  if(CollectionsUtil.exist(condition, "parentId")&&!"".equals(condition.get("parentId"))){
			  if ((condition.get("parentId") != null) && (condition.get("parentId").toString().trim().length() > 0L) && (!condition.get("parentId").toString().equals("0"))) {
			    BSubject obj = (BSubject)this.hibernateDao.getById(BSubject.class.getName(), condition.get("parentId").toString());
			    parCode = obj.getTreeCode();
			  }
			  List<BSubject> list = null;
			  Map<String,Object> t=this.getWhere(condition);
			  String hql = " from BSubject a left join a.parentSubject b ";
			  String _hql = hql + t.get("where").toString();
			  list = this.hibernateDao.getListByHql("treeCode", "a.treeCode", _hql, ((List<Object>)t.get("condition")).toArray(), sort, BSubject.class.getName(), 1, 0);
			  code = (list == null) || (list.isEmpty()) ? "001" : list.get(0) == null ? "001" : ((BSubject)list.get(0)).getTreeCode();
			    
			  if ((list == null) || (list.isEmpty())) {//如果list为空，说明这个父类下还没有子类
			  	 code = "000";
			  }else{
			     if (parCode.trim().length() > 0) {
			    	code = code.substring(parCode.length());
			     }
//				      code = code.equals("")?"0":code;
			  }
			     int num = Integer.valueOf(code).intValue();
			     num++;
			     String mid = String.valueOf(num);
			     if (mid.length() == 1) {
			      code = "00" + mid;
			     }
			     if (mid.length() == 2) {
			       code = "0" + mid;
			     }
			     if (mid.length() == 3) {
			      code = mid;
				 }
			      code = parCode + code;
			  }
//		  }
		}catch(Exception e) {
			  throw e;
		}
		return code;
	}
			
	/**
	* 插入
	* @param obj
	* @throws Exception
	*/
	public void insertSubject(BSubject obj)throws Exception{
		try{
			this.hibernateDao.save(obj);
		}catch(Exception e){
			throw e;
		}
	}

	/**
	* 修改
	* @param obj
	* @param id
	* @param properties
	* @throws Exception
	*/
	public void updateSubject(BSubject obj, String id, String[] properties) throws Exception {
		try{
			this.hibernateDao.update(obj, BSubject.class.getName(), id, properties);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 通过sql更新分类
	 * @param obj
	 * @throws Exception
	 */
	public boolean updateSubjectBySql(BSubject obj)throws Exception{
		StringBuffer sql = new StringBuffer();
		List<Object> condition=new ArrayList<Object>();
		try {
			if(obj==null||obj.getId()==null||"".equals(obj.getId())){
				return false;
			}
			sql.append("update DCC_B_SUBJECT set ");
			if(obj.getCode()!=null&&!"".equalsIgnoreCase(obj.getCode())){
				sql.append(" SUBJECT_CODE = ? ,");
				condition.add(obj.getCode());
			}
			if(obj.getName()!=null&&!"".equals(obj.getName())){
				sql.append(" SUBJECT_NAME = ? ,");
				condition.add(obj.getName());
			}
			if(obj.getOrder()!=null&&obj.getOrder()>0){
				sql.append(" SUBJECT_ORDER = ? ,");
				condition.add(obj.getOrder());
			}
			if(obj.getType()!=null&&obj.getType()>0){
				sql.append(" SUBJECT_TYPE = ? ,");
				condition.add(obj.getType());
			}
			if(obj.getTreeCode()!=null&&!"".equals(obj.getTreeCode())){
				sql.append(" SUBJECT_TREE_CODE = ? ,");
				condition.add(obj.getTreeCode());
			}
			if(obj.getDesc()!=null&&!"".equals(obj.getDesc())){
				sql.append(" SUBJECT_DESC = ? ,");
				condition.add(obj.getDesc());
			}
			if(obj.getStandard()!=null&&!"".equals(obj.getStandard())){
				sql.append(" STANDARD = ? ,");
				condition.add(obj.getStandard());
			}
			if(obj.getParentSubject()!=null&&obj.getParentSubject().getId()!=null&&!"".equals(obj.getParentSubject().getId())){
				sql.append(" SUBJECT_PARENT_ID = ? ,");
				condition.add(obj.getParentSubject().getId());
			}
			String sql2 = sql.toString().substring(0, sql.toString().lastIndexOf(","));
			sql2 += " where SUBJECT_ID = ? ";
			condition.add(obj.getId());
			
			int t = this.hibernateDao.executeSql(sql2, condition.toArray());
			if(t>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 处理分类法移动
	 * @param form
	 * @throws Exception
	 */
	public void posChange(SubjectForm form) throws Exception {
		String moveType=form.getMoveType();
		String oldTreeCode = "";
		String treeCode = "";
		Integer order = 1;
		try {
			//创建要移动对象 和 移动位置对象
			BSubject posObj = (BSubject)this.get(BSubject.class.getName(), form.getChangeId());
			BSubject targetObj = (BSubject)this.get(BSubject.class.getName(), form.getId());
			oldTreeCode = posObj.getTreeCode();
			
				//要移动的目标的pId=移动位置ID
				//要移动的目标的order=移动位置下子分类的最后一个order+1
				//要移动的目标的treecode=移动位置下子分类的最后一个treecode+1
				Map<String,Object> codeMap = new HashMap<String,Object>();
			    codeMap.put("parentId", form.getId());
			    //根据moveType进行处理
				if(moveType.equalsIgnoreCase("inner")){
				    treeCode = this.getNextCode(codeMap," order by a.treeCode desc ");
				    order = this.getNextOrder(codeMap," order by a.order desc ");
				}else{
					//查询目标位置的所有同级分类
					Integer target = Integer.valueOf(targetObj.getTreeCode().substring(targetObj.getParentSubject().getTreeCode().length()));
//					if(moveType.equalsIgnoreCase("next")){
//						order = targetObj.getOrder()+1;
//						treeCode = getTreeCode(targetObj.getParentSubject().getTreeCode(),targetObj.getTreeCode());
//					}else{
						order = targetObj.getOrder();
						treeCode = targetObj.getTreeCode();
//					}
					codeMap.put("parentId", targetObj.getParentSubject()==null?"0":targetObj.getParentSubject().getId());
					List<BSubject> list = this.getSubList(codeMap, " order by a.order ");
					if(list!=null&&list.size()>0){
						for(BSubject obj:list){
							//修改同级的treecode和order
							String objTCode = obj.getParentSubject().getTreeCode();
							int l = objTCode.equals("")?0:objTCode.length();
							Integer other = Integer.valueOf(obj.getTreeCode().substring(l));
							if(target<=other){
								obj.setTreeCode(getTreeCode(objTCode,obj.getTreeCode()));
							}
							if(order<=obj.getOrder()){
								obj.setOrder(obj.getOrder()+1);
							}
							//保存修改
							this.updateSubjectBySql(obj);
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
			    this.updateSubjectBySql(posObj);
				//更新移动目标下边的分类的treecode
				this.batchUpTreeCode(posObj.getTreeCode(), oldTreeCode);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void batchUpTreeCode(String srcCode,String oldCode)throws Exception{
		try {
			//批量进行treecode处理
			String hql=" update BSubject a set a.treeCode=concat('"+srcCode+"',substring(a.treeCode,"+(srcCode.length()+1)+",length(a.treeCode)-"+srcCode.length()+")) where a.code like '"+oldCode+"%' ";
			this.hibernateDao.executeHql(hql,null);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @param parCode 父类treecode
	 * @param code    子类目前code
	 * @return
	 * @throws Exception
	 */
	public String getTreeCode(String parCode,String code)throws Exception{
		if (parCode.trim().length() > 0) {
	    	code = code.substring(parCode.length());
	     }
	     int num = Integer.valueOf(code).intValue();
	     num++;
	     String mid = String.valueOf(num);
	     if (mid.length() == 1) {
	      code = "00" + mid;
	     }
	     if (mid.length() == 2) {
	       code = "0" + mid;
	     }
	     if (mid.length() == 3) {
	      code = mid;
		 }
	     code = parCode + code;
	     return code;
	}
	/**
	 * @param parCode 父类treecode
	 * @param code    子类目前code
	 * @return
	 * @throws Exception
	 */
	public String getTreeCode2(String parCode,String code)throws Exception{
		if (parCode.trim().length() > 0) {
			code = code.substring(parCode.length());
		}
		int num = Integer.valueOf(code).intValue();
		num--;
		String mid = String.valueOf(num);
		if (mid.length() == 1) {
			code = "00" + mid;
		}
		if (mid.length() == 2) {
			code = "0" + mid;
		}
		if (mid.length() == 3) {
			code = mid;
		}
		code = parCode + code;
		return code;
	}

	public List<BSubject> getListToContent(Map<String, Object> condition,
			String sort) throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a left join a.parentSubject b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,nameEn,code,name,type,order,desc,treeCode,standard" +
				",parentSubject.id,parentSubject.name,isParent,parentSubject.code";
		if(CollectionsUtil.exist(condition, "pubId")&&condition.get("pubId")!=null&&!"".equals(condition.get("pubId"))){
			property += ",checked";
		}
		String field="a.id,a.nameEn,a.code,a.name,a.type,a.order,a.desc,a.treeCode,a.standard" +
				",b.id,b.name,(select cast(count(*) as int ) from BSubject c where c.parentSubject.id=a.id),b.code" ;
		if(CollectionsUtil.exist(condition, "pubId")&&condition.get("pubId")!=null&&!"".equals(condition.get("pubId"))){
			field += ",(select cast(count(*) as int ) from PCSRelation cs where cs.content.id='"+condition.get("pubId").toString().trim()+"' and cs.subject.id=a.id )";
		}
				
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<BSubject> getPubSubList(Map<String,Object> condition,String sort)throws Exception{
		List<BSubject> list=null;
		String hql=" from BSubject a left join a.parentSubject b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,nameEn,code,name,type,order,desc,treeCode,standard";
		String field="a.id,a.nameEn,a.code,a.name,a.type,a.order,a.desc,a.treeCode,a.standard";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where"),((List<Object>)t.get("condition")).toArray(),sort, BSubject.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	
}
