package com.pbrm.backend.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// se ejecuta primero antes de entrar en el metodo del controlador
		request.setAttribute("starttime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// se ejecuta despues despues de mostrar la vista del navegador
		long starttime = (long) request.getAttribute("starttime");
		LOG.info("-- Reques --"+request.getRequestURL().toString()+ "--Total: "+(System.currentTimeMillis() - starttime) + "ms");
	}
	
	

}
