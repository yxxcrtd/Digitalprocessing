package cn.digitalpublishing.facade;

import cn.digitalpublishing.dao.BSubRelationDao;
import cn.digitalpublishing.dao.BSubjectDao;
import cn.digitalpublishing.dao.ConvertResourceDao;
import cn.digitalpublishing.dao.FtpConfigDao;
import cn.digitalpublishing.dao.FtpFolderDao;
import cn.digitalpublishing.dao.OcrFilesDao;
import cn.digitalpublishing.dao.ResourceDao;
import cn.digitalpublishing.dao.SubjectDao;
import cn.digitalpublishing.dao.TemplateDao;
import cn.digitalpublishing.dao.TemplateMappingDao;
import cn.digitalpublishing.dao.TemplateNodeDao;
import cn.digitalpublishing.dao.XmlNodeDao;


/**
 */
public class DaoFacade {
	
	/**
	 * FTP配置
	 */
	FtpConfigDao ftpConfigDao;

	/**
	 * FTP文件夹
	 */
	FtpFolderDao ftpFolderDao;
	/**
	 * Ocr文件
	 */
	OcrFilesDao ocrFilesDao;

	
	

	/**
	 * 图书分类
	 */
//	SubjectDao subjectDao;

	/**
	 * 资源列表
	 */
	ResourceDao resourceDao;
	
	/**
	 * xml节点列表
	 */
	XmlNodeDao xmlNodeDao;
	
	/**
	 * 用户模板 
	 */
	private TemplateDao templateDao;
	
	/**
	 * 用户模板节点
	 */
	private TemplateNodeDao templateNodeDao;

	/**
	 * 模板映射
	 */
	private TemplateMappingDao templateMappingDao;
	

	/**
	 * 文件转换
	 */
	private ConvertResourceDao convertResourceDao;
	
	/**
	 * 分类法
	 */
	private SubjectDao subjectDao;
	
	/**
	 * 分类法
	 */
	private BSubjectDao bSubjectDao;
	
	/**
	 * 分类关系信息Dao
	 */
	private BSubRelationDao subRelationDao;
	
	public BSubRelationDao getSubRelationDao() {
		return subRelationDao;
	}

	public void setSubRelationDao(BSubRelationDao subRelationDao) {
		this.subRelationDao = subRelationDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public BSubjectDao getbSubjectDao() {
		return bSubjectDao;
	}

	public void setbSubjectDao(BSubjectDao bSubjectDao) {
		this.bSubjectDao = bSubjectDao;
	}

	public ConvertResourceDao getConvertResourceDao() {
		return convertResourceDao;
	}

	public void setConvertResourceDao(ConvertResourceDao convertResourceDao) {
		this.convertResourceDao = convertResourceDao;
	}

	public TemplateMappingDao getTemplateMappingDao() {
		return templateMappingDao;
	}

	public void setTemplateMappingDao(TemplateMappingDao templateMappingDao) {
		this.templateMappingDao = templateMappingDao;
	}

	public TemplateDao getTemplateDao() {
		return templateDao;
	}

	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	public TemplateNodeDao getTemplateNodeDao() {
		return templateNodeDao;
	}

	public void setTemplateNodeDao(TemplateNodeDao templateNodeDao) {
		this.templateNodeDao = templateNodeDao;
	}

	public XmlNodeDao getXmlNodeDao() {
		return xmlNodeDao;
	}

	public void setXmlNodeDao(XmlNodeDao xmlNodeDao) {
		this.xmlNodeDao = xmlNodeDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

//	public SubjectDao getSubjectDao() {
//		return subjectDao;
//	}
//
//	public void setSubjectDao(SubjectDao subjectDao) {
//		this.subjectDao = subjectDao;
//	}

	public FtpConfigDao getFtpConfigDao() {
		return ftpConfigDao;
	}

	public void setFtpConfigDao(FtpConfigDao ftpConfigDao) {
		this.ftpConfigDao = ftpConfigDao;
	}
	public FtpFolderDao getFtpFolderDao() {
		return ftpFolderDao;
	}

	public void setFtpFolderDao(FtpFolderDao ftpFolderDao) {
		this.ftpFolderDao = ftpFolderDao;
	}
	
	
	/**
	 * @return the ocrFilesDao
	 */
	public OcrFilesDao getOcrFilesDao() {
		return ocrFilesDao;
	}

	/**
	 * @param ocrFilesDao the ocrFilesDao to set
	 */
	public void setOcrFilesDao(OcrFilesDao ocrFilesDao) {
		this.ocrFilesDao = ocrFilesDao;
	}
	
	
	
}