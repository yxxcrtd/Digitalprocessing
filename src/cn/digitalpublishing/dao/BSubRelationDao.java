package cn.digitalpublishing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.util.CollectionsUtil;
import cn.digitalpublishing.po.BSubRelation;

public class BSubRelationDao extends CommonDao<BSubRelation, String> {

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
		 * 1.baseCode 
		 * 用来通过treeCode模糊查询
		 */
		if(CollectionsUtil.exist(map, "baseCode")&&!"".equals(map.get("baseCode"))){
			if(flag==0){
				whereString+=" where b.treeCode like ? and b.treeCode!= ? ";
				flag=1;
			}else{
				whereString+=" and b.treeCode like ? and b.treeCode!= ? ";
			}
			condition.add(map.get("baseCode").toString()+"%");
			condition.add(map.get("baseCode").toString());
		}
		/**
		 * 2.code 
		 * 用来通过code查询
		 */
		if(CollectionsUtil.exist(map, "code")&&!"".equals(map.get("code"))){
			boolean isPrecise=CollectionsUtil.exist(map, "isPrecise")?Boolean.valueOf(map.get("isPrecise").toString()):true;
			if(isPrecise){
				if(flag==0){
					whereString+=" where b.code = ?";
					flag=1;
				}else{
					whereString+=" and b.code = ?";
				}
				condition.add(map.get("code"));
			}else{
				if(flag==0){
					whereString+=" where lower(b.code) like ?";
					flag=1;
				}else{
					whereString+=" and lower(b.code) like ?";
				}
				condition.add("%"+map.get("code").toString().trim().toLowerCase()+"%");
			}
		}
		/**
		 * 3.name 
		 * 用来通过name查询
		 */
		if(CollectionsUtil.exist(map, "name")&&!"".equals(map.get("name"))){
			if(flag==0){
				whereString+=" where lower(b.name) like ? ";
				flag=1;
			}else{
				whereString+=" and lower(b.name) like ? ";
			}
			condition.add("%"+map.get("name").toString().trim().toLowerCase()+"%");
		}
		
		/**
		 * 4.mainSubId 
		 * 用来主分类ID查询
		 */
		if(CollectionsUtil.exist(map, "mainSubId")&&!"".equals(map.get("mainSubId"))){
			if(flag==0){
				whereString+=" where a.mainSub.id = ? ";
				flag=1;
			}else{
				whereString+=" and a.mainSub.id = ? ";
			}
			condition.add(map.get("mainSubId"));
		}
		
		/**
		 * 5.elseSubId 
		 * 用来其他分类Id查询
		 */
		if(CollectionsUtil.exist(map, "elseSubId")&&!"".equals(map.get("elseSubId"))){
			if(flag==0){
				whereString+=" where b.id = ? ";
				flag=1;
			}else{
				whereString+=" and b.id = ? ";
			}
			condition.add(map.get("elseSubId"));
		}
		
		/**
		 * 6.typeCode
		 */
		if(CollectionsUtil.exist(map, "typeCode")&&!"".equals(map.get("typeCode"))){
			if(flag==0){
				whereString+=" where substring(b.treeCode,1,3) = (Select c.treeCode from BSubject c where c.parentSubject is null and upper(c.code) = ?)";
				flag=1;
			}else{
				whereString+=" and substring(b.treeCode,1,3) = (Select c.treeCode from BSubject c where c.parentSubject is null and upper(c.code) = ?)";
			}
			condition.add(map.get("typeCode").toString().toUpperCase());
		}
		/**
		 * 7.elseCode 
		 * 用来其他分类Id查询
		 */
		if(CollectionsUtil.exist(map, "elseCode")&&!"".equals(map.get("elseCode"))){
			if(flag==0){
				whereString+=" where a.elseCode = ? ";
				flag=1;
			}else{
				whereString+=" and a.elseCode = ? ";
			}
			condition.add(map.get("elseCode"));
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
			String bCode=isPrecise?"b.code":"lower(b.code)";
			if(flag == 0)
			{
				where_ += " where "+bCode+" in ( ";
				flag = 1;
			}else
			{
				where_ +=" and "+bCode+" in ( ";
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
	
	@SuppressWarnings("unchecked")
	public Integer getCount(Map<String, Object> condition) throws Exception{
		List<BSubRelation> list=null;
		Map<String,Object> t=this.getWhere(condition);
		String hql=" from BSubRelation a left join a.elseSub b ";
		try{
			list=this.hibernateDao.getListByHql("id","cast(count(*) as string)", hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),"", BSubRelation.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list==null?0:Integer.valueOf(list.get(0).getId());
	}
	
	@SuppressWarnings("unchecked")
	public Integer getRelationCount(Map<String, Object> condition) throws Exception{
		List<BSubRelation> list=null;
		Map<String,Object> t=this.getWhere(condition);
		String hql=" from BSubRelation a right join a.elseSub b ";
		try{
			list=this.hibernateDao.getListByHql("id","cast(count(*) as string)", hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),"", BSubRelation.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list==null?0:Integer.valueOf(list.get(0).getId());
	}

	@SuppressWarnings("unchecked")
	public List<BSubRelation> getRelationPagingList(Map<String, Object> condition,String sort, Integer pageCount, Integer page)throws Exception {
		List<BSubRelation> list = null;
		String hql=" from BSubRelation a right join a.elseSub b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,mainCode,elseCode,mainSub.id,elseSub.id,elseSub.name,elseSub.code";
		String field="a.id,a.mainCode,a.elseCode,a.mainSub.id,b.id,b.name,b.code";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),sort, BSubRelation.class.getName(),pageCount,page*pageCount);
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BSubRelation> getList(Map<String, Object> condition,String sort)throws Exception {
		List<BSubRelation> list = null;
		String hql=" from BSubRelation a right join a.elseSub b ";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,mainCode,elseCode,mainSub.id,elseSub.id,elseSub.name,elseSub.code,mainSub.code,mainSub.name,mainSub.nameEn";
		String field="a.id,a.mainCode,a.elseCode,a.mainSub.id,b.id,b.name,b.code,a.mainSub.code,a.mainSub.name,a.mainSub.nameEn";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),sort, BSubRelation.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	/**
	 * 根据其他分类的Id，删除映射关系
	 * @param string
	 */
	public void deleteByelseId(String coopId)throws Exception {
		try{
			String hql = "delete from BSubRelation a where a.elseSub.id=?";
			Object[] condition = new Object[]{coopId};
			this.hibernateDao.executeHql(hql, condition);
		}catch(Exception e){
			throw e;
		}
	}
}
