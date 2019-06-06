package cn.digitalpublishing.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.po.BSubRelation;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.TemplateMapping;
import cn.digitalpublishing.springmvc.form.BSubRelationForm;
import cn.digitalpublishing.springmvc.form.SubjectForm;

@Controller
@RequestMapping("/pages/subject")
public class SubjectController extends BaseController {
	
	
	/**
	 * 跳转图书分类列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("subject/subjectList.ftl");
	}
	
	
	/**
	 * 跳转图书分类列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/relationindex")
	public ModelAndView relationindex(BSubRelationForm form) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("parentId", "0");//查询父类是null的
		condition.put("type", 2);//1-主要分类法 2-其他分类法
		form.setElseList(this.subjectService.getSubList(condition, " order by a.treeCode "));//其他分类顶级名称查询
		map.put("form", form);
		return new ModelAndView("subject/subjectrelationList.ftl",map);
	}
	
	/**
	 * 查询图书分类
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/manager")
	public SubjectForm manager(SubjectForm form)throws Exception {
		try{
			form.getCondition().put("parentId", "0");
			Map<String,Object> condititon = new HashMap<String,Object>();
			condititon.put("parentId", "0");
			form.setiTotalRecords(this.subjectService.getSubjectCount(condititon));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			List<BSubject> list = this.subjectService.getSubjectPagingList(condititon," ",form.getiDisplayLength(),form.getiDisplayStart());
			form.setAaData(list);
		}catch(Exception e){
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
			forwardString="error";
		}
		return form;
	}

	
	@ResponseBody
	@RequestMapping(value="/form/editsubmit")
	public SubjectForm editsubmit(SubjectForm form)throws Exception {
		try{
			String oldid = request.getParameter("oldid");
			String mainid = request.getParameter("mainid");
			String newid = request.getParameter("newid");
			
			
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("esleSubid",oldid);
			condition.put("mainSubid", mainid);
			//通过oldid 和 mainid 查询 ，如果存在则删除
			if(oldid!=null&&!"".equals(oldid)){
				List<BSubject> list = this.subjectService.getSubjectList(condition, "");
				if(list!=null&&list.size()>0){
					this.templateMappingService.delete(list.get(0).getId());
				}
			}
			//判断xmlnode 是不是null 或“” 否则进行添加操作
			if(newid!=null&&!"".equals(newid)){
				//添加
				BSubRelation bSubRelation = new BSubRelation();
				BSubject mainSub = new BSubject();
				mainSub.setId(newid);
				
				BSubject esleSub = new BSubject();
				esleSub.setId(mainid);
				
				bSubRelation.setMainSub(mainSub);
				bSubRelation.setElseSub(esleSub);
				this.subjectService.saveObj(bSubRelation);
			}
			
		}catch(Exception e){
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
			forwardString="error";
		}
		return form;
	}
	
	/**
	 * 分类映射关系管理
	 * @param request
	 * @param response
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/relationManager")
	public BSubRelationForm relationManager(BSubRelationForm form)throws Exception {
		Map<String,Object> model = new HashMap<String,Object>();
		System.out.println(form.getBaseCode());
		System.out.println(request.getParameter("baseCode"));
		try{
			Map<String,Object> condition = form.getCondition();
			condition.put("parentId", "0");//查询父类是null的
			condition.put("type", 2);//1-主要分类法 2-其他分类法
			Map<String,Object> conditionMain = new HashMap<String,Object>();
			conditionMain.put("parentId", "-1");//查询父类是null的
			conditionMain.put("type", 1);
			List<BSubject> listSB = this.subjectService.getSubList(conditionMain, " order by a.treeCode ");
			form.setSubList(listSB);//查询主分类法下边的所有子分类
			List<BSubRelation> list = new ArrayList<BSubRelation>();
			if(form.getBaseCode()!=null&&!"".equals(form.getBaseCode())){
				form.getCondition().put("baseCode", form.getBaseCode());
				form.getCondition().put("code", form.getCode());
				form.getCondition().put("name", form.getName());
				//
				form.setiTotalRecords(this.subjectService.getRelationCount(form.getCondition()));
				form.setiTotalDisplayRecords(form.getiTotalRecords());

				list = this.subjectService.getRelationPagingList(form.getCondition()," order by b.treeCode ",form.getiDisplayLength(),form.getiDisplayStart());
			}else{
				form.setiTotalRecords(0);
				form.setiTotalDisplayRecords(form.getiTotalRecords());
			}
			
			for (BSubRelation bSubRelation : list) {
				bSubRelation.setListBS(listSB);
			}
			
			model.put("list", list);
			form.setAaData(list);
		}catch(Exception e){
			e.printStackTrace();
            request.setAttribute("message",(e instanceof CcsException)?((CcsException)e).getMessage():e.getMessage());
			forwardString="error";
		}
		return form;
	}
	
	/**
	 * 跳转添加或修改页面
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/form/edit")
	public ModelAndView edit(SubjectForm form)throws Exception {
		String forwardString="subject/subjectEdit.ftl";
		Map<String,Object> model = new HashMap<String,Object>();
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("type", 1);
			condition.put("parentId", "0");
			if(this.subjectService.getSubjectCount(condition)==0){
				form.setLoadType(Param.getParam("page.BSubject.type",true,request.getSession().getAttribute("lang").toString()));
			}else{
				form.setLoadType(Param.getParam("page.BSubject.type.only",true,request.getSession().getAttribute("lang").toString()));
			}
			form.setLoadStandard(Param.getParam("page.BSubject.standard",true,request.getSession().getAttribute("lang").toString()));
			if(request.getParameter("eid")!=null&&!"".equals(request.getParameter("eid").toString())){
				form.setObj(this.subjectService.getSubject(request.getParameter("eid").toString()));
				form.setId(request.getParameter("eid").toString());
			}
			
			model.put("form", form);
			
		}catch(Exception e){
            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
			forwardString="error";
		}
		return new ModelAndView(forwardString, model);
	}
	
	/**
	 * 配置分类
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/form/generate")
	public ModelAndView generate(SubjectForm form)throws Exception {
		String forwardString="subject/list";
		return new ModelAndView(forwardString);
	}
	
	
	/**
	 * 保存或修改
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/editSubmit")
	public SubjectForm editSubmit(SubjectForm form) throws Exception {
		try{
			BSubject subject = form.getObj();
			if(subject.getId()!=null && !"".equals(subject.getId()) && !"0".equals(subject.getId())){
				//查询Code是否存在
				Map<String,Object> condition = new HashMap<String,Object>();
				condition.put("code", form.getObj().getCode());
				condition.put("parentId", "0");
				/*List<BSubject> list = null;
				if(!form.getOldCode().equalsIgnoreCase(form.getObj().getCode())){
					list = this.subjectService.getSubList(condition, "");
				}
				if(list!=null&&list.size()>0){
					form.setIsSuccess("false");
					form.setMsg(Lang.getLanguage("BSubject.info.code.exist",request.getSession().getAttribute("lang").toString()));//编码已经存在！"
				}else{*/
					String[] properties=null;
					form.getObj().setStandard(1);
					form.getObj().setType(1);
					this.subjectService.updateSubject(form.getObj(), form.getObj().getId(), properties);
					form.setIsSuccess(SUCCESS);
					form.setMsg("修改成功");//修改成功!
//				}
			}else{
				//查询Code是否存在
				Map<String,Object> condition = new HashMap<String,Object>();
				condition.put("code", form.getObj().getCode());
				condition.put("parentId", "0");
//				List<BSubject> list = null;
//				list = this.subjectService.getSubList(condition, "");
//				if(list!=null&&list.size()>0){
//					form.setIsSuccess("false");
//					form.setMsg(Lang.getLanguage("BSubject.info.code.exist",request.getSession().getAttribute("lang").toString()));//编码已经存在！"
//				}else{
					form.getObj().setStandard(1);
					form.getObj().setType(1);
					this.subjectService.addSubject(form.getObj());
					form.setIsSuccess(SUCCESS);
					form.setMsg("添加成功");//"分类添加成功"
//				}
			}
		}catch(Exception e){
			e.printStackTrace();
			form.setIsSuccess("false");
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		return form;
	}
	/**
	 * 删除图书分类
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/delete")
	public SubjectForm delete(SubjectForm form) throws Exception {
		try{
			String id = form.getId();
			this.subjectService.deleteSubject(id);
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);		
		}catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg("删除失败！");
		}
		return form;
	}
	
	@ResponseBody
	@RequestMapping(value="/form/subList")
	public void subList(SubjectForm form)throws Exception {
		String str="";
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			String pIdByPage = request.getParameter("id")==null?"0":request.getParameter("id");
			if(pIdByPage.equals("0")){
				if(request.getParameter("subId")!=null&&!request.getParameter("subId").equals("")){
					condition.put("subId", request.getParameter("subId"));
				}else{
					return;
				}
			}
			condition.put("parentId", pIdByPage);
			List<BSubject> list = this.subjectService.getSubjectList(condition, " order by a.order ");//PagingList(condition, " order by a.order ", 30, 0);//
			if (list != null && list.size() != 0) {
				String nId="";//节点id
				String pId="";//父节点id
				String nodeName="";//节点名称
				int size=list.size();//菜单数量
				for (int i=0;i<list.size();i++) {
					BSubject BSubject = list.get(i);
					nodeName=BSubject.getName();
					nId=BSubject.getId();
					pId=BSubject.getParentSubject()==null?"0":BSubject.getParentSubject().getId();
					if(i<size-1){//非最后一个
						str +="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,order:\""+BSubject.getOrder()+"\",name:\""+BSubject.getCode().replace("'", "\\'")+"-"+nodeName.replace("'", "\\'")+"\",drop:"+(pId.equals("0")?false:true)+",isParent:"+(Integer.valueOf(BSubject.getIsParent())>0?true:false)+"},";
					}else{//最后一个菜单
					    str+="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,order:\""+BSubject.getOrder()+"\",name:\""+BSubject.getCode().replace("'", "\\'")+"-"+nodeName.replace("'", "\\'")+"\",drop:"+(pId.equals("0")?false:true)+",isParent:"+(Integer.valueOf(BSubject.getIsParent())>0?true:false)+"}";
							
					}
				}
			}
				str= "["+str+"]";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		}catch(Exception e){
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
	@RequestMapping(value="/form/addSubjectSubmit")
	 public void addSubjectSubmit(HttpServletRequest request, HttpServletResponse response, SubjectForm form) throws Exception
	  {
	    String result = "";//"添加失败!";
	    try {
	    	//查询Code是否存在
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("code", form.getCode());
			condition.put("checkTreeCode", form.getTreeCode());
			List<BSubject> list = null;
			list = this.subjectService.getSubList(condition, "");
			if(list!=null&&list.size()>0){
				result = "error:"+Lang.getLanguage("BSubject.info.code.exist",request.getSession().getAttribute("lang").toString());//编码已经存在！";
			}else{
			    //根据父类ID查询父类信息
			    BSubject pSub = this.subjectService.getSubject(form.getpId());
			    BSubject BSubject = new BSubject();
			    BSubject.setName(form.getName());
			    BSubject.setType(pSub.getType());
			    BSubject.setParentSubject(pSub);
			    BSubject.setCode(form.getCode());
			    BSubject.setStandard(pSub.getStandard());
			    BSubject.setNameEn(form.getNameEn());
                BSubject.setDesc(form.getDesc());
			    String subjectId = this.subjectService.insertSubject(BSubject);
			    if(subjectId!=null&&!subjectId.trim().equals("")){
			    	result = "success:"+subjectId;
			    }
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
     * 2014-5-7李方华，页面传值增加了desc，去除nameEn
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
	  @RequestMapping("/form/editSubjectSubmit")
	  public void editSubjectSubmit(HttpServletRequest request, HttpServletResponse response, SubjectForm form) throws Exception{
	    String result = "";//"修改失败!";
	    try {
	    		//查询Code是否存在
				Map<String,Object> condition = new HashMap<String,Object>();
				condition.put("code", form.getCode());
				condition.put("checkTreeCode", form.getTreeCode());
				List<BSubject> list = null;
				if(!form.getOldCode().equalsIgnoreCase(form.getCode())){
					list = this.subjectService.getSubList(condition, "");
				}
				if(list!=null&&list.size()>0){
					result = "error:"+Lang.getLanguage("BSubject.info.code.exist",request.getSession().getAttribute("lang").toString());//编码已经存在！";;
				}else{
					BSubject BSubject = new BSubject();
			    	BSubject.setId(form.getId());
			    	BSubject.setName(form.getName());
			    	BSubject.setCode(form.getCode());
			    	BSubject.setNameEn(form.getNameEn());
			        this.subjectService.updateSubject(BSubject, form.getId(), null);
//                    this.saveOperationLog(request,"[图书分类管理]---更新图书分类“"+BSubject.getName()+"”");
			        result = "success:"+Lang.getLanguage("BSubject.info.edit.success",request.getSession().getAttribute("lang").toString());//"修改成功!";
				}
	    	
	    } catch (Exception e) {
	    	result = "error:"+((e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):result);
//	    	request.setAttribute("message",(e instanceof CcsException)?((CcsException)e).getMessage():e.getMessage());
	    }
	    response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	  }

    /**
     * 删除分类
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
	  @RequestMapping({"/form/deleteSubject"})
	  @ResponseBody
	  public SubjectForm deleteSubject(SubjectForm form) throws Exception
	  {
	    try{
	    	this.subjectService.deleteSubject(form.getId());
	    	form.setIsSuccess(SUCCESS);
	    } catch (Exception e) {
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
	    	form.setIsSuccess("err");
	    }
	    return form;
	  }
	  
	  /**
	   * 移动分类
	 * @param request
	 * @param response
	 * @param form
	 * @return
	 * @throws Exception
	 */
	  @RequestMapping({"/form/subjectPosChange"})
	  @ResponseBody
	  public String subjectPosChange(HttpServletRequest request, HttpServletResponse response, SubjectForm form) throws Exception
	  {
	    String result="error";
		try {
			this.subjectService.subjectPosChange(form);
			result="success";
		} catch (Exception e) {
			request.setAttribute("message",(e instanceof CcsException)?((CcsException)e).getMessage():e.getMessage());
		}
	    return result;
	  }

    /**
     *获取子节点
     * 2014-5-7李方华，将nameEn改成desc
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
	@ResponseBody
	@RequestMapping(value="/form/editChild")
	public SubjectForm editChild(SubjectForm form)throws Exception {
		try{
			BSubject bSubject = this.subjectService.getSubject(request.getParameter("id").toString());
			form.setObj(bSubject);
		}catch(Exception e){
//			e.printStackTrace();
            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
		}
		return form;
	}
	/**
	 * 检查Code是否存在
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping(value="/form/checkCode")
	public void checkCode(HttpServletRequest request,HttpServletResponse response, SubjectForm form)throws Exception {
			String result="";
		try{
			//查询Code是否存在
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("code", form.getCode());
			if(form.getIsp().equalsIgnoreCase("true")){
				condition.put("parentId", "0");
			}else{
				condition.put("checkTreeCode", form.getTreeCode());
			}
			
			List<BSubject> list = this.subjectService.getSubList(condition, "");
			if(list!=null&&list.size()>0){
				result = ""+Lang.getLanguage("BSubject.info.code.exist",request.getSession().getAttribute("lang").toString());//编码已经存在！";;
			}
			response.setContentType("text/html;charset=utf-8");
		    PrintWriter writer = null;
		    try {
				//获取输出流
				writer = response.getWriter();
				writer.print(result);
			} catch (IOException e) {
//				e.printStackTrace();
				throw e;
			} finally{
				if(writer != null){
					writer.close();
				}
			}
		}catch(Exception e){
//			e.printStackTrace();
            request.setAttribute("message",(e instanceof CcsException)?Lang.getLanguage(((CcsException)e).getPrompt(),request.getSession().getAttribute("lang").toString()):e.getMessage());
		}
	}
	
	/**
	 * 用于选择分类法
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping(value="/form/selectSubList")
	public void selectSubList(HttpServletRequest request,HttpServletResponse response, SubjectForm form)throws Exception {
		String str="";
		try{
			Map<String,Object> condition = new HashMap<String,Object>();
			
			String pIdByPage = request.getParameter("id")==null?"0":request.getParameter("id");
			if(pIdByPage.equals("0")){
				if(form.getCode()!=null&&!"".equals(form.getCode())){
					condition.put("code", request.getParameter("code"));
				}
//				if(request.getParameter("subId")!=null&&!request.getParameter("subId").equals("")){
//					condition.put("subId", request.getParameter("subId"));
//				}
				else{
					return;
				}
			}
			condition.put("pubId", form.getPubId()==null?"":form.getPubId());
			condition.put("parentId", pIdByPage);
			
			List<BSubject> list = this.subjectService.getSubjectListToContent(condition, " order by a.order ");
			if (list != null && list.size() != 0) {
				String nId="";//节点id
				String pId="";//父节点id
				String nodeName="";//节点名称
				int size=list.size();//菜单数量
				for (int i=0;i<list.size();i++) {
					BSubject BSubject = list.get(i);
					nodeName=BSubject.getName();
					nId=BSubject.getId();
					pId=BSubject.getParentSubject()==null?"0":BSubject.getParentSubject().getId();
					if(i<size-1){//非最后一个
						str +="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,order:\""+BSubject.getOrder()+"\",name:\""+BSubject.getCode().replace("'", "\\'")+"-"+nodeName.replace("'", "\\'")+"\",drop:"+(pId.equals("0")?false:true)+",isParent:"+(Integer.valueOf(BSubject.getIsParent())>0?true:false)+",checked:"+((BSubject.getChecked()!=null&&BSubject.getChecked()>0)?true:false)+"},";
					}else{//最后一个菜单
					    str+="{id:\""+nId+"\",pId:\""+pId+"\",editNameFlag:true,order:\""+BSubject.getOrder()+"\",name:\""+BSubject.getCode().replace("'", "\\'")+"-"+nodeName.replace("'", "\\'")+"\",drop:"+(pId.equals("0")?false:true)+",isParent:"+(Integer.valueOf(BSubject.getIsParent())>0?true:false)+",checked:"+((BSubject.getChecked()!=null&&BSubject.getChecked()>0)?true:false)+"}";
							
					}
				}
			}
				str= "["+str+"]";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		}catch(Exception e){
            request.setAttribute("message",(e instanceof CcsException)?((CcsException)e).getMessage():e.getMessage());
		}
//		return str;
	}
}
