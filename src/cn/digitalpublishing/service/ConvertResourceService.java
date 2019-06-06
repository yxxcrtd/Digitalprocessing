package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.ConvertResource;
import cn.digitalpublishing.po.Resource;



/**
 * 
 */
public interface ConvertResourceService extends BaseService {

	Integer getCount(Map<String, Object> map) throws Exception;

	List<ConvertResource> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws Exception;

	void delete(String id) throws Exception;

	ConvertResource findById(String id) throws Exception;

	void insert(ConvertResource obj) throws CcsException;

	List<ConvertResource> getList(Map<String, Object> condition, String sort) throws Exception;
	
}