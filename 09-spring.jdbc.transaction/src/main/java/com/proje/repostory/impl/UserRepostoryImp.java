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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.repostory.UserRepostory;

import com.proje.rowmapper.UserRowMapper;
@Transactional
public class UserRepostoryImp  extends NamedParameterJdbcDaoSupport implements UserRepostory{
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation =Propagation.REQUIRED , timeout = 3, rollbackFor =RuntimeException.class)
	public boolean Save(User user) {
		// TODO Auto-generated method stub
		
		String query="INSERT INTO user (userId, userName, password, creationDate) VALUES (:userId, :userName, :password, :creationDate)";
		
		
		try {
			SqlParameterSource source=new MapSqlParameterSource("userId",user.getUserId())
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
		
		
		
		String queryDinderUser="select * from user where userId=:userId";
		String queryDeleteUser="delete from user where userId=:userId";
		String queryDeleteuserDetail="delete * from userdetail where userDetailId=:userDetailId";
		  
		
		try {
			SqlParameterSource sourceFinUser=new MapSqlParameterSource("userId",id);
		Integer userDetailId=	this.getNamedParameterJdbcTemplate().query(queryDinderUser, sourceFinUser,new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					
					Integer userDetailId=rs.getInt("userDetailId");
					return userDetailId;
				}
				
				
				
			});
			
		SqlParameterSource sourceDeleteUser=new MapSqlParameterSource("userId",id);
		this.getNamedParameterJdbcTemplate().update(queryDeleteUser, sourceDeleteUser);
		
		SqlParameterSource sourceDeleteUserdetail=new MapSqlParameterSource("userDetailId",userDetailId.intValue());
		this.getNamedParameterJdbcTemplate().update(queryDeleteuserDetail, sourceDeleteUserdetail);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		return false;
	}
	@Transactional(readOnly=true)
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
	@Transactional(readOnly=true)
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
