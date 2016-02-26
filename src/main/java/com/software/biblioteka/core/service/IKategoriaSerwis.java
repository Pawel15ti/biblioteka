package com.software.biblioteka.core.service;

import java.util.List;

import com.software.biblioteka.core.domain.Kategoria;

public interface IKategoriaSerwis {

	Kategoria utworz(Kategoria kategoria);
	void edytuj(Kategoria kategoria);
	List<Kategoria> znajdzWszystkie();
}
