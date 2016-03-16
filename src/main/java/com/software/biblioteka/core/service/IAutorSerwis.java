package com.software.biblioteka.core.service;

import java.util.List;

import com.software.biblioteka.core.domain.Autor;


public interface IAutorSerwis {

	Autor utworz(Autor autor);
	void edytuj(Autor autor);
	List<Autor> znajdzWszystkie();
	 boolean usun(int autor);
	Autor znajdz(int id);
	
}
