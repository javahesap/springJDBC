package com.proje.repostory;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserDetail;

public interface UserDetailRepostory {
	
	boolean Save (int userId, UserDetail userdetail);
	boolean update (UserDetail userDetail);
	
	
	UserDetail userDetailfindById(int id);

	
	List<UserDetail> findUserDetails();	
	

}
