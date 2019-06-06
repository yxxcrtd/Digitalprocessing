package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.TemplateMapping;

public interface TemplateMappingService extends BaseService {
	
	/**
	 * 修改用户模板配置
	 * @param obj
	 * @param id
	 * @param properties
	 * @throws Exception
	 */
	public void update(TemplateMapping obj,String id,String[] properties)throws Exception;
	
	/**
	 * 新增用户模板
	 * @param obj
	 * @throws Exception
	 */
	public void add(TemplateMapping obj)throws Exception;
	
	/**
	 * 删除用户模板配置
	 * @param id
	 * @param path
	 * @throws Exception
	 */
	public void delete(String id)throws Exception;
	
	public List<TemplateMapping> getList(Map<String, Object> condition,
			String string) throws Exception;
	
}
