package cn.digitalpublishing.service.impl;

import java.io.File;
import java.util.Date;
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
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.service.ThreadService;
import cn.digitalpublishing.util.FtpUploadTool;

public class ThreadServiceImpl extends BaseServiceImpl implements ThreadService {
	/**
	 * 得到TSource数据
	 */
	@Override
	public List<Resource> getSouceDateList(Map<String, Object> condition,
			String sort) throws Exception {
		// TODO Auto-generated method stub
		List<Resource> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
					.get("cn.digitalpublishing.dao.ResourceDao").get("getList");
			list = this.daoFacade.getResourceDao().getResourceList(condition,
					sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "ftp.info.page.list.error", e);// 获取FTP配置信息分页列表失败�?
		}
		return list;
	}

	@Override
	public List<XmlNode> getXmlNode(Map<String, Object> conditionftpCode)
			throws Exception {
		// TODO Auto-generated method stub
		List<XmlNode> list = null;
		try {

			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
					.get("cn.digitalpublishing.dao.XmlNodeDao").get("getList");
			list = this.daoFacade.getXmlNodeDao().getList(conditionftpCode,
					hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "ftp.info.page.list.error", e);// 获取FTP配置信息分页列表失败�?
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void splitMetadata(Resource resource) throws CcsException {
		// TODO Auto-generated method stub
		try {
			// if (1 == resource.getStatus()) {
			// 读取xml
			Document document = load(resource.getFilePath()
					+ resource.getResourceName());
			// 解析xml 返回节点信息
			getElementList(document.getRootElement(), resource, null, "1001");
			resource.setCreatDate(new Date());
			resource.setStatus(2);
			this.daoFacade.getResourceDao().update(resource,
					Resource.class.getName(), resource.getId(), null);
			// }
			// else {
			// resource.setCreatDate(new Date());
			// return;
			// }

		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "splitMetadata.info.page.list.error", e);// 获取FTP配置信息分页列表失败�?
			// 修改更新时间
		}
	}

	public Document load(String url) throws Exception {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			saxReader
					.setFeature(
							"http://apache.org/xml/features/nonvalidating/load-external-dtd",
							false);
			document = saxReader.read(new File(url)); // 读取XML文件,获得document对象
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "load.xml.error", e);// 加载xml异常
		}
		return document;
	}


	/**
	 * 递归得到每个node节点path
	 * 
	 * @param element
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void getElementList(Element element, Resource resource,
			XmlNode parent, String nodeCode) throws Exception {
		List elements = element.elements();
		String nodeName;
		XmlNode xmlNode = null;
		if (elements.size() == 0) {
			// 没有子元素
			String xpath = element.getPath();
			String xvalue = element.getTextTrim();

			System.out.println(xpath);
			nodeName = element.getName();
			// 是否是根节点
			Boolean isRoot = element.isRootElement();
			xmlNode = getXmlNode(xpath, nodeName, resource, parent, nodeCode,
					xvalue);
			// 保存记录
			this.daoFacade.getTemplateNodeDao().insert(xmlNode);
		} else {
			// 存储当前节点
			String xpath = element.getPath();
			System.out.println(xpath);
			nodeName = element.getName();
			String xvalue = element.getTextTrim();
			// String value = element.getTextTrim();
			Boolean isRoot = element.isRootElement();
			if (!isRoot) {
				xmlNode = getXmlNode(xpath, nodeName, resource, parent,
						nodeCode, xvalue);
				// insert
				this.daoFacade.getXmlNodeDao().insert(xmlNode);
				parent = xmlNode;
			} else {
				xmlNode = getXmlNode(xpath, nodeName, resource, parent,
						nodeCode, xvalue);
				;
				this.daoFacade.getXmlNodeDao().insert(xmlNode);
				parent = xmlNode;
			}
			// 有子元素
			nodeCode = "1000";
			for (Iterator it = elements.iterator(); it.hasNext();) {
				Element elem = (Element) it.next();
				// 递归遍历
				Integer tempCode = Integer.valueOf(nodeCode);
				tempCode++;
				nodeCode = tempCode.toString();
				getElementList(elem, resource, parent, nodeCode);
			}
		}
	}

	/**
	 * 返回封装XmlNode对象
	 */
	public XmlNode getXmlNode(String nodePath, String nodeName,
			Resource resource, XmlNode parent, String nodeCode, String xvalue) {
		XmlNode xmlNode = new XmlNode();
		// 节点路径
		xmlNode.setNodePath(nodePath);
		xmlNode.setNodeName(nodeName);
		// usertemplate关系
		xmlNode.setResource(resource);
		xmlNode.setNodeValue(xvalue);
		xmlNode.setUpdateTime(new Date());
		if (parent != null) {
			xmlNode.setNodeCode(parent.getNodeCode() + nodeCode);
		} else {
			xmlNode.setNodeCode(nodeCode);
		}
		// 设置父类关系
		xmlNode.setParent(parent);
		return xmlNode;
	}

	@Override
	public List<Resource> getResourceList(Map<String, Object> map, String sort)
			throws CcsException {
		// TODO Auto-generated method stub
		List<Resource> list = null;						
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
					.get("cn.digitalpublishing.dao.ResourceDao")
					.get("getResourceList");
			list = this.daoFacade.getResourceDao().getResourceList(map, sort,
					hqlBean);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "usertemlate.info.add.error", e);// 新增用户模板失败
		}
		return list;
	}

	@Override
	public void downLoadFile(Resource resource) throws CcsException {
		// TODO Auto-generated method stub
		try {
			String filename = resource.getResourceName().split("[.]")[0];
			String ip = resource.getIp();
			Integer port = resource.getPort();
			String username = resource.getUsername();
			String password = resource.getPassword();
			// 文件保存路径
			String filePath = new StringBuffer().append(resource.getFilePath()).toString();
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xmlId", resource.getId());
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
					.get("cn.digitalpublishing.dao.XmlNodeDao")
					.get("getList");
			this.daoFacade.getXmlNodeDao();
			List<XmlNode> xmlNodeList = this.daoFacade.getXmlNodeDao().getList(
					condition, hqlBean);
			for (XmlNode xmlNode : xmlNodeList) {
				if (xmlNode.getNodePath().equals("/*[name()='book']/*[name()='bookinfo']/*[name()='bookname']") && xmlNode.getNodeValue() != null) {
					Map<String, String> fileNames = new HashMap<String, String>();
					fileNames.put(xmlNode.getNodeValue(), xmlNode.getNodeValue());
					// 执行下载
					FtpUploadTool tool = new FtpUploadTool(ip, port, username,
							password);
					int tempcount = tool.downloadFileAndReturnCount(
							resource.getFtpFileDir(), filePath, fileNames);
					if(tempcount == 1){
						resource.setBookName(xmlNode.getNodeValue());
						// 更新状态
						resource.setStatus(3);
					}
				}
				if (xmlNode.getNodePath().equals("/*[name()='book']/*[name()='bookinfo']/*[name()='bookcover']") && xmlNode.getNodeValue() != null) {
					Map<String, String> fileNames = new HashMap<String, String>();
					fileNames.put(xmlNode.getNodeValue(), xmlNode.getNodeValue());
					// 执行下载
					FtpUploadTool tool = new FtpUploadTool(ip, port, username,
							password);
					int tempcount = tool.downloadFileAndReturnCount(
							resource.getFtpFileDir(), filePath, fileNames);
					resource.setBookCover(xmlNode.getNodeValue());
				}
				if (xmlNode.getNodePath().equals("/*[name()='book']/*[name()='bookinfo']/*[name()='bookimage']") && xmlNode.getNodeValue() != null) {
					Map<String, String> fileNames = new HashMap<String, String>();
					fileNames.put(xmlNode.getNodeValue(), xmlNode.getNodeValue());
					// 执行下载
					FtpUploadTool tool = new FtpUploadTool(ip, port, username,
							password);
					int tempcount = tool.downloadFileAndReturnCount(
							resource.getFtpFileDir(), filePath, fileNames);
					resource.setBookImage(resource.getBookImage() + xmlNode.getNodeValue() + ",");
				}
			}
			resource.setCreatDate(new Date());
			// 跟新tsource
			this.daoFacade.getResourceDao().update(resource,
					Resource.class.getName(), resource.getId(), null);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "usertemlate.info.add.error", e);// 新增用户模板失败
		}
	}

	// @Override
	// public List<Task> getTaskPagingList(Map<String, Object> condition,String
	// sort, Integer pageCount, Integer page) throws CcsException {
	// // TODO Auto-generated method stub
	// List<Task> list = null;
	// try{
	// list = this.daoFacade.getPushTaskDao().getPagingList(condition, sort,
	// pageCount, page);
	// }catch(Exception e){
	// throw new CcsException((e instanceof CcsException) ?
	// ((CcsException)e).getPrompt():"usertemlate.info.add.error", e);//新增用户模板失败
	// }
	// return list;
	// }
	//
	// @Override
	// public void sendFile(Task task) throws CcsException {
	// // TODO Auto-generated method stub
	// try {
	// FtpUploadTool tool = new
	// FtpUploadTool(task.getIp(),task.getPort(),task.getUsername(),task.getPassword());
	// File file = new File(task.getPushFilePath());
	// tool.uploadFile(file, task.getFtpdir(), "UFT-8", task.getFileName());
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// throw new CcsException((e instanceof CcsException) ?
	// ((CcsException)e).getPrompt():"pushtask.info.update.error", e);
	//
	// }
	// }
	//
	// @Override
	// public void update(Task task, String id, String[] properties)
	// throws CcsException {
	// // TODO Auto-generated method stub
	// try{
	// this.daoFacade.getFtpDirConfigureDao().update(task,
	// Task.class.getName(),id, properties);
	// }catch(Exception e){
	// throw new CcsException((e instanceof CcsException) ?
	// ((CcsException)e).getPrompt():"pushtask.info.update.error", e);
	// }
	// }

	@Override
	public void updateResource(Resource tSource, String id, String[] properties)
			throws CcsException {
		// TODO Auto-generated method stub
		try {
			this.daoFacade.getFtpFolderDao().update(tSource,
					Resource.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "tSource.info.update.error", e);
		}
	}

}
