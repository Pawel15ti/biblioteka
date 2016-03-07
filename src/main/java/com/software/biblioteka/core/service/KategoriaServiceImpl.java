package com.software.biblioteka.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.biblioteka.core.dao.IKategoriaDAO;
import com.software.biblioteka.core.domain.Kategoria;

@Service //Spring utworzy jeden obiekt tej klasy w kontenere
//@Transactional - jesli odkomentowane to wsyztskie metody publiczne tej klasy beda wykonywane w ramach transakcji
public class KategoriaServiceImpl implements IKategoriaSerwis{

	//Utworzenie dziennika zdarzen dla klasy KategoriaServiceImpl
	private static final Logger logger=LoggerFactory.getLogger(KategoriaServiceImpl.class);
	
	@Autowired //wstrzyknij tutaj obiekt klasy ktora implementuje ten interfejs i jest w kontenerze springa
	private IKategoriaDAO dao;
	//@Autowired
	//private IZdarzenieDAO zdarzenieDao;
	
	@Override
	@Transactional //ta m,etoda bedzie wykonywana w ramach transakcji na bazie danych
	public Kategoria utworz(Kategoria kategoria) {
		//ERROR,WARN,INFO,DEBUG,TRACE
		logger.info("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.warn("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.error("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.debug("Tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.trace("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		
		//daoAutor.update()
		//daoKsiakza.delete()
		Kategoria nowaKategoria=dao.utworz(kategoria);
		logger.debug("Utworzono nowa kategorie {}",kategoria);
		//logger.debug("Witaj A {} B {}",kategoria.getId(),kategoria.getNazwa());
		return nowaKategoria;
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
