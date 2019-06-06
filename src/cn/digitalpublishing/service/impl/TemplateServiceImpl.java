package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.service.TemplateService;

public class TemplateServiceImpl extends BaseServiceImpl implements TemplateService {

	
	public Integer getDataCount(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateDao").get("getCount");
		try {
			num = this.daoFacade.getTemplateDao().getCount(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}
	@Override
	public void addTemplate(Template obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().insert(obj);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"模板添加失败", e);//新增用户模板失败
		}
		
	}
	@Override
	public void updateTemplate(Template obj, String id, String[] properties)throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().update(obj, Template.class.getName(), id, properties);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"ftp.info.update.error", e);//更新FTP配置信息失败�?
		}
	}

	public List<Template> getTemplatePagingList(Map<String, Object> condition,String sort, Integer pageCount, Integer page) throws Exception {
		List<Template> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateDao").get("getPagingList");
		try {
			list = this.daoFacade.getTemplateDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取模板列表失败！", e);
		}
		return list;
	}
	
	public void deleteTemplate(String id) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.daoFacade.getTemplateDao().delete(Template.class.getName(), id);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "msg.info.delete.error", e);//删除用户模板异常
		}
	}

	@Override
	public Template findById(String id) throws Exception {
		// TODO Auto-generated method stub
		Template template = null;
		try {
			template = (Template) daoFacade.getTemplateDao().get(Template.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "RTemplate.Info.FindById.Error", e);
		}
		return template;
	}
	@Override
	public List<Template> getList(Map<String, Object> condition,String sort) throws Exception {
		List<Template> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateDao").get("getList");
		try {
			list = this.daoFacade.getTemplateDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取模板列表失败！", e);
		}
		return list;
	}
}
