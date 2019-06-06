package cn.digitalpublishing.springmvc.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.service.ConvertResourceService;
import cn.digitalpublishing.service.FtpConfigService;
import cn.digitalpublishing.service.FtpFolderService;
import cn.digitalpublishing.service.OcrFileService;
import cn.digitalpublishing.service.PDFService;
import cn.digitalpublishing.service.ResourceService;
import cn.digitalpublishing.service.SubjectService;
import cn.digitalpublishing.service.TemplateMappingService;
import cn.digitalpublishing.service.TemplateNodeService;
import cn.digitalpublishing.service.TemplateService;
import cn.digitalpublishing.service.XmlNodeService;

public class BaseController extends MultiActionController {

    public Logger log = Logger.getLogger(this.getClass());

    public static final String FAILURE = "false";
    public static final String SUCCESS = "true";
    public static final String TIMEOUT = "timeout";
    
    protected String forwardString = "";

    private static final boolean DEBUG = true;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @return
     */
    public String exMsg(Exception e) {
        return exMsg(e, null, null);
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @param language
     * @return
     */
    public String exMsg(Exception e, String language) {
        return exMsg(e, null, language);
    }

    /**
     * 异常消息处理
     *
     * @param msg
     * @param e
     * @return
     */
    public String exMsg(String msg, Exception e) {
        return exMsg(e, msg, null);
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @param msg
     * @return
     */
    public String exMsg(Exception e, String msg, String language) {
        if (DEBUG) {
            e.printStackTrace();
        }
        if (msg != null && !msg.equals("")) {
            return msg;
        }
        if (e instanceof CcsException) {
            CcsException ce = (CcsException) e;
            return ce.getPrompt();
        } else {
            return e.getMessage();
        }
    }
    
    public static final String getSwftoolsPath() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("src").replace("-", ":");
    }
    
    public static final String getUploadPath() {
		Map<String, String> config = Param.getParam("product.structure.element.path");
    	return config.get("src").replace("-", ":");
    }
    
    public static final String getXpdfPath() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("font").replace("-", ":");
    }
    
    public static final String getConfigByPage() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("page");
    }
    
    public static final String getConfigByTitle() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("title");
    }
    
    
    @Autowired
	@Qualifier("ftpConfigService")
	protected FtpConfigService ftpConfigService;
    
    @Autowired
	@Qualifier("ftpFolderService")
	protected FtpFolderService ftpFolderService;
    
    @Autowired
	@Qualifier("ocrFileService")
	protected OcrFileService ocrFileService;
    
    @Autowired
	@Qualifier("pdfService")
	protected PDFService pdfService;
    
    @Autowired
	@Qualifier("subjectService")
	protected SubjectService subjectService;
    
    
    @Autowired
   	@Qualifier("resourceService")
    protected ResourceService resourceService;
    
    @Autowired
   	@Qualifier("xmlNodeService")
    protected XmlNodeService xmlNodeService;
    
    @Autowired
   	@Qualifier("templateService")
    protected TemplateService templateService;
    
    @Autowired
   	@Qualifier("templateNodeService")
    protected TemplateNodeService templateNodeService;
    
    @Autowired
   	@Qualifier("templateMappingService")
    protected TemplateMappingService templateMappingService;
    
    @Autowired
   	@Qualifier("convertResourceService")
    protected ConvertResourceService convertResourceService;
}