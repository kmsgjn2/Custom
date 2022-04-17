package com.custom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.custom.admin.AdminDto;
import com.custom.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class CustomAdminController {

	@Autowired AdminService adminService;
	
	// 회원 정보 페이지 이동
	@GetMapping("/userInfo")
	public ModelAndView userInfo() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", adminService.UserList());
		
		return mav;
	}
	
	// 회원 목록 불러오기
	@ResponseBody
	@PostMapping("/userInfoList")
	public List<AdminDto> userInfoList() {
		System.out.println("접근");
		List<AdminDto> list = adminService.UserList();
		return list;
	}
}
