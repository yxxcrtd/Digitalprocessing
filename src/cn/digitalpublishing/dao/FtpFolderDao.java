package cn.digitalpublishing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.CollectionsUtil;
import cn.com.daxtech.framework.util.hql.DaoHelper;
import cn.digitalpublishing.po.FtpFolder;
public class FtpFolderDao extends CommonDao<FtpFolder, String> {
	
	private Map<String,Object> getWhere(Map<String,Object> map){
		Map<String,Object> table=new HashMap<String,Object>();
		String whereString="";
		List<Object> condition=new ArrayList<Object>();
		int flag=0;
		/**
		 * 1.name
		 */
		if(CollectionsUtil.exist(map, "ftpname")&&!"".equals(map.get("ftpname"))){
			if(flag==0){
				whereString+=" where lower(b.ftpname) like ?";
				flag=1;
			}else{
				whereString+=" and lower(b.ftpname) like ?";
			}
			condition.add("%"+map.get("ftpname").toString().trim().toLowerCase()+"%");
		}

		/**
		 * 2.url
		 */
		if(CollectionsUtil.exist(map, "url")&&!"".equals(map.get("url"))){
			if(flag==0){
				whereString+=" where lower(a.url) like ?";
				flag=1;
			}else{
				whereString+=" and lower(a.url) =  like ?";
			}
			condition.add("%"+map.get("url").toString().trim().toLowerCase()+"%");
		}
		
//		/**
//		 * 3.flag
//		 */
//		if(CollectionsUtil.exist(map, "flag")&&!"".equals(map.get("flag"))){
//			boolean isPrecise=CollectionsUtil.exist(map, "isPrecise")?Boolean.valueOf(map.get("isPrecise").toString()):true;
//			if(isPrecise){
//				if(flag==0){
//					whereString+=" where lower(b.flag) = ?";
//					flag=1;
//				}else{
//					whereString+=" and lower(b.flag) = ?";
//				}
//				condition.add(Integer.valueOf(map.get("flag").toString()));
//			}else{
//				if(flag==0){
//					whereString+=" where lower(b.flag) = ?";
//					flag=1;
//				}else{
//					whereString+=" and lower(b.flag) = ?";
//				}
//				condition.add(Integer.valueOf(map.get("flag").toString()));
//			}
//		}
		
		
		/**
		 * 4.ftpid
		 */
		if(CollectionsUtil.exist(map, "ftpid")&&!"".equals(map.get("ftpid"))){
			if(flag==0){
				whereString+=" where lower(a.ftpConfig.id) = ?";
				flag=1;
			}else{
				whereString+=" and lower(a.ftpConfig.id) = ?";
			}
			condition.add(map.get("ftpid").toString().trim().toLowerCase());
		}
		
		table.put("where",whereString);
		table.put("condition", condition);
		return table;
	}
	
	public List<FtpFolder> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart, HqlBean hqlBean)throws Exception{
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<FtpFolder> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName(), pageCount, countStart);
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Integer getCount(Map<String, Object> condition,HqlBean hqlBean) throws Exception{
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<FtpFolder> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName());
			return list == null ? 0 :Integer.valueOf(list.get(0).getId());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 获取配置列表
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FtpFolder> getList(Map<String,Object> condition,String sort)throws Exception{
		List<FtpFolder> list=null;
		String hql=" from FtpFolder a left join a.ftpConfig b";
		Map<String,Object> t=this.getWhere(condition);
		
		String property="id,ftpConfig,url,folderName,depict ";
		String field="a.id,a.ftpConfig,a.url,a.folderName,a.depict ";
		
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),sort, FtpFolder.class.getName());
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	public List<FtpFolder> getFtpDirByFtpid(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		List<FtpFolder> list=null;
		String hql=" from FtpFolder a";
		Map<String,Object> t=this.getWhere(condition);
		String property="id,url,folderName ";
		String field="a.id,a.url,a.folderName ";
		try{
			list=super.hibernateDao.getListByHql(property,field, hql+t.get("where").toString(), ((List<Object>)t.get("condition")).toArray(),"", FtpFolder.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
	
	

