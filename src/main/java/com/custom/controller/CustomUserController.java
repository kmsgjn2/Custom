package com.custom.controller;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.custom.user.UserDto;
import com.custom.user.UserService;

@Controller
@RequestMapping("/user")
public class CustomUserController {

	@Autowired UserService userService;
	@Autowired private JavaMailSenderImpl mailSender;
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	// 로그인 
	@PostMapping("/login")
	public ModelAndView loginAction(UserDto dto, 
									@RequestParam(value = "autoLogin", defaultValue = "off") String autoLogin,
									HttpSession session,
									HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		UserDto userDto = userService.loginAction(dto.getCustom_user_email());
		
		if (userDto.getCustom_user_pswd().equals(dto.getCustom_user_pswd())) {
			
			session.setAttribute("userIdx", userDto.getCustom_user_idx());
			session.setAttribute("userName", userDto.getCustom_user_name());
			session.setAttribute("userNick", userDto.getCustom_user_nick());
			session.setAttribute("userAuth", userDto.getCustom_user_auth());
		
			
			if (autoLogin.equals("off")) {
				
				// 자동 로그인 off 일떄
				Cookie cookie = new Cookie("autoLogin", null);
				
				cookie.setMaxAge(0);
				
				response.addCookie(cookie);
				
			} else {
				
				// 자동 로그인 on 일떄
				Cookie cookie = new Cookie("autoLogin", userDto.getCustom_user_nick());
		
				// 어느 경로에서든 쿠키를 찾을수있게 설정
				cookie.setPath("/");
				
				cookie.setMaxAge(60*60);
				
				response.addCookie(cookie);
			}
			
			mav.addObject("msg", "로그인 성공!");
			mav.addObject("url", "/main");
			
		} else {
			mav.addObject("msg", "로그인 실패!");
			mav.addObject("url", "/user/login");
		}
		
		return mav;
	}	
	
	// 로그아웃
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("msg/msg");
		
		Cookie cookie = new Cookie("autoLogin", null);
		
		cookie.setPath("/");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		session.invalidate();
		
		mav.addObject("msg", "로그아웃 성공!");
		mav.addObject("url", "/main");
		
		return mav;
	}
	
	// 회원가입 페이지 이동
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	// 회원가입 
	@PostMapping("/register")
	public ModelAndView registerAction(UserDto dto) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		userService.registerAction(dto);
		
		mav.addObject("msg", "회원 가입 성공!");
		mav.addObject("url", "/user/login");
		
		return mav;
	}
	
	// 닉네임 중복 체크 or 글자수 2자리부터 30이하 제한
	@ResponseBody
	@PostMapping("/nickCheck")
	public int nickCheck(@RequestParam String custom_user_nick) {
		return userService.nickCheck(custom_user_nick);
	}
	
	// 이메일 중복 체크 or 이메일 형식 체크
	@ResponseBody
	@PostMapping("/emailCheck")
	public int emailCheck(@RequestParam String custom_user_email) {
		return userService.emailCheck(custom_user_email);
	}
	
	// 비밀번호 찾기 페이지 이동
	@GetMapping("/forgetPswd")
	public String forgetPswd() {
		return "user/forgetPswd";
	}
	
	// 비빌번호 찾기
	@PostMapping("/forgetPswd")
	public ModelAndView findPswd(@RequestParam String mailandphone) throws Exception {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
		
		if (userService.findPswdEmailCheck(mailandphone) == 1) {
			
			
			// 이메일로 입력했을 때
			String from = "morejh4485@gmail.com";//보내는 이 메일주소
			String to = mailandphone;
			String title = "회원가입시 임시 비밀번호 입니다.";
			String content = "[임시번호] "+ serti +" 입니다. <br/> 로그인 후 변경 부탁드립니다!.";
			String num = "";

			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

				
				mailHelper.setFrom(from);
				mailHelper.setTo(to);
				mailHelper.setSubject(title);
				mailHelper.setText(content, true);       

				mailSender.send(mail);

				num = Integer.toString(serti);
				System.out.println("임시비밀번호 = " + num);
				
			} catch(Exception e) {
				num = "error";
			}
			
			map.put("mailandphone", mailandphone);
			map.put("pswd", num);
			
			userService.findPswdAction(map);			
			
			mav.addObject("msg", "임시 비밀번호가 이메일로 발송되었습니다!");
			mav.addObject("url", "/user/login");
			
		} else if (userService.findPswdPhoneCheck(mailandphone) == 1) {
			
			// 전화번호로 입력 했을 때
			String num = Integer.toString(serti);
			
			String phone = "";
			String arr_phoneNum[] = mailandphone.split("-");
			
			for (int i = 0; i < arr_phoneNum.length; i++) {
				
				phone += arr_phoneNum[i];
				
			}
			
			map.put("mailandphone", phone);
			map.put("pswd", num);
			System.out.println("임시비밀번호 = " + num);
			
			userService.findPswdAction(map);
			
			mav.addObject("msg", "임시 비밀번호 " + num + " 입니다!");
			mav.addObject("url", "/user/login");
			
		} else {
			mav.addObject("msg", "이메일 or 비밀번호 오류!");
			mav.addObject("url", "/user/forgetPswd");
		}
		
		return mav;
	}
}
