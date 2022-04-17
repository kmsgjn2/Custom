package com.custom.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("admin")
public class AdminDaoImple implements AdminDao {
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<AdminDto> UserList() {
		return sqlSessionTemplate.selectList("UserList");
	}
}
