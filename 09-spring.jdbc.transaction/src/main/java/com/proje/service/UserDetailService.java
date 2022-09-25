package com.proje.service;

import java.util.List;

import com.proje.model.UserDetail;

public interface UserDetailService { 
	
	
	boolean Save (int userId, UserDetail userdetail);
	boolean update (UserDetail userDetail);
	
	
	UserDetail userDetailfindById(int id);

	
	List<UserDetail> findUserDetails();	

}
