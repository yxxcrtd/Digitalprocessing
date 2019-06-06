package cn.digitalpublishing.service.impl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.service.XmlNodeService;

public class XmlNodeServiceImpl extends BaseServiceImpl implements XmlNodeService {

	
	/* 
	 * 
	 */
	@Override
	public Integer getCount(Map<String, Object> map) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.XmlNodeDao").get("getCount");
		try {
			num = this.daoFacade.getXmlNodeDao().getCount(map, hqlBean);
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
	public List<XmlNode> getPagingList(Map<String,Object> condition, String sort, Integer pageCount, Integer countStart) throws Exception {
		List<XmlNode> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.XmlNodeDao").get("getPagingList");
		try {
			list = this.daoFacade.getXmlNodeDao().getXmlNodePagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "失败！", e);
		}
		return list;
	}
	
	@Override
	public List<XmlNode> getList(Map<String,Object> condition) throws Exception {
		List<XmlNode> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.XmlNodeDao").get("getList");
		try {
			list = this.daoFacade.getXmlNodeDao().getList(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "失败！", e);
		}
		return list;
	}
	
	@Override
	public void update(XmlNode xmlNode, String className, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getResourceDao().update(xmlNode, className, id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败！", e);
		}
	}
	
	@Override
	public void delete(String id) throws Exception {
		try {
			this.daoFacade.getResourceDao().delete(XmlNode.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "删除信息失败！", e);
		}
	}

	@Override
	public XmlNode findById(String id) throws Exception {
		// TODO Auto-generated method stub
		XmlNode xmlNode = null;
		try {
			xmlNode = (XmlNode) daoFacade.getXmlNodeDao().get(XmlNode.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "查找失败", e);
		}
		return xmlNode;
	}
	
	
	@Override
	public String addXmlNodeObj(XmlNode obj) throws Exception {
		// TODO Auto-generated method stub
		String xmlNodeId=null;
		try{
			 this.daoFacade.getXmlNodeDao().insert(obj);
			 xmlNodeId = obj.getId();
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"模板添加失败", e);//新增用户模板失败
		}
		return xmlNodeId;
		
	}
	
	@Override
	public void deleteNode(String id) throws Exception {
		try{
			this.daoFacade.getXmlNodeDao().delete(XmlNode.class.getName(), id);
			System.out.println(XmlNode.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt(): "删除失败", e);//删除分类信息失败！
		}
	}
	
//	-----------------------------------测试用的------------------------------------------------------
	@Override
	public void analysisTemplateAddNode(Resource obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			//读取xml
			System.out.println(obj.getFilePath()+obj.getResourceName());
			Document document = load(obj.getFilePath()+obj.getResourceName());
			//解析xml 返回节点信息
			getElementList(document.getRootElement(),obj,null,"1001");
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"usertemlateNode.info.add.error", e);//新增用户模板失败
		}
	}
	
	/**
	 * 一次全部加载xml文件
	 * @param url
	 * @return
	 */
	public  Document load(String url) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			document = saxReader.read(url); //读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}
	
	
	/**
	 * 递归得到每个node节点path
	 * @param element
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public  void getElementList(Element element,Resource obj,XmlNode parent,String nodeCode) throws Exception { 
        List elements = element.elements(); 
        String nodeName;
        XmlNode xmlnode = null;
		if (elements.size() == 0) { 
            //没有子元素 
            String xpath = element.getPath(); 	
            
            System.out.println(xpath);
            nodeName = element.getName();
            //是否是根节点
            Boolean isRoot = element.isRootElement();
            xmlnode = getObject(xpath,nodeName,obj,parent,nodeCode);
            //保存记录
            this.daoFacade.getXmlNodeDao().insert(xmlnode);
        } else { 
        	//存储当前节点
        	  String xpath = element.getPath(); 
        	  System.out.println(xpath);
        	  nodeName = element.getName();
//            String value = element.getTextTrim(); 
        	  Boolean isRoot = element.isRootElement();
        	  if(!isRoot){
        		  xmlnode = getObject(xpath,nodeName,obj,parent,nodeCode); 
        		  //insert
        		  this.daoFacade.getXmlNodeDao().insert(xmlnode);
        		  parent = xmlnode;
        	  }else{
        		  xmlnode = getObject(xpath,nodeName,obj,parent,nodeCode);; 
        		  this.daoFacade.getXmlNodeDao().insert(xmlnode);
        		  parent = xmlnode;
        	  }
            //有子元素 
        	nodeCode="1000";
            for (Iterator it = elements.iterator(); it.hasNext();) { 
                Element elem = (Element) it.next(); 
              //递归遍历 
                Integer tempCode = Integer.valueOf(nodeCode);
                tempCode++;
                nodeCode=tempCode.toString();
                getElementList(elem,obj,parent,nodeCode); 
            } 
        } 
    } 
	
	/**
	 * 返回封装UsertemplateNode对象
	 */
	public XmlNode getObject(String nodePath,String nodeName,Resource resource,XmlNode parent,String nodeCode){
		XmlNode xmlnode = new XmlNode();
		//节点路径
		xmlnode.setNodePath(nodePath);
		//usertemplate关系
		xmlnode.setResource(resource);
		
		xmlnode.setNodeName(nodeName);
		if(parent!=null){
			xmlnode.setNodeCode(parent.getNodeCode()+nodeCode);
		}else{
			xmlnode.setNodeCode(nodeCode);
		}
		//设置父类关系
		xmlnode.setParent(parent);
		return xmlnode;
	}
//	--------------------模拟测试数据用的----------------------------------------
}