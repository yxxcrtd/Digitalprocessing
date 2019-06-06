package cn.digitalpublishing.service.impl;

import cn.digitalpublishing.facade.DaoFacade;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.po.Resource;

import cn.digitalpublishing.service.BaseService;

public class BaseServiceImpl implements BaseService {
	protected DaoFacade daoFacade;

	public DaoFacade getDaoFacade() {
		return daoFacade;
	}

	public void setDaoFacade(DaoFacade daoFacade) {
		this.daoFacade = daoFacade;
	}
}
