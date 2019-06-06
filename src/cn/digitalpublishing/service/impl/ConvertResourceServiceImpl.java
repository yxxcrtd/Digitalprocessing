package cn.digitalpublishing.service.impl;


import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.ConvertResource;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.service.ConvertResourceService;

public class ConvertResourceServiceImpl extends BaseServiceImpl implements ConvertResourceService {

	
	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ConvertResourceDao").get("getCount");
		try {
			num = this.daoFacade.getConvertResourceDao().getCount(map, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "获取数量失败", e);
		}
		return num;
	}

	@Override
	public List<ConvertResource> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws Exception {
		List<ConvertResource> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ConvertResourceDao").get("getPagingList");
		try {
			list = this.daoFacade.getConvertResourceDao().getPagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取分页列表失败！", e);
		}
		return list;
	}
	
	
	@Override
	public List<ConvertResource> getList(Map<String,Object> condition, String sort) throws Exception {
		List<ConvertResource> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ConvertResourceDao").get("getList");
		try {
			list = this.daoFacade.getConvertResourceDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取列表失败！", e);
		}
		return list;
	}
	
	
	@Override
	public void delete(String id) throws Exception {
		try {
			this.daoFacade.getResourceDao().delete(ConvertResource.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败！", e);
		}
	}

	@Override
	public void insert(ConvertResource obj) throws CcsException {

		try {
			this.daoFacade.getConvertResourceDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "新增失败", e);
		}
	}
	
	@Override
	public ConvertResource findById(String id) throws Exception {
		// TODO Auto-generated method stub
		ConvertResource convertResource = null;
		try {
			convertResource = (ConvertResource) daoFacade.getConvertResourceDao().get(ConvertResource.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找失败", e);
		}
		return convertResource;
	}

}