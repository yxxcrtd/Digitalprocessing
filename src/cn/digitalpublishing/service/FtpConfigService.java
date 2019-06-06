package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.FtpConfig;

/**
 * 
 */
public interface FtpConfigService extends BaseService {

	void insert(FtpConfig obj) throws CcsException;
	
	List<FtpConfig> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws CcsException;

	Integer getCount(Map<String, Object> condition) throws CcsException;

	FtpConfig findbyid(String id)throws CcsException;

	public void update(FtpConfig ftpConfig, String id, String[] properties) throws CcsException;

	void delete(String id)throws CcsException ;
	
	public List<FtpConfig> getList(Map<String,Object> condition) throws CcsException;
	

}