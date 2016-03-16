package com.software.biblioteka.core.dao;

import com.software.biblioteka.core.domain.Uzytkownik;

public interface IUzytkownikDAO {
	
	Uzytkownik utworz(Uzytkownik uzytkownik);
	Uzytkownik znajdz(String login,String haslo);
	Uzytkownik znajdz(String login);

}
