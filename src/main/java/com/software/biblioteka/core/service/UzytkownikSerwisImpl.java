package com.software.biblioteka.core.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.biblioteka.core.dao.IUzytkownikDAO;
import com.software.biblioteka.core.domain.Uzytkownik;

@Service

public class UzytkownikSerwisImpl implements IUzytkownikSerwis{

	private static final Logger logger=LoggerFactory.getLogger(UzytkownikSerwisImpl.class);
	@Autowired
	private IUzytkownikDAO dao;
	
	@Override
	@Transactional
	public Uzytkownik zarejestruj(Uzytkownik uzytkownik) throws LoginJuzIstniejeException {
		
		
		Uzytkownik u=dao.znajdz(uzytkownik.getLogin());
		if(u!=null){
			throw new LoginJuzIstniejeException("Login taki juz istnieje w bazie danych");
			
		}
		
		//Karol12345678   ->mmmielko87654321 
		String shaszowaneHaslo=DigestUtils.sha512Hex(uzytkownik.getLogin()+uzytkownik.getHaslo());
		//String shaszowaneHaslo=DigestUtils.sha512Hex(uzytkownik.getHaslo()); //zle podejscie bo mozna skopiowac haslo
		uzytkownik.setHaslo(shaszowaneHaslo);
		
		return dao.utworz(uzytkownik);
		
	}

	@Override
	@Transactional(readOnly=true) ///login=Karol, haslo=87654321 -> Karol87654321
	public Uzytkownik zaloguj(String login, String haslo) {
		String shaszowanehaslo=DigestUtils.sha512Hex(login+haslo);
		//String shaszowanehaslo=DigestUtils.sha512Hex(haslo); //zle podejscie bo mozna skopiowac haslo
		return dao.znajdz(login, shaszowanehaslo);
		
	
	}

	@Override
	@Transactional
	public List<Uzytkownik> znajdzWszystkie() {

		return dao.znajdzWszystkie();
	}

}
