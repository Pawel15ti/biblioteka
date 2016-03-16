package com.software.biblioteka.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.software.biblioteka.core.domain.Uzytkownik;

@Repository
public class JPAUzytkownikDAO implements IUzytkownikDAO{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Uzytkownik utworz(Uzytkownik uzytkownik) {
		em.persist(uzytkownik);
		return uzytkownik;
	}

	@Override
	public Uzytkownik znajdz(String login, String haslo) {
		TypedQuery<Uzytkownik> query=em.createNamedQuery("Uzytkownik.znajdzPoLoginieiHasle",Uzytkownik.class);
		query.setParameter("login", login);
		query.setParameter("haslo", haslo);
		List<Uzytkownik> wyniki=query.getResultList();
		if(wyniki.isEmpty())
		{
			return null;
		}
		else {
			return wyniki.get(0);
		}
		
	}

	@Override
	public Uzytkownik znajdz(String login) {
		
		
		TypedQuery<Uzytkownik> query=em.createNamedQuery("Uzytkownik.znajdzPoLoginie",Uzytkownik.class);
		query.setParameter("login", login);
		
		List<Uzytkownik> wyniki=query.getResultList();
		if(wyniki.isEmpty())
		{
			return null;
		}
		else {
			return wyniki.get(0);
		}
		
	}

}
