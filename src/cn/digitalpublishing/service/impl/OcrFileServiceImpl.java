package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.OcrFiles;
import cn.digitalpublishing.service.OcrFileService;

public class OcrFileServiceImpl extends BaseServiceImpl implements OcrFileService {

	

	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws CcsException {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.OcrFilesDao").get("getCount");
		try {
			num = this.daoFacade.getOcrFilesDao().getCount(map, hqlBean);
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
	public List<OcrFiles> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws CcsException {
		List<OcrFiles> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.OcrFilesDao").get("getPagingList");
		try {
			list = this.daoFacade.getOcrFilesDao().getPagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取FtpConfig失败！", e);
		}
		return list;
	}
	

	
	public OcrFiles findbyid(String id) throws CcsException {

		OcrFiles ocrFiles = null;
		try {
			ocrFiles = (OcrFiles) this.daoFacade.getOcrFilesDao().get(OcrFiles.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找信息失败", e);
		}
		return ocrFiles;
	}
	
	public void update(OcrFiles obj, String id, String[] properties) throws CcsException {

		try {
			this.daoFacade.getOcrFilesDao().update(obj, OcrFiles.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "修改信息失败", e);
		}

	}

	/**
	 * 删除
	 */
	public void delete(String id) throws CcsException {
		try {
			this.daoFacade.getOcrFilesDao().delete(OcrFiles.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败", e);
		}
	}
	
	
}