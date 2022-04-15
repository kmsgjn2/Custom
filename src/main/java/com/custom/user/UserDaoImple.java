package com.custom.user;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("user")
public class UserDaoImple implements UserDao {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public UserDto loginAction(String custom_user_email) {
		return sqlSessionTemplate.selectOne("loginAction", custom_user_email);
	}
	
	@Override
	public void registerAction(UserDto dto) {
		sqlSessionTemplate.insert("registerAction", dto);
	}
	
	@Override
	public int nickCheck(String custom_user_nick) {
		return sqlSessionTemplate.selectOne("nickCheck", custom_user_nick);
	}
	
	@Override
	public int emailCheck(String custom_user_email) {
		return sqlSessionTemplate.selectOne("emailCheck", custom_user_email);
	}
	
	@Override
	public UserDto autoLogin(String custom_user_nick) {
		return sqlSessionTemplate.selectOne("autoLogin", custom_user_nick);
	}
	
	@Override
	public int findPswdEmailCheck(String custom_user_email) {
		return sqlSessionTemplate.selectOne("findPswdEmailCheck", custom_user_email);
	}
	
	@Override
	public int findPswdPhoneCheck(String custom_user_phone) {
		return sqlSessionTemplate.selectOne("findPswdPhoneCheck", custom_user_phone);
	}
	
	@Override
	public void findPswdAction(HashMap<String, String> map) {
		sqlSessionTemplate.update("findPswdAction", map);
	}
}
