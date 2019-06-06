
package cn.digitalpublishing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ocr文件管理
 * 
 * @author zhouwenqian
 */
@Controller
@RequestMapping("/pages/fileManager")
public class FileManagerController extends BaseController {

	/**
	 * 显示首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		
		String forwardString ="fileManager/fileManager";
		
		return new ModelAndView(forwardString);
	
	}
	
}