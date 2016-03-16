package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.service.IAutorSerwis;
import com.software.biblioteka.core.web.utility.JSFUtility;

@ManagedBean
@ViewScoped
public class AutorEdycjaKontroler implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Autor autor;
	
	@PostConstruct //ta funkcja ma sie wywolac zaraz po utworzeniu obiektu tej klasy
	public void init()
	{
		String id=JSFUtility.pobierzParametrZadania("id");
		ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IAutorSerwis serwis=ctx.getBean(IAutorSerwis.class);
		if(id!=null)
		{
			autor=serwis.znajdz(Integer.parseInt(id));
			if(autor==null){
				JSFUtility.dodajOstrzezenieGlobalne("Nie odnaleziono autora w bazie danych");
			}
		}
		else
		{
			JSFUtility.dodajOstrzezenieGlobalne("Brak parametru id autora");
		}
	}
	
	public String zapiszZmiany()
	{
		if(autor!=null){
			ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IAutorSerwis serwis=ctx.getBean(IAutorSerwis.class);
			serwis.edytuj(autor);
			JSFUtility.dodajWiadomoscGlobalna("Zapisano zmiany");
		}
		
		return null;
	}

	public Autor getAutor() {
		return autor;
	}
	

}
