package com.software.biblioteka.core.service;

import java.util.List;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.domain.Kategoria;

public interface IKategoriaSerwis {
	/**
	 * Funkcja tworzy kategorie w systemie
	 * @param kategoria
	 * @return
	 * @throws NazwaKategoriJuzIstniejeException wyrzucany w przypadku gdy juz taka kategoria o tej nazwie istnieje w systemie
	 */
	Kategoria utworz(Kategoria kategoria) throws NazwaKategoriJuzIstniejeException;
	void edytuj(Kategoria kategoria) throws NazwaKategoriJuzIstniejeException;
	List<Kategoria> znajdzWszystkie();
	 boolean usun(int kategoria);
		Kategoria znajdz(int id);
}
