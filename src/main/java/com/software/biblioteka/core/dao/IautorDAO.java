package com.software.biblioteka.core.dao;

import java.util.List;

import com.software.biblioteka.core.domain.Autor;

public interface IautorDAO {

	Autor utworz(Autor autor);
	void edytuj(Autor autor);
	List<Autor> znajdzWszystkie();
	void usun(Autor autor);
	Autor znajdz(int id);
	
}
