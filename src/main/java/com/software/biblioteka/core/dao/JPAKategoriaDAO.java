package com.software.biblioteka.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.domain.Kategoria;

@Repository //utworz obiekt tylko jeden tej klasy w konterze springa
public class JPAKategoriaDAO implements IKategoriaDAO{

	@PersistenceContext//wstrzykuje automatycznie nowy obiekt EntitytManagera
	private EntityManager em;
	
	@Override
	public Kategoria utworz(Kategoria ksiazka) {
		
		em.persist(ksiazka);
		return ksiazka;
	}

	@Override
	public void edytuj(Kategoria ksiazka) {
		
		em.merge(ksiazka);
	}

	@Override
	public List<Kategoria> znajdzWszystkie() {
		
		TypedQuery<Kategoria> query=em.createNamedQuery("Kategoria.znajdzWszystkie",Kategoria.class);
		return query.getResultList();
	}

	@Override
	public Kategoria znajdzByNazwa(String nazwa) {
		TypedQuery<Kategoria> query=em.createNamedQuery("Kategoria.findByNazwa",Kategoria.class);
		query.setParameter("nazwa", nazwa);
		//query.getSingleResult(); zwraca pojedynczy obiekt ale jesli nie ma obiektu to wyrzuca wyjatek
		//query.getResultList(); zwraca liste , jesli nie ma wynikow to zwraca pusta liste
		
		List<Kategoria> kategorie=query.getResultList();
		if(kategorie.isEmpty())
			return null;
		else
			return kategorie.get(0);
	}

	@Override
	public void usun(Kategoria kategoria) {
		em.remove(kategoria);
		
	}

	@Override
	public Kategoria znajdz(int id) {
		return em.find(Kategoria.class, id);
	}

	
}
