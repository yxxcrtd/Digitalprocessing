package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.TemplateMapping;
import cn.digitalpublishing.service.TemplateMappingService;

public class TemplateMappingServiceImpl extends BaseServiceImpl implements TemplateMappingService {

	
	@Override
	public void add(TemplateMapping obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().insert(obj);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"模板添加失败", e);//新增用户模板失败
		}
		
	}
	@Override
	public void update(TemplateMapping obj, String id, String[] properties)throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().update(obj, TemplateMapping.class.getName(), id, properties);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"ftp.info.update.error", e);//更新FTP配置信息失败�?
		}
	}

	
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().delete(TemplateMapping.class.getName(), id);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "删除异常", e);//删除用户模板异常
		}
	}

	@Override
	public List<TemplateMapping> getList(Map<String, Object> condition,String sort) throws Exception {
		List<TemplateMapping> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateMappingDao").get("getList");
		try {
			list = this.daoFacade.getTemplateMappingDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取映射失败！", e);
		}
		return list;
	}
}
