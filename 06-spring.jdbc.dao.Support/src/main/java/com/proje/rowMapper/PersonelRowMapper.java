package com.proje.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.Personel;

public class PersonelRowMapper implements RowMapper<Personel> {

	@Override
	public Personel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		int personelId=rs.getInt("personelId");
        String firsName=rs.getString("firstName");
		 String lastName=rs.getString("lastName");
		 Date birthofDate=rs.getDate("birrthOfDate");
		 String personelNumber=rs.getString("personelNumber");
		
		Personel personel=new Personel(personelId,firsName,lastName,birthofDate,personelNumber);
		
		
		return personel;

	
	}
		

}
