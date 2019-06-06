package cn.digitalpublishing.springmvc.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.XmlNode;
import cn.digitalpublishing.springmvc.form.XmlNodeForm;

/**
 * 
 * 
 * @author jinyanjiang
 */
@Controller
@RequestMapping("/pages/xmlnode")
public class XmlNodeController extends BaseController {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("xmlnode/xmlnode.ftl");
	}

	/**
	 * 资源列表
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	public XmlNodeForm manager(XmlNodeForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		List<XmlNode> list = new ArrayList<XmlNode>();
		String nodeCode = request.getParameter("nodeCode");
		condition.put("nodeCode", nodeCode+"%");
		try {
			form.setiTotalRecords(this.xmlNodeService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (0 < form.getiTotalRecords()) {
				list = this.xmlNodeService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			e.printStackTrace();
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		form.setAaData(list);
		return form;
	}

	/**
	 * 删除
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/form/delete")
	public XmlNodeForm delete(XmlNodeForm form) throws Exception {

		try {
			this.xmlNodeService.delete(form.getId());
			form.setIsSuccess(SUCCESS);
			form.setMsg("删除成功！");

		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}

	
	/**
	 * 显示xml节点树
	 * @param form
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/subList")
	public void view(XmlNodeForm form)throws Exception {
		String str="";
		try{
			String parentId = request.getParameter("id");
			String resourceid = request.getParameter("subId");
			
			Map<String,Object> condition = new HashMap<String,Object>();
			if(parentId==null||"".equals(parentId)){
				condition.put("parentId", "0");
			}else{
				condition.put("parentId", parentId);
			}
			
			condition.put("resourceid", resourceid);
			
			List<XmlNode> xmlNodeList = this.xmlNodeService.getList(condition);
			
			if (xmlNodeList != null && xmlNodeList.size() != 0) {
				String nId="";//节点id
				String pId="";//父节点id
				String nodeName="";//节点名称
				int i = 0;
				int size=xmlNodeList.size();//菜单数量
				for (XmlNode xmlNode : xmlNodeList) {
					nodeName=xmlNode.getNodeName();
					nId=xmlNode.getId();
					pId=parentId;
 					if(i<size-1){//非最后一个
						str +="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,name:\""+nodeName+"\",drop:"+(pId==null?false:true)+",isParent:"+(xmlNode.getCount()>0?true:false)+"},";
						System.out.println(str);
					}else{//最后一个菜单
						str +="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,name:\""+nodeName+"\",drop:"+(pId==null?false:true)+",isParent:"+(xmlNode.getCount()>0?true:false)+"},";
							
					}
					i++;
				}
			}
			str= "["+str+"]";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		
		}catch(Exception e){
			e.printStackTrace();
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
	}
	
	/**
	 * 添加分类
	 * @param request
	 * @param response
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/addSubmit")
	 public void addSubmit(XmlNodeForm form) throws Exception
	  {
	    String result = "";//"添加失败!";
	    try {
			//通过父节点id查询对象
			XmlNode parent = this.xmlNodeService.findById(form.getpId());
			
			XmlNode xmlNode = new XmlNode();
			xmlNode.setParent(parent);
			xmlNode.setResource(parent.getResource());
			xmlNode.setNodeName(form.getName());
			xmlNode.setNodePath(parent.getNodePath()+"/"+form.getName());
//			String nodeCode = 
			//查询所有的nodecode 找到最大的 在此基础上加1
			
//			xmlNode.setNodeCode(nodeCode);
			String xmlNodeId = this.xmlNodeService.addXmlNodeObj(xmlNode);
			if(xmlNodeId!=null&&!xmlNodeId.trim().equals("")){
		    	result = "success:"+xmlNodeId;
		    }
	    } catch (Exception e) {
	    	result = "error:"+((e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):result);
	    }
	    response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  out.print(result);
		  out.flush();
		  out.close();
	  }

    /**
     * 修改分类
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
	  @ResponseBody
	  @RequestMapping("/form/editSubmit")
	  public XmlNodeForm editSubmit(XmlNodeForm form) throws Exception{
	    try {
	    	XmlNode xmlNode = this.xmlNodeService.findById(form.getId());
	    	String nodeValue = request.getParameter("nodeValue");
	    	xmlNode.setNodeValue(nodeValue);
	        this.xmlNodeService.update(xmlNode, XmlNode.class.getName(), xmlNode.getId(), null);
	        form.setIsSuccess(SUCCESS);
	        form.setMsg("修改成功");
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    	 form.setIsSuccess("err");
	    	 form.setMsg("err");
	    }
		return form;
	  }

    /**
     * 删除分类
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
	  @RequestMapping({"/form/deleteNode"})
	  @ResponseBody
	  public XmlNodeForm deleteNode(XmlNodeForm form) throws Exception
	  {
	    try{
	    	System.out.println(form.getId());
	    	
	    	this.xmlNodeService.deleteNode(form.getId());
	    	form.setMsg("success");
	    } catch (Exception e) {
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
	    }
	    return form;
	  }
	
	  /**
	     *获取子节点
	     * @param form
	     * @throws Exception
	     */
		@RequestMapping(value="/form/edit")
		public ModelAndView editinit(XmlNodeForm form)throws Exception {
			Map<String,Object> modle = new HashMap<String,Object>();
			try{
				XmlNode xmlNode = this.xmlNodeService.findById(request.getParameter("id").toString());
				form.setObj(xmlNode);
				modle.put("form", form); 	
			}catch(Exception e){
	            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
			}
			return new ModelAndView("resource/showEdit.ftl",modle);
		}
		
		/**
	     * @param form
	     * @throws Exception
	     */
		@RequestMapping(value="/form/xmlnodecolinit")
		public ModelAndView xmlnodecolinit(XmlNodeForm form)throws Exception {
			Map<String,Object> modle = new HashMap<String,Object>();
			try{
				XmlNode xmlNode = this.xmlNodeService.findById(request.getParameter("id").toString());
				form.setObj(xmlNode);
				modle.put("form", form); 	
			}catch(Exception e){
	            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
			}
			return new ModelAndView("resource/xmlnodeCol.ftl",modle);
		}
		
		/**
	     *
	     * @param form
	     * @throws Exception
	     */
		@ResponseBody
		@RequestMapping(value="/form/xmlnodecolsubmit")
		public XmlNodeForm xmlnodecolsubmit(XmlNodeForm form)throws Exception {
			Map<String,Object> modle = new HashMap<String,Object>();
			try{
				String id = form.getId();
				String nodeKey = request.getParameter("nodeKey");
				XmlNode xmlNode = this.xmlNodeService.findById(id);
				xmlNode.setNodeKey(nodeKey);
				this.xmlNodeService.update(xmlNode, XmlNode.class.getName(), xmlNode.getId(), null);
				modle.put("form", form); 	
				form.setIsSuccess(SUCCESS);
		        form.setMsg("标引成功");
			}catch(Exception e){
	            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
	            form.setMsg("标引失败");
			}
			return form;
		}
}
