package com.software.biblioteka.core.service;

import com.software.biblioteka.core.domain.Uzytkownik;

public interface IUzytkownikSerwis {
	
	Uzytkownik zarejestruj(Uzytkownik uzytkownik) throws LoginJuzIstniejeException;
	Uzytkownik zaloguj(String login,String haslo);

}
