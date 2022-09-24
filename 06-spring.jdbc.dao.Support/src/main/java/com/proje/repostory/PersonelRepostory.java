package com.proje.repostory;

import java.util.List;

import com.proje.model.Personel;

public interface PersonelRepostory {
	boolean createPersonelTable();
	Personel Save(Personel personel);
	Personel update(Personel personel);
	boolean deleteById(int id);
	Personel findById(int id);
	List<Personel> findPersonels();
	List<Personel> findPersonelsByName(String firstName);

}
