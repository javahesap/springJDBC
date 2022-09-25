package com.proje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.UserDetail;
import com.proje.repostory.UserDetailRepostory;
import com.proje.service.UserDetailService;
@Service
public class UserDetailServiceIpl implements UserDetailService {
         @Autowired
	   private UserDetailRepostory userdetailRepository;
	
	@Override
	public boolean Save(int userId, UserDetail userdetail) {
		// TODO Auto-generated method stub
		return userdetailRepository.Save(userId, userdetail);
	}

	@Override
	public boolean update(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return userdetailRepository.update(userDetail);
	}

	@Override
	public UserDetail userDetailfindById(int id) {
		// TODO Auto-generated method stub
		return userdetailRepository.userDetailfindById(id);
	}

	@Override
	public List<UserDetail> findUserDetails() {
		// TODO Auto-generated method stub
		return userdetailRepository.findUserDetails();
	}

	
	
	
	
}
