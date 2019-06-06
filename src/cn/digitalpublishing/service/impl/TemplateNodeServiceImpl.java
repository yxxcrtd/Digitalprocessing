
package cn.digitalpublishing.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.po.TemplateNode;
import cn.digitalpublishing.service.TemplateNodeService;

public class TemplateNodeServiceImpl extends BaseServiceImpl implements TemplateNodeService {
	
	@Override
	public List<TemplateNode> getPagingList(Map<String, Object> condition,String sort, Integer pageCount, Integer page) throws Exception {
		// TODO Auto-generated method stub
		List<TemplateNode> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateNodeDao").get("getPagingList");
		try{
			list = this.daoFacade.getTemplateNodeDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt():"ftp.info.page.list.error", e);//获取FTP配置信息分页列表失败�?
		}
		return list;
	}
	
	@Override
	public void analysisTemplateAddNode(Template obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			//读取xml
			Document document = load(obj.getPath()+obj.getFileName());
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
	public  void getElementList(Element element,Template userTemplate,TemplateNode parent,String nodeCode) throws Exception { 
        List elements = element.elements(); 
        String nodeName;
        TemplateNode templateNode = null;
		if (elements.size() == 0) { 
            //没有子元素 
            String xpath = element.getPath(); 	
            
            System.out.println(xpath);
            nodeName = element.getName();
            //是否是根节点
            Boolean isRoot = element.isRootElement();
            templateNode = getTemplateNode(xpath,nodeName,userTemplate,parent,nodeCode);
            //保存记录
            this.daoFacade.getTemplateNodeDao().insert(templateNode);
        } else { 
        	//存储当前节点
        	  String xpath = element.getPath(); 
        	  System.out.println(xpath);
        	  nodeName = element.getName();
//            String value = element.getTextTrim(); 
        	  Boolean isRoot = element.isRootElement();
        	  if(!isRoot){
        		  templateNode = getTemplateNode(xpath,nodeName,userTemplate,parent,nodeCode); 
        		  //insert
        		  this.daoFacade.getTemplateDao().insert(templateNode);
        		  parent = templateNode;
        	  }else{
        		  templateNode = getTemplateNode(xpath,nodeName,userTemplate,parent,nodeCode);; 
        		  this.daoFacade.getTemplateDao().insert(templateNode);
        		  parent = templateNode;
        	  }
            //有子元素 
        	nodeCode="1000";
            for (Iterator it = elements.iterator(); it.hasNext();) { 
                Element elem = (Element) it.next(); 
              //递归遍历 
                Integer tempCode = Integer.valueOf(nodeCode);
                tempCode++;
                nodeCode=tempCode.toString();
                getElementList(elem,userTemplate,parent,nodeCode); 
            } 
        } 
    } 
	
	/**
	 * 返回封装UsertemplateNode对象
	 */
	public TemplateNode getTemplateNode(String nodePath,String nodeName,Template template,TemplateNode parent,String nodeCode){
		TemplateNode templateNode = new TemplateNode();
		//节点路径
		templateNode.setNodePath(nodePath);
		templateNode.setNodeName(nodeName);
		//usertemplate关系
		templateNode.setTemplate(template);
		if(parent!=null){
			templateNode.setNodeCode(parent.getNodeCode()+nodeCode);
		}else{
			templateNode.setNodeCode(nodeCode);
		}
		//设置父类关系
		templateNode.setParent(parent);
		return templateNode;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.UserTemplateNodeService#getTargetTemplateNodeCount(java.util.Map)
	 */
	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateNodeDao").get("getCount");
		Integer num = 0;
		try {
			num = this.daoFacade.getTemplateNodeDao().getCount(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "UserTemplateNode.Info.Count.Error", e);
		}
		return num;
	}


	@Override
	public TemplateNode findbyid(String id) throws Exception {
		TemplateNode templateNode = null;
		try {
			templateNode = (TemplateNode) this.daoFacade.getTemplateNodeDao().get(TemplateNode.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "UserTemplateNode.Info.List.Error", e);
		}
		return templateNode;
	}

	@Override
	public List<TemplateNode> getList(Map<String, Object> condition, String sort) throws CcsException {
		List<TemplateNode> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.TemplateNodeDao").get("getList");
		try {
			list = this.daoFacade.getTemplateNodeDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt(): "获取模板列表失败！", e);
		}
		return list;
	}
}
