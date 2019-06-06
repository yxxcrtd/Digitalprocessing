package cn.digitalpublishing.service.impl;


import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.service.ResourceService;

public class ResourceServiceImpl extends BaseServiceImpl implements ResourceService {

	
	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ResourceDao").get("getCount");
		try {
			num = this.daoFacade.getResourceDao().getCount(map, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	/*
	 * 
	 * @see cn.digitalpublishing.service.ResourceService#getResourcePagingList(java.util.Map, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Resource> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws Exception {
		List<Resource> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ResourceDao").get("getPagingList");
		try {
			list = this.daoFacade.getResourceDao().getResourcePagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "失败！", e);
		}
		return list;
	}
	
	public void update(Resource resource, String id, String[] properties) throws CcsException {

		try {
			this.daoFacade.getResourceDao().update(resource, Resource.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败", e);
		}

	}
	
	@Override
	public void delete(String id) throws Exception {
		try {
			this.daoFacade.getResourceDao().delete(Resource.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败！", e);
		}
	}

	@Override
	public void addObj(Resource resource) throws CcsException {
		// TODO Auto-generated method stub
		try {
			this.daoFacade.getResourceDao().insert(resource);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "添加信息失败！", e);
		}
	}
	
	
	@Override
	public Resource findById(String id) throws Exception {
		// TODO Auto-generated method stub
		Resource resource = null;
		try {
			resource = (Resource) daoFacade.getResourceDao().get(Resource.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找失败", e);
		}
		return resource;
	}
	
	@Override
	public List<Resource> getList(Map<String,Object> condition, String sort) throws Exception {
		List<Resource> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ResourceDao").get("getList");
		try {
			list = this.daoFacade.getResourceDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "失败！", e);
		}
		return list;
	}

}