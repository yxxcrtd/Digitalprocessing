package cn.digitalpublishing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.po.FtpFolder;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.service.FtpFolderService;
import cn.digitalpublishing.util.FtpUploadTool;

public class FtpFolderServiceImpl extends BaseServiceImpl implements FtpFolderService {

	
	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpFolderDao").get("getCount");
		try {
			num = this.daoFacade.getFtpFolderDao().getCount(map, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	/*
	 * 
	 * @see cn.digitalpublishing.service.ResourceService#getResourcePagingList(java.util.Map, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<FtpFolder> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws Exception {
		List<FtpFolder> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.FtpFolderDao").get("getPagingList");
		try {
			list = this.daoFacade.getFtpFolderDao().getPagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "失败！", e);
		}
		return list;
	}
	
	public void insert(FtpFolder obj) throws Exception {

		try {
			this.daoFacade.getFtpFolderDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "新增用户失败", e);
		}
	}

	/**
	 * 根据id获取到FtpFolder对象
	 */
	public FtpFolder findById(String id) throws CcsException {

		FtpFolder ftpFolder = null;
		try {
			ftpFolder = (FtpFolder) this.daoFacade.getFtpFolderDao().get(FtpFolder.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找信息失败", e);
		}
		return ftpFolder;
	}
	
	public void update(FtpFolder obj, String id, String[] properties) throws Exception {

		try {
			this.daoFacade.getFtpFolderDao().update(obj, FtpFolder.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "修改信息失败", e);
		}

	}

	/**
	 * 删除
	 */
	public void delete(String id) throws Exception {

		try {
			this.daoFacade.getFtpFolderDao().delete(FtpFolder.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败", e);
		}
	}
	
	@Override
	public List<FtpFolder> getList(Map<String, Object> condition,
			String sort) throws Exception {
		List<FtpFolder> list;
		try{
			list = this.daoFacade.getFtpFolderDao().getList(condition, sort);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "ftp.info.delete.error", e);
		}
		return list;
	}
	
	
	@Override
	public List<String> getFileNames(FtpConfig obj,
			String removePath)throws Exception {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		try{
			if(obj!=null){
				FtpUploadTool tool = new FtpUploadTool(obj.getIp(),obj.getPort(),obj.getUsername(),obj.getPassword());
				List<String> fileNames = tool.getFileNames(removePath);
				//过滤出要下载的文件
				for (String s : fileNames) {
					if(s.toLowerCase().endsWith(".xml")){
						list.add(s);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "ftp.info.get.remote.fileName.error", e);//获取远程文件列表失败！
		}
		return list;
	}

	@Override
	public Map<String, String> notExistFileNames(List<String> fileNames,
			String fptcode, String ftpdir) throws Exception {
		Map<String,String> fileMap = null;
		try{
			if(fileNames!=null&&!fileNames.isEmpty()){
				fileMap = new HashMap<String,String>();
				Map<String,Object> condition = new HashMap<String,Object>();
				//取得Resource中的数据 条件是fptcode 和 ftpdir
				condition.put("ftpcode", fptcode);
				condition.put("ftpFileDir", ftpdir);
				HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ResourceDao").get("getPagingList");
				List<Resource> list = this.getSourceList(condition,"",hqlBean);
				boolean isadd = false;
				for(String fileName:fileNames){
					for (Resource resource : list){
						if(resource.getResourceName().equals(fileName)){
							isadd=true;
							break;
						}
					}
					if(!isadd){ 	
						fileMap.put(fileName, fileName);
					}
					isadd = false;
				}
			}
		}catch (Exception e) {
			throw e;
		}
		System.out.println("fileNames"+fileNames);
		System.out.println(fileMap);
		return fileMap;
	}

	/**
	 * 下载excel文件 并返回 下载文件名字list集合
	 */
	@Override
	public List<Resource> downloadRemoteFile(FtpConfig ftpConfig,
			String localPath, String targetPath,
			Map<String, String> notExistFileNames) throws Exception {
		List<Resource> resourceList = null;
		try{
			if(ftpConfig!=null){
				FtpUploadTool tool = new FtpUploadTool(ftpConfig.getIp(),ftpConfig.getPort(),ftpConfig.getUsername(),ftpConfig.getPassword());
				resourceList = tool.downloadFile2(targetPath,localPath,notExistFileNames,ftpConfig);
			}
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "ftp.info.download.error", e);//FTP下载失败！
		}
		return resourceList;
	}
	//保存t_source
	@Override
	public void saveResources(List<Resource> list) throws Exception {
		try{
			for (Resource resource : list) {
				this.daoFacade.getResourceDao().insert(resource);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "third.part.integrated.source.scan.error", e);
		}
	}
	
	public List<Resource> getSourceList(Map<String, Object> condition, String sort, HqlBean hqlBean) throws Exception {
		List<Resource> list=null;
		try {
			list=this.daoFacade.getResourceDao().getResourceList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "third.part.integrated.source.list.error", e);
		}
		return list;
	}

	@Override
	public List<FtpFolder> getFtpDirByFtpid(Map<String, Object> condition)
			throws Exception {
		// TODO Auto-generated method stub
		List<FtpFolder> list = null;
		try{
			list = this.daoFacade.getFtpFolderDao().getFtpDirByFtpid(condition);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"ftp.info.page.list.error", e);//获取FTP配置信息分页列表失败！
		}
		return list;
	}

	
}