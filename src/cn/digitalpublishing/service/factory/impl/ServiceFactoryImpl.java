package cn.digitalpublishing.service.factory.impl;

import cn.com.daxtech.framework.web.service.SpringBeanService;
import cn.digitalpublishing.service.FtpFolderService;
import cn.digitalpublishing.service.TemplateNodeService;
import cn.digitalpublishing.service.ThreadService;
import cn.digitalpublishing.service.XmlNodeService;
import cn.digitalpublishing.service.factory.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {
	@Override
	public FtpFolderService getFtpFolderService() {
		// TODO Auto-generated method stub
		return (FtpFolderService)SpringBeanService.getService("ftpFolderService");
	}

	@Override
	public TemplateNodeService getTemplateNodeService() {
		// TODO Auto-generated method stub
		return (TemplateNodeService)SpringBeanService.getService("templateNodeService");
	}
	
	@Override
	public XmlNodeService getXmlNodeService() {
		// TODO Auto-generated method stub
		return (XmlNodeService)SpringBeanService.getService("xmlNodeService");
	}
	
	@Override
	public ThreadService getThreadService() {
		// TODO Auto-generated method stub
		return (ThreadService)SpringBeanService.getService("threadService");
	}
}