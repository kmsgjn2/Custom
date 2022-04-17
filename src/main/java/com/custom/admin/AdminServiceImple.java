package com.custom.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired private AdminDao adminDao;
	
	@Override
	public List<AdminDto> UserList() {
		return adminDao.UserList();
	}
}
