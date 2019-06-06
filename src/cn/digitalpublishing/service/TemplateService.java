package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.Template;

public interface TemplateService extends BaseService {
	
	/**
	 * 获取FTP配置
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Template> getTemplatePagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	/**
	 * 获取总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public Integer getDataCount(Map<String,Object> condition)throws Exception;
	
	/**
	 * 修改用户模板配置
	 * @param obj
	 * @param id
	 * @param properties
	 * @throws Exception
	 */
	public void updateTemplate(Template obj,String id,String[] properties)throws Exception;
	
	/**
	 * 新增用户模板
	 * @param obj
	 * @throws Exception
	 */
	public void addTemplate(Template obj)throws Exception;
	
	/**
	 * 删除用户模板配置
	 * @param id
	 * @param path
	 * @throws Exception
	 */
	public void deleteTemplate(String id)throws Exception;
	
	/**
	 * 根据ID查找对象
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Template findById(String id) throws Exception;
	
	
	public List<Template> getList(Map<String, Object> templateCondition,
			String string) throws Exception;
	
}
