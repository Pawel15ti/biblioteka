package com.software.biblioteka.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.biblioteka.core.dao.IautorDAO;
import com.software.biblioteka.core.domain.Autor;

@Service
public class AutorServiceImpl implements IAutorSerwis{
	
	private static final Logger logger=LoggerFactory.getLogger(AutorServiceImpl.class);
	
	@Autowired
	private IautorDAO dao;

	@Override
	@Transactional
	public Autor utworz(Autor autor) {
		return dao.utworz(autor);
	}

	@Override
	@Transactional
	public void edytuj(Autor autor) {
		dao.edytuj(autor);
	}

	@Override
	@Transactional(readOnly=true)//readyOnly=true - w momencie kiedy tylko odczytujemy
	public List<Autor> znajdzWszystkie() {
		return dao.znajdzWszystkie();
	}

	@Override
	@Transactional
	public boolean usun(int id) {
		logger.debug("Szukam autora o id {}",id);
		Autor autor=dao.znajdz(id);
	
		if(autor!=null){
			logger.debug("Usuwam autora z bazy danycg");
			dao.usun(autor);
			return true;
		} else
		{
			logger.warn("Nie odnaleziono autora o id {}",id);
			return false;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Autor znajdz(int id) {
		return dao.znajdz(id);
		
	}

	
	
}
