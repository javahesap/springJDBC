package com.proje.repostory;

import java.util.List;

import com.proje.model.User;

public interface UserRepostory {
	
	boolean Save (User user);
	boolean update (User user);
	boolean deleteById (int id);
	
	User findById(int id);
	User findWidthUserDetailById(int id);
	
	List<User> findUsers();	
	

}
