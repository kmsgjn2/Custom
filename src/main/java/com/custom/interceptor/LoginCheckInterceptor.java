package com.custom.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userIdx") == null) {
			// 세션에 유저가 없으면 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		return true;
	}
}
