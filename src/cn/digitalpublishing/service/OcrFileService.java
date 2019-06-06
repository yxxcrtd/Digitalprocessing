package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.OcrFiles;

/**
 * 
 */
public interface OcrFileService extends BaseService {

	
	List<OcrFiles> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws CcsException;

	Integer getCount(Map<String, Object> condition) throws CcsException;

	OcrFiles findbyid(String id)throws CcsException;

	public void update(OcrFiles ocrFile, String id, String[] properties) throws CcsException;

	void delete(String id)throws CcsException ;
	
	

}