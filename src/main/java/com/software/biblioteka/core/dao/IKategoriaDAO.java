package com.software.biblioteka.core.dao;

import java.util.List;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.domain.Kategoria;

public interface IKategoriaDAO {

	Kategoria utworz(Kategoria kategoria);
	void edytuj(Kategoria kategoria);
	List<Kategoria> znajdzWszystkie();
	Kategoria znajdzByNazwa(String nazwa);
	void usun(Kategoria kategoria);
	Kategoria znajdz(int id);
}
