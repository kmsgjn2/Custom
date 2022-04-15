package com.custom.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.custom.user.UserDto;
import com.custom.user.UserService;

public class AutoLoginInterceptor implements HandlerInterceptor {

	@Autowired UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 전처리
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		// autoLogin 이름을 가진 쿠키 객체 생성
		Cookie cookie = WebUtils.getCookie(request, "autoLogin");
		
		if (session.getAttribute("userName") == null) {			
			// 세션에 유저 이름이 없으면
			if (cookie != null) {
				
				// 쿠키가 있으면 쿠키 값 저장 
				String nick = cookie.getValue();
				
				UserDto dto = userService.autoLogin(nick);
				
				session.setAttribute("userSeq",dto.getCustom_user_idx());
				session.setAttribute("userName", dto.getCustom_user_name());
				session.setAttribute("userNick", dto.getCustom_user_nick());
				session.setAttribute("userAuth", dto.getCustom_user_auth());

			}
		}
		
		return true;
	}

}
