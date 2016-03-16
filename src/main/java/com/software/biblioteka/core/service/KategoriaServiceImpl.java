package com.software.biblioteka.core.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.biblioteka.core.dao.IKategoriaDAO;
import com.software.biblioteka.core.domain.Autor;
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
	
	@PostConstruct
	public void init()
	{
		//tutaj jezeli chcemy odwol;ac sie do dao to juz jest dostepne
	}
	
	@Override
	@Transactional //ta m,etoda bedzie wykonywana w ramach transakcji na bazie danych
	public Kategoria utworz(Kategoria kategoria) throws NazwaKategoriJuzIstniejeException {
		//ERROR,WARN,INFO,DEBUG,TRACE
		logger.info("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.warn("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.error("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.debug("Tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		logger.trace("tworze nowa kategorie o nazwie {}",kategoria.getNazwa());
		
		logger.debug("Sprawdzam czy istnieje kategoria o nazwie {} w bazie danych",kategoria.getNazwa());
		Kategoria kat=dao.znajdzByNazwa(kategoria.getNazwa());
		
		if(kat!=null)
		{
			logger.debug("Kategoria o takiej nazwie juz istnieje, przerywam dzialanie funkcji utworz");
			throw new NazwaKategoriJuzIstniejeException("Kategoria o takiej nazwie juz istnieje w bazie danych");//w tym miejscu funkcja przerywa swoje dzialanie a wyjaek jest przerzucany wyrzej
		}
		logger.debug("Brak kategori o takiej nazwie wywoluje tworzenie na bazie");
		//daoAutor.update()
		//daoKsiakza.delete()
		Kategoria nowaKategoria=dao.utworz(kategoria);
		logger.debug("Utworzono nowa kategorie {}",kategoria);
		//logger.debug("Witaj A {} B {}",kategoria.getId(),kategoria.getNazwa());
		return nowaKategoria;
	}
	//Kategoria(1,'dramat'), Kategoria(3,'dramat3') DB ;  Kategoria(1,'dramat3'); 
	@Override
	@Transactional
	public void edytuj(Kategoria kategoria) throws NazwaKategoriJuzIstniejeException {
		Kategoria kat=dao.znajdzByNazwa(kategoria.getNazwa());
		if(kat!=null)
		{
			if(!kategoria.equals(kat))//kategoria z bazy nie jest ta samo kategoria co edytowana
				throw new NazwaKategoriJuzIstniejeException("Kategoria o takiej nazwie juz istnieje w bazie");
		}
		
		
		dao.edytuj(kategoria);
		//zdArzenieDao.zapiszZdarzenie(new Zdarzenie("Zapisano zmiany dla kateogir o id =1"));
	}

	@Override
	@Transactional
	public List<Kategoria> znajdzWszystkie() {
		
		return dao.znajdzWszystkie();
	}

	@Override
	@Transactional
	public boolean usun(int id) {
		logger.debug("Szukam kategori o id {}",id);
		Kategoria kategoria=dao.znajdz(id);
	
		if(kategoria!=null){
			logger.debug("Usuwam autora z bazy danycg");
			dao.usun(kategoria);
			return true;
		} else
		{
			logger.warn("Nie odnaleziono autora o id {}",id);
			return false;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Kategoria znajdz(int id) {
		return dao.znajdz(id);
	}

}
