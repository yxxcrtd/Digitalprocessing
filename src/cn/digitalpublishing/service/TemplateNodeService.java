package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.po.TemplateNode;

public interface TemplateNodeService extends BaseService {

	List<TemplateNode> getPagingList(
			Map<String, Object> condition, String sort, Integer pageCount,
			Integer page) throws Exception;

	void analysisTemplateAddNode(Template obj) throws Exception;

	Integer getCount(Map<String, Object> condition) throws Exception;

	TemplateNode findbyid(String id) throws Exception;

	List<TemplateNode> getList(Map<String, Object> condition, String sort)
			throws CcsException;

	
}
