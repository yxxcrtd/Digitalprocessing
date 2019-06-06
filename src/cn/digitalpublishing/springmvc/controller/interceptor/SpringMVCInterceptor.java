package cn.digitalpublishing.springmvc.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.digitalpublishing.springmvc.controller.BaseController;

public class SpringMVCInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		Dev.reloadHQL();
		if (handler != null) {
			BaseController base = (BaseController) handler;
			base.setRequest(request);
			base.setResponse(response);
			base.setSession(request.getSession());
		}
		return super.preHandle(request, response, handler);
	}
}