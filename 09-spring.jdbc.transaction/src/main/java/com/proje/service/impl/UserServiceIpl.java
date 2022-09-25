package com.proje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.User;
import com.proje.repostory.UserRepostory;
import com.proje.service.UserService;


@Service
public class UserServiceIpl implements UserService {

	@Autowired
	private UserRepostory userRepostory;

	@Override
	public boolean Save(User user) {
		// TODO Auto-generated method stub

		boolean durum = this.userRepostory.Save(user);

		// TODO Auto-generated method stub
		return durum;

	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		
		
		return this.userRepostory.update(user);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return this.deleteById(id);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	@Override
	public User findWidthUserDetailById(int id) {
		// TODO Auto-generated method stub
		return this.userRepostory.findWidthUserDetailById(id);
	}

	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return this.userRepostory.findUsers();
	}

}
