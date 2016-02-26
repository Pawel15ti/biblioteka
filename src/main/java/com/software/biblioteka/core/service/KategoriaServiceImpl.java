package com.software.biblioteka.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.biblioteka.core.dao.IKategoriaDAO;
import com.software.biblioteka.core.domain.Kategoria;

@Service //Spring utworzy jeden obiekt tej klasy w kontenere
//@Transactional - jesli odkomentowane to wsyztskie metody publiczne tej klasy beda wykonywane w ramach transakcji
public class KategoriaServiceImpl implements IKategoriaSerwis{

	@Autowired //wstrzyknij tutaj obiekt klasy ktora implementuje ten interfejs i jest w kontenerze springa
	private IKategoriaDAO dao;
	//@Autowired
	//private IZdarzenieDAO zdarzenieDao;
	
	@Override
	@Transactional //ta m,etoda bedzie wykonywana w ramach transakcji na bazie danych
	public Kategoria utworz(Kategoria kategoria) {
		
		//daoAutor.update()
		//daoKsiakza.delete()
		
		return dao.utworz(kategoria);
	}

	@Override
	@Transactional
	public void edytuj(Kategoria kategoria) {
		
		dao.edytuj(kategoria);
		//zdArzenieDao.zapiszZdarzenie(new Zdarzenie("Zapisano zmiany dla kateogir o id =1"));
	}

	@Override
	@Transactional
	public List<Kategoria> znajdzWszystkie() {
		
		return dao.znajdzWszystkie();
	}

}
