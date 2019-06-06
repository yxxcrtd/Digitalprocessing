package cn.digitalpublishing.service.factory;

import cn.digitalpublishing.service.FtpFolderService;
import cn.digitalpublishing.service.TemplateNodeService;
import cn.digitalpublishing.service.ThreadService;
import cn.digitalpublishing.service.XmlNodeService;



public interface ServiceFactory {
	/**
	 * 获取ftpdirService对象
	 */
	public FtpFolderService getFtpFolderService();

	public TemplateNodeService getTemplateNodeService();
	
	public XmlNodeService getXmlNodeService();
	/**
	 * 获取线程处理通用ThreadService对象
	 */
	public ThreadService getThreadService();
}