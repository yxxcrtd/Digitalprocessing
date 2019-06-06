package cn.digitalpublishing.service;


import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.Resource;

/**
 * 
 */
public interface ResourceService extends BaseService {
	
	List<Resource> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws Exception;

	Integer getCount(Map<String, Object> condition) throws Exception;
	
	public void update(Resource resource, String id, String[] properties) throws CcsException;

	public void delete(String id) throws Exception;
	
	public void addObj(Resource resource) throws CcsException;


	Resource findById(String id) throws Exception;

	List<Resource> getList(Map<String, Object> condition, String sort)
			throws Exception;
}