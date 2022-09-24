package com.proje.repostory.impl;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.proje.model.Personel;
import com.proje.repostory.PersonelRepostory;
import com.proje.rowMapper.PersonelRowMapper;


public class PersonelRepostoryImpl extends NamedParameterJdbcDaoSupport  implements PersonelRepostory {

	
	//private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	/*public boolean createPersonelTable() {
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
	}*/

	public Personel Save(Personel personel) {
		// TODO Auto-generated method stub

		String sorgu = "INSERT INTO personel(personelId,firstName,lastName,birtOfDate,personelNumber) VALUES(:personelId,:firstName,:lastName,:birtOfDate,:personelNumber)";
		try {
			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",personel.getPersonelId())
					.addValue("firstName", personel.getFirstName())
					.addValue("lastName", personel.getLastName())
					.addValue("birtOfDate", personel.getBirtOfDate())
					.addValue("personelNumber", personel.getPersonelNumber());

			this.getNamedParameterJdbcTemplate().update(sorgu, sqlParameterSource);
					
		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personel;

	}

	public Personel update(Personel personel) {
		// TODO Auto-generated method stub

		String sorgu = "UPDATE  personel SET personelId=:personelId,firstName=:firstName,lastName=:lastName,birtOfDate=:birtOfDate,personelNumber=:personelNumber WHERE personelId=:personelId";
		try {

			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",personel.getPersonelId())
					.addValue("firstName", personel.getFirstName())
					.addValue("lastName", personel.getLastName())
					.addValue("birtOfDate", personel.getBirtOfDate())
					.addValue("personelNumber", personel.getPersonelNumber());

			this.getNamedParameterJdbcTemplate().update(sorgu, sqlParameterSource);
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

			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",id);
				

			this.getNamedParameterJdbcTemplate().update(sorgu, sqlParameterSource);

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

			SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",id);
			

			this.getNamedParameterJdbcTemplate().queryForObject(sorgu, sqlParameterSource,new PersonelRowMapper());
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

			personels =this.getNamedParameterJdbcTemplate().query(sorgu, new PersonelRowMapper());
			
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
		
		
		String sorgu = "SELECT *  FROM personel WHERE firstName=:firstName";

		List<Personel> personels=null;

		try {

			 SqlParameterSource sqlParameterSource=new MapSqlParameterSource("personelId",firstName);
			

			 personels =	this.getNamedParameterJdbcTemplate().query(sorgu, sqlParameterSource,new PersonelRowMapper());

		} catch (RuntimeException e) {
			// TODO: handle exception

			System.out.println("HATA" + e);
			return null;

		}
		return personels;
	
	}
	
	/*@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		
	} */

	public boolean createPersonelTable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
