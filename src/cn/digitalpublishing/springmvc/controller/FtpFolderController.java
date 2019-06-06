
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
import cn.digitalpublishing.po.FtpFolder;
import cn.digitalpublishing.springmvc.form.FtpFolderForm;

/**
 * 
 * 
 * @author zhouwenqian
 */
@Controller
@RequestMapping("/pages/ftpfolder")
public class FtpFolderController extends BaseController {

	/**
	 * 显示首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("ftpfolder/ftpfolderList.ftl");
	}
	
	
	/**
	 * 新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/add")
	public ModelAndView add(FtpFolderForm form) throws Exception {
		Map<String,Object> model = new HashMap<String,Object>();
		
		//进行查询，查出来FtpConfig的list
		List<FtpConfig> ftpConfigList = null;
		ftpConfigList = this.ftpConfigService.getList(model);
		
		//list的值显示到页面
		
		model.put("ftpConfigList", ftpConfigList);
		
		return new ModelAndView("ftpfolder/ftpFolderAdd.ftl",model);

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
	public FtpFolderForm addSubmit(FtpFolderForm form) throws Exception {
	
		try {
			String ftpid = form.getFtpid();
			FtpConfig ftpConfig = new FtpConfig();
			ftpConfig.setId(ftpid);
			FtpFolder ftpFolder = form.getObj();
			
			ftpFolder.setFtpConfig(ftpConfig);
			System.out.println(ftpFolder);
				this.ftpFolderService.insert(ftpFolder);
				form.setMsg("添加成功!");
				form.setIsSuccess(SUCCESS);
			}catch (Exception e) { 
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
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
	public FtpFolderForm manager(FtpFolderForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		List<FtpFolder> list = new ArrayList<FtpFolder>();
		try {
			form.setiTotalRecords(this.ftpFolderService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (form.getiTotalRecords() > 0) {
				list = this.ftpFolderService.getPagingList(condition, "",
						form.getiDisplayLength(), form.getiDisplayStart());
			}
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
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
	public ModelAndView edit(FtpFolderForm form) throws Exception {
		
		Map<String,Object> model = new HashMap<String,Object>();
		
		String forwardString="ftpfolder/ftpFolderEdit.ftl";
		
		//ftpConfigList
		List<FtpConfig> ftpConfigList = null;
		//得到要修改的文件夹配置的id
		String editId = form.getId();
		//FtpFolder
		FtpFolder obj = null;
		
		try{
			//得到ftpConfigList
			ftpConfigList = this.ftpConfigService.getList(model);
			
			if(editId!=null&&!"".equals(editId)){
				//根据id得到FtpFolder
				obj = this.ftpFolderService.findById(editId);
				System.out.println(obj.getFtpConfig().getId());
				form.setObj(obj);
				form.setId(editId);
			}
		}catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		model.put("ftpConfigList", ftpConfigList);
		model.put("form", form);
		return new ModelAndView(forwardString, model);

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
	public FtpFolderForm editSubmit(FtpFolderForm form) throws Exception {
		
			String ftpid = form.getFtpid();
			FtpFolder ftpFolder = form.getObj();
			FtpConfig ftpConfig = new FtpConfig();
			ftpConfig.setId(ftpid);
			ftpFolder.setFtpConfig(ftpConfig);
		try {
			this.ftpFolderService.update(ftpFolder, ftpFolder.getId(), null);
			form.setMsg("修改成功");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg("修改失败！");
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
	public FtpFolderForm delete(FtpFolderForm form) throws Exception {
		String id = request.getParameter("id");
		try {
			this.ftpFolderService.delete(id);
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException)?((CcsException)e).getMessage():e.getMessage());
		}
		return form;
	}

}
