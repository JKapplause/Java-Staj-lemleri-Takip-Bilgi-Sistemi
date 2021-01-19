package com.ismailekin.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ismailekin.entity.UserA;
import com.ismailekin.stajtakip.HomeController;

@Component
@Scope("session")

public class LoginFilter implements Filter {

	public static UserA user =null;
    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(req.getRequestURI().contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("register")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("ogrenciekle")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("logout")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("reg")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("controlUser")) {
			chain.doFilter(request, response);
			return;
		}
				
		
		UserA user = (UserA) req.getSession().getAttribute("user");
		this.user = user;
		if(user != null) {
			chain.doFilter(request, response);
			return;
		}else {
			res.sendRedirect(HomeController.url+"/login");
		}
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
