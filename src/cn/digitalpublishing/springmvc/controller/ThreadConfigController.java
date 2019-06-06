
package cn.digitalpublishing.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.digitalpublishing.config.ProcessQueue;
import cn.digitalpublishing.springmvc.form.ThreadConfigForm;

/**
 * 线程配置
 * 
 * @author zhouwenqian
 */
@Controller
@RequestMapping("/pages/threadconfig")
public class ThreadConfigController extends BaseController {

	/**
	 * 显示首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index(ThreadConfigForm form) throws Exception {
		
		String forwardString ="threadconfig/threadConfigList.ftl";
		
		Map<String,Object> model = new HashMap<String,Object>();
		
		try {
			
			form.setThreadA(ProcessQueue.SOURCEDATALOAD);
			form.setThreadB(ProcessQueue.ANALYSISDATALOAD);
			
			form.setMsg("成功");
			
		} catch (Exception e) {
			
			form.setMsg("加载失败");
		}
		
		return new ModelAndView(forwardString);
	
	}
	/**
	 * 设置线程状态
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/form/submit")
	public ThreadConfigForm submit(HttpServletRequest request,HttpServletResponse response,ThreadConfigForm form) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			ProcessQueue.SOURCEDATALOAD=form.getSourceDataLoad();
			
//			ProcessQueue.THREADBSTAUTS=form.getAnalysisDataLoad();
//			
//			ProcessQueue.THREADCSTAUTS=form.getDownload();
//
//			System.out.println(form.getDownload());

			ProcessQueue.ANALYSISDATALOAD=form.getAnalysisDataLoad();
			
			form.setIsSuccess("true");
			
		} catch (Exception e) {
			// TODO: handle exception
			form.setIsSuccess("false");
		}
		
		map.put("ThreadConfigForm", form);
		
		return form;
	}
		
}

