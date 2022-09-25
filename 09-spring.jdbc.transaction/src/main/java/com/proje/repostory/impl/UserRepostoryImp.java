package com.proje.repostory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.repostory.UserRepostory;

import com.proje.rowmapper.UserRowMapper;

public class UserRepostoryImp  extends NamedParameterJdbcDaoSupport implements UserRepostory{

	public boolean Save(User user) {
		// TODO Auto-generated method stub
		
		String query="INSERT INTO user (userId, userName, password, creationDate) VALUES (:userId, :userName, :password, :creationDate)";
		
		
		try {
			SqlParameterSource source=new MapSqlParameterSource("personelId",user.getUserId())
					.addValue("userName", user.getUsername())
					.addValue("password", user.getPassword())
					.addValue("creationDate", user.getCreationDate());
					
			this.getNamedParameterJdbcTemplate().update(query, source);
					
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return false;

		}
		return true;
		
		
	}

	public boolean update(User user) {
		String sorgu = "UPDATE  user SET   userName=:userName, password=:password, creationDate=:creationDate, u WHERE userId=:userId";

		try {
			SqlParameterSource source=new MapSqlParameterSource("personelId",user.getUserId())
					.addValue("userName", user.getUsername())
					.addValue("password", user.getPassword())
					.addValue("creationDate", user.getCreationDate());
					
			this.getNamedParameterJdbcTemplate().update(sorgu, source);
					
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return false;

		}
		return true;
	}

	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		
		
		
		String sorgu = "SELECT *  FROM user WHERE userId=:userId";

		User user = null;

		try {

			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",id);
			

			this.getNamedParameterJdbcTemplate().queryForObject(sorgu, sqlParameterSource, new UserRowMapper());
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return user;

		
	}

	public User findWidthUserDetailById(int id) {
		// TODO Auto-generated method stub
		
		String sorgu = "SELECT *  FROM user  u left jion userdetail ud on(u.userdetailId=ud.userdetailId)  WHERE u.userId=:userId";
		
		User user = null;

		try {

			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",id);
			

			user=this.getNamedParameterJdbcTemplate().query(sorgu, sqlParameterSource, new  ResultSetExtractor<User>() {

				public User extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					User user = null;
					UserDetail userdetail=null;
					
					if(rs.next()) {
					     int userId= rs.getInt("userId");
						String username=rs.getString("username");
						 String password=rs.getString("password");
				         Date creationDate=rs.getDate("creationDate");
				         int userdetailId= rs.getInt("userdetailId");
				     	String firstName=rs.getString("firstName");
				    	String lastName=rs.getString("lastName");
				    	Date birdOfDate=rs.getDate("birdOfDate");
				    	
					 new UserDetail(userdetailId, firstName, lastName, birdOfDate);
					 new UserDetail(userdetailId, firstName, lastName, birdOfDate);
					 user.setUserdetail(userdetail);
					
				}
					return user;
				}
				
			});
			
			
			
			
			
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return user;
		
	
	}

	public List<User> findUsers() {
		// TODO Auto-generated method stub
		
		
		
		
		String sorgu = "SELECT *  FROM user ";

		List<User> user = null;

		try {

	
			

			this.getNamedParameterJdbcTemplate().query(sorgu, new UserRowMapper());
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return user;
		

	}

}
