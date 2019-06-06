package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.service.FtpConfigService;

public class FtpConfigServiceImpl extends BaseServiceImpl implements FtpConfigService {

	
	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws CcsException {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpConfigDao").get("getCount");
		try {
			num = this.daoFacade.getFtpConfigDao().getCount(map, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	/*
	 * 获取FtpConfig的集合
	 * @see cn.digitalpublishing.service.ResourceService#getResourcePagingList(java.util.Map, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<FtpConfig> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws CcsException {
		List<FtpConfig> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpConfigDao").get("getPagingList");
		try {
			list = this.daoFacade.getFtpConfigDao().getPagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取FtpConfig失败！", e);
		}
		return list;
	}
	
	/**
	 * 获取FtpConfig的集合，无分页
	 */
	
	public List<FtpConfig> getList(Map<String,Object> condition) throws CcsException {
		List<FtpConfig> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpConfigDao").get("getPagingList");
		try {
			list = this.daoFacade.getFtpConfigDao().getList(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取FtpConfig失败！", e);
		}
		return list;
	}
	
	public void insert(FtpConfig obj) throws CcsException {

		try {
			this.daoFacade.getFtpConfigDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "新增失败", e);
		}
	}

	
	public FtpConfig findbyid(String id) throws CcsException {

		FtpConfig ftpConfig = null;
		try {
			ftpConfig = (FtpConfig) this.daoFacade.getFtpConfigDao().get(FtpConfig.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找信息失败", e);
		}
		return ftpConfig;
	}
	
	public void update(FtpConfig obj, String id, String[] properties) throws CcsException {

		try {
			this.daoFacade.getFtpConfigDao().update(obj, FtpConfig.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "修改信息失败", e);
		}

	}

	/**
	 * 删除
	 */
	public void delete(String id) throws CcsException {
		try {
			/*
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("delflag", id);
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpFolderDao").get("getCount");
			//删除FtpConfig时，先查询FtpFolder的个数
			int count = this.daoFacade.getFtpFolderDao().getCount(map, hqlBean);
			*/
			FtpConfig ftpConfig = this.findbyid(id);
			int count = ftpConfig.getFtpFolders().size();
			if(count>0){
				throw new CcsException("删除失败，请先删除FTP配置下的文件夹，再次执行删除！");
			}else{
				this.daoFacade.getFtpConfigDao().delete(FtpConfig.class.getName(), id);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败", e);
		}
	}
	
}