package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;


public interface ThreadService extends BaseService {

	public List<Resource> getSouceDateList(Map<String, Object> condition, String sort)
			throws Exception;
	
	
	public List<XmlNode> getXmlNode(Map<String, Object> conditionftpCode)
			throws Exception;


	public void splitMetadata(Resource resource) throws CcsException;


	public List<Resource> getResourceList(Map<String, Object> map,String sort) throws CcsException;


	public void downLoadFile(Resource resource)throws CcsException;


//	public List<Task> getTaskPagingList(Map<String, Object> condition,String sort, Integer pageCount, Integer page) 
//			throws CcsException;
//
//
//	public void sendFile(Task task)throws CcsException;
//	
//	
//	public void update(Task task, String id, String[] properties)throws CcsException;
	
	public void updateResource(Resource resource, String id, String[] properties)throws CcsException;
}
