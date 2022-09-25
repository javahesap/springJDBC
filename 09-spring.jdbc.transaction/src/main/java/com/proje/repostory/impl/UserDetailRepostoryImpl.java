package com.proje.repostory.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.proje.model.UserDetail;
import com.proje.repostory.UserDetailRepostory;

public class UserDetailRepostoryImpl extends NamedParameterJdbcDaoSupport implements UserDetailRepostory{

	public boolean Save(int userId, UserDetail userdetail) {
		// TODO Auto-generated method stub
		
		
		String querySaveUserDetail="INSERT INTO  userdetail(userDetailId, firstName, lastName, birtOfDate) values(:userDetailId, :firstName, :lastName, :birtOfDate)";
		String queryUpdateUser="update user SET userDetailId=:userDetailId where userId:userId";
		
		
		
		try {
			SqlParameterSource source=new MapSqlParameterSource("userDetailId",userdetail.getUserDetailId())
					.addValue("firstName",userdetail.getFirstName())
					.addValue("lastName", userdetail.getLastName())
					.addValue("birtOfDate", userdetail.getBirthDate());
					
			this.getNamedParameterJdbcTemplate().update(querySaveUserDetail, source);
			
			
			SqlParameterSource sourceupdateser=new MapSqlParameterSource("userDetailId",userdetail.getUserDetailId());
			this.getNamedParameterJdbcTemplate().update(queryUpdateUser, sourceupdateser);
			
					
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return false;

		}
		return true;
		

	}

	public boolean update(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDetail userDetailfindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDetail> findUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
