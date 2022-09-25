package com.proje.repostory.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proje.model.UserDetail;
import com.proje.repostory.UserDetailRepostory;
@Transactional
public class UserDetailRepostoryImpl extends NamedParameterJdbcDaoSupport implements UserDetailRepostory{

	
	
	@Override
	
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
		
		
String querySaveUserDetail="UPDATE userdetail SET firstName:firstName, lastName:lastName, birtOfDate:birtOfDate "
		                    + "where userDetailId=:userDetailId ";	
		
		SqlParameterSource source =new MapSqlParameterSource("firstName",userDetail.getFirstName())
		                                .addValue("lastName", userDetail.getLastName())
		                                .addValue("birtofdate", userDetail.getBirthDate())
		                                .addValue("userDetailId", userDetail.getUserDetailId());
		this.getNamedParameterJdbcTemplate().update(querySaveUserDetail, source);
		
		
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
		
		
		System.out.println("HATA" + e);
		return false;
	}
		
			
		
		return true;
	}

	public UserDetail userDetailfindById(int id) {
		// TODO Auto-generated method stub
		
		String query="select * from userdetail where userDetailId=:userDetailId";
		UserDetail userDetail=null;
		try {
			
			userDetail =this.getNamedParameterJdbcTemplate().queryForObject(query, new MapSqlParameterSource("userDetail",id), new BeanPropertyRowMapper<>(UserDetail.class));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return userDetail;
	}
	
	public List<UserDetail> findUserDetails() {
		// TODO Auto-generated method stub
		
		String query="select * from userdetail ";
	List<UserDetail> userDetails=null;
		try {
			
			userDetails=	this.getNamedParameterJdbcTemplate().query(query, new BeanPropertyRowMapper<>(UserDetail.class));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return userDetails;
		
		
		
	
	}

}
