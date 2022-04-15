package com.custom.user;

import java.util.HashMap;

public interface UserService {

	// 로그인
	public UserDto loginAction(String custom_user_email);
	
	// 회원가입
	public void registerAction(UserDto dto);
	
	// 닉네임 중복 체크 or 글자수 2자리부터 30이하 제한
	public int nickCheck(String custom_user_nick);
	
	// 이메일 중복 체크 or 이메일 형식 체크
	public int emailCheck(String custom_user_email);
	
	// 자동 로그인
	public UserDto autoLogin(String custom_user_nick);
	
	// 임시비밀번호 찾기 전 이메일 비밀번호 체크
	public int findPswdEmailCheck(String custom_user_email);
	
	// 임시비밀번호 찾기 전 전화번호 체크
	public int findPswdPhoneCheck(String custom_user_phone);
	
	// 임시비밀번호로 변경
	public void findPswdAction(HashMap<String, String> map);
}
