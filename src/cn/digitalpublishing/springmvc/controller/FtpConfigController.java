
package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.springmvc.form.FtpConfigForm;

/**
 * 
 * 
 * @author zhouwenqian
 */
@Controller
@RequestMapping("/pages/ftpconfig")
public class FtpConfigController extends BaseController {

	/**
	 * 显示首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("ftpconfig/ftpconfigList.ftl");
	}

	/**
	 * 新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/add")
	public ModelAndView add() throws Exception {
		return new ModelAndView("ftpconfig/ftpconfigAdd.ftl");
	}

	/**
	 * 新增后保存
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody        
	
	@RequestMapping("/form/addSubmit")
	public FtpConfigForm add(FtpConfigForm form) throws Exception {
		try {
			FtpConfig ftpConfig = form.getObj();
			
				this.ftpConfigService.insert(ftpConfig);
				form.setMsg("添加成功!");
				form.setIsSuccess(SUCCESS);
			}catch (Exception e) {
			form.setIsSuccess(FAILURE);
			forwardString = "msg";
			form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		return form;
	}
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	
	@ResponseBody
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json"  )
	public FtpConfigForm manager(FtpConfigForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		List<FtpConfig> list = new ArrayList<FtpConfig>();
		
		try {
			form.setiTotalRecords(this.ftpConfigService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (0 < form.getiTotalRecords()) {
				list = this.ftpConfigService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
			form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		form.setAaData(list);
		return form;
	}
	
	
	/**
	 * 修改页
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/edit")
	public ModelAndView edit(FtpConfigForm form) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		forwardString = "ftpconfig/ftpconfigEdit.ftl";
		try {
			if (null != form.getId() && !"".equals(form.getId())) {
				FtpConfig ftpConfig = this.ftpConfigService.findbyid(form.getId());
				form.setObj(ftpConfig);
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		map.put("form", form);
		return new ModelAndView(forwardString, map);
	}
	
	/**
	 * 修改后保存
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/form/editSubmit")
	public FtpConfigForm editSubmit(FtpConfigForm form) throws Exception {
		FtpConfig ftpConfig = form.getObj();
		try {
			this.ftpConfigService.update(ftpConfig, ftpConfig.getId(), null);
			form.setMsg("修改成功");
			form.setIsSuccess(SUCCESS);
			
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		return form;
	}
	
	
	/**
	 * 删除
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/form/delete")
	public FtpConfigForm delete(FtpConfigForm form) {
		String id = request.getParameter("id");
		try {
			this.ftpConfigService.delete(id);
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
	    	form.setMsg((e instanceof CcsException)?((CcsException)e).getPrompt():e.getMessage());
		}
		return form;
	}
	


}
