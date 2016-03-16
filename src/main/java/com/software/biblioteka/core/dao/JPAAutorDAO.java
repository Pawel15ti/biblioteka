package com.software.biblioteka.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.software.biblioteka.core.domain.Autor;

@Repository
public class JPAAutorDAO implements IautorDAO{

	@PersistenceContext
	private EntityManager em;
	@Override
	public Autor utworz(Autor autor){
		em.persist(autor);
		return autor;
	}
	@Override
	public void edytuj (Autor autor){
		em.merge(autor);
		}
	@Override
	public List<Autor> znajdzWszystkie(){
		TypedQuery<Autor> query=em.createNamedQuery("Autor.znajdzWszystkie",Autor.class);
		return query.getResultList();
		}
	@Override
	public void usun(Autor autor) {
		
		em.remove(autor);
	}
	@Override
	public Autor znajdz(int id) {
		
		return em.find(Autor.class, id);
	}
}
