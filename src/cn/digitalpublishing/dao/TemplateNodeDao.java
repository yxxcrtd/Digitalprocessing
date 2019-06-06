package cn.digitalpublishing.dao;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.DaoHelper;
import cn.digitalpublishing.po.TemplateNode;
import cn.digitalpublishing.po.XmlNode;

@SuppressWarnings("unchecked")
public class TemplateNodeDao extends CommonDao<TemplateNode, String> {

	/**
	 * 获取总数（根据源ID获取目标模板节点列表）
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public Integer getCount(Map<String, Object> condition, HqlBean hqlBean) throws Exception {
		DaoHelper helper = new DaoHelper();
		String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
		List<TemplateNode> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName());
		return list == null ? 0 : Integer.valueOf(list.get(0).getId());
	}


	/**
	 * 获取分页信息（根据源ID获取用户模板节点列表）
	 * 
	 * @param condition
	 * @param sort
	 * @param pageCount
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<TemplateNode> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer countStart, HqlBean hqlBean) throws Exception {
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<TemplateNode> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, null == helper.getCondition() ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName(), pageCount, countStart);
			return list;
		} catch (Exception e) {
			throw e;
		}
	}



	public List<TemplateNode> getList(Map<String, Object> condition,
			String sort, HqlBean hqlBean) throws Exception {
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			List<TemplateNode> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),hqlBean.getOrder(), hqlBean.getClassName());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
