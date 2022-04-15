package com.custom.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

	@Autowired private UserDao userDao;
	
	@Override
	public UserDto loginAction(String custom_user_email) {
		return userDao.loginAction(custom_user_email);
	}
	
	@Override
	public void registerAction(UserDto dto) {
		
		// 전화번호 자르기 010-1234-5678 -> 01012345678
		String num = "";
		String arr_phoneNum[] = dto.getCustom_user_phone().split("-");
		
		for (int i = 0; i < arr_phoneNum.length; i++) {
			num += arr_phoneNum[i];			
		}
		
		dto.setCustom_user_phone(num);
		
		userDao.registerAction(dto);
	}
	
	@Override
	public int nickCheck(String custom_user_nick) {
		return userDao.nickCheck(custom_user_nick);
	}
	
	@Override
	public int emailCheck(String custom_user_email) {
		return userDao.emailCheck(custom_user_email);
	}
	
	@Override
	public UserDto autoLogin(String custom_user_nick) {
		return userDao.autoLogin(custom_user_nick);
	}
	
	@Override
	public int findPswdEmailCheck(String custom_user_email) {
		return userDao.findPswdEmailCheck(custom_user_email);
	}
	
	@Override
	public int findPswdPhoneCheck(String custom_user_phone) {
		
		// 전화번호 자르기 010-1234-5678 -> 01012345678
		String num = "";
		String arr_phoneNum[] = custom_user_phone.split("-");
		
		for (int i = 0; i < arr_phoneNum.length; i++) {
			num += arr_phoneNum[i];
		}				
		
		return userDao.findPswdPhoneCheck(num);
	}
	
	@Override
	public void findPswdAction(HashMap<String, String> map) {
		userDao.findPswdAction(map);
	}
}
