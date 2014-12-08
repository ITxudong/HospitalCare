package com.kaishengit.action.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FlashScopeFilter extends HttpServlet implements Filter{

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		
		Enumeration<String> sessionAttrNames = session.getAttributeNames();
		while(sessionAttrNames.hasMoreElements()) {
			String attrName = sessionAttrNames.nextElement();
			if(attrName.startsWith("_")) {
				request.setAttribute(attrName, session.getAttribute(attrName));
				session.removeAttribute(attrName);
			}
		}
		
		
		
		filterChain.doFilter(req, resp);
		
		Enumeration<String> attrNames = request.getAttributeNames();
		
		while(attrNames.hasMoreElements()) {
			String attrName = attrNames.nextElement();
			if(attrName.startsWith("flash.")) {
				session.setAttribute(attrName.substring(attrName.indexOf(".")+1), request.getAttribute(attrName));
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
