package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.po.FtpFolder;
import cn.digitalpublishing.po.Resource;

/**
 * 
 */
public interface FtpFolderService extends BaseService {

	void insert(FtpFolder obj) throws Exception;
	
	List<FtpFolder> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer countStart)
			throws Exception;

	Integer getCount(Map<String, Object> condition) throws Exception;

	FtpFolder findById(String id)throws CcsException;

	public void update(FtpFolder obj, String id, String[] properties) throws Exception;

	void delete(String id)throws Exception ;

	public List<FtpFolder> getList(Map<String,Object> condition,
			String string) throws Exception;

	/**
	 * 
	 * @param obj ftp 对象
	 * @param removePath ftp文件夹目录
	 * @return 返回ftp服务器上指定文件集合，如.xml 和 excel文件
	 * @throws Exception
	 */
	public List<String> getFileNames(FtpConfig obj, String removePath)
			throws Exception;
	/**
	 *通过ftp服务器返回的文件名集合 和Tsource表中的对应ftp文件对比 
	 * @param fileNames ftp上文件集合
	 * @param fptcode	ftp唯一标记
	 * @param ftpdir	ftp 文件夹目录
	 * @return 返回需要下载的文件名称集合
	 * @throws Exception
	 */
	public Map<String, String> notExistFileNames(List<String> fileNames,
			String fptcode, String ftpdir) throws Exception;
	/**
	 * 在第三方下载数据
	 * @param ftpConfigure
	 * @param sourceCode
	 * @param webRoot
	 * @param targetPath
	 * @param notExistFileNames
	 * @throws Exception
	 */
	
	public List<Resource> downloadRemoteFile(FtpConfig ftpConfig, String webRoot,
			String targetPath, Map<String, String> notExistFileNames)
			throws Exception;
	
	public void saveResources(List<Resource> list) throws Exception;
	public List<FtpFolder> getFtpDirByFtpid(Map<String, Object> condition) throws Exception;
	
}