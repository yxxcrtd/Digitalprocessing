package cn.digitalpublishing.dao;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.DaoHelper;
import cn.digitalpublishing.po.Template;

public class TemplateDao extends CommonDao<Template,String> {
	
	/**
	 * 获取分页信息
	 * @param condition
	 * @param sort
	 * @param pageCount
	 * @param page
	 * @param hqlBean 
	 * @return
	 * @throws Exception
	 */
	public List<Template> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page, HqlBean hqlBean)throws Exception{
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<Template> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName(), pageCount, page);
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 获取总数
	 * @param condition
	 * @param hqlBean 
	 * @return
	 * @throws Exception
	 */
	public Integer getCount(Map<String,Object> condition, HqlBean hqlBean)throws Exception{
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<Template> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName());
			return list == null ? 0 :Integer.valueOf(list.get(0).getId());
		} catch (Exception e) {
			throw e;
		}
	}
	public List<Template> getList(Map<String, Object> condition, String sort,
			HqlBean hqlBean) throws Exception {
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<Template> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName());
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
}
