package com.proje.service;

import java.util.List;

import com.proje.model.User;

public interface UserService {
	boolean Save (User user);
	boolean update (User user);
	boolean deleteById (int id);
	
	User findById(int id);
	User findWidthUserDetailById(int id);
	
	List<User> findUsers();	
}
