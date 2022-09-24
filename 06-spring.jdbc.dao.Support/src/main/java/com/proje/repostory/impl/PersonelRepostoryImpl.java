package com.proje.repostory.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.proje.model.Personel;
import com.proje.repostory.PersonelRepostory;
import com.proje.rowMapper.PersonelRowMapper;

public class PersonelRepostoryImpl extends JdbcDaoSupport implements PersonelRepostory {

	public boolean createPersonelTable() {
		// TODO Auto-generated method stub

		String sorgu = "CREATE TABLE personel(personelId INT not null,firstName VARCHAR(25),lastName VARCHAR(25),birtOfDate DATE,personelNumber Varchar(12), PRIMARY KEY(personelId))";

		try {

			this.getJdbcTemplate().execute(sorgu);

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return false;

		}
		return true;
	}

	public Personel Save(Personel personel) {
		// TODO Auto-generated method stub

		String sorgu = "INSERT INTO personel(personelId,firstName,lastName,birtOfDate,personelNumber) VALUES(?,?,?,?,?)";
		try {

			this.getJdbcTemplate().update(sorgu, new Object[] { personel.getPersonelId(), personel.getFirstName(),
					personel.getLastName(), personel.getBirtOfDate(), personel.getPersonelNumber() });
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personel;

	}

	public Personel update(Personel personel) {
		// TODO Auto-generated method stub

		String sorgu = "UPDATE  personel SET personelId=?,firstName=?,lastName=?,birtOfDate=?,personelNumber=? WHERE personelId=?";
		try {

			this.getJdbcTemplate().update(sorgu, new Object[] { personel.getPersonelId(), personel.getFirstName(),
					personel.getLastName(), personel.getBirtOfDate(), personel.getPersonelNumber() });
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personel;

	}

	public boolean deleteById(int id) {
		// TODO Auto-generated method stub

		String sorgu = "DELETE  FROM personel WHERE personelId=?";

		try {

			this.getJdbcTemplate().update(sorgu, new Object[] { id });

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return false;

		}
		return true;

	}

	public Personel findById(int id) {
		// TODO Auto-generated method stub

		String sorgu = "SELECT *  FROM personel WHERE personelId=?";

		Personel personel = null;

		try {

			personel = this.getJdbcTemplate().queryForObject(sorgu, new Object[] { id },new BeanPropertyRowMapper<>(Personel.class));

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personel;
	}

	public List<Personel> findPersonels() {
		// TODO Auto-generated method stub
		String sorgu = "SELECT *  FROM personel ";

		Personel personel = null;
		List<Personel> personels=null;

		try {

			personels = this.getJdbcTemplate().query(sorgu, new BeanPropertyRowMapper<>(Personel.class));
			
			///buşekildede kılanılabilir
			//personels = this.getJdbcTemplate().query(sorgu, new  PersonelRowMapper());

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personels;
		
	}

	public List<Personel> findPersonelsByName(String firstName) {
		// TODO Auto-generated method stub
		
		
		String sorgu = "SELECT *  FROM personel WHERE firstName=?";

		List<Personel> personels=null;

		try {

			personels = this.getJdbcTemplate().query(sorgu, new Object[] { firstName },new BeanPropertyRowMapper<>(Personel.class));

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personels;
	
	}

}
