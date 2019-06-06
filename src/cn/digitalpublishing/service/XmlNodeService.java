package cn.digitalpublishing.service;


import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;

/**
 * 
 */
public interface XmlNodeService extends BaseService {
	
	List<XmlNode> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws Exception;

	Integer getCount(Map<String, Object> condition) throws Exception;
	
	void update(XmlNode xmlNode, String className, String id, String[] properties) throws Exception;

	void delete(String id) throws Exception;

	void analysisTemplateAddNode(Resource obj) throws Exception;

	XmlNode findById(String id) throws Exception;

	String addXmlNodeObj(XmlNode obj) throws Exception;

	List<XmlNode> getList(Map<String, Object> condition) throws Exception;

	void deleteNode(String id) throws Exception;
}