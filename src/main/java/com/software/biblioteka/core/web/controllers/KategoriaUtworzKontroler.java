package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Kategoria;
import com.software.biblioteka.core.service.IKategoriaSerwis;

@ManagedBean //kontroler JSF
@ViewScoped //zasieg widoku - do poki jestemy na stronie to kontroler zapamietuje swoj stan a po wyjsciu z tej strony kontoler zostaje usuniety z pamieci
public class KategoriaUtworzKontroler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kategoria kategoria;
	
	@PostConstruct //ta metoda ma sie wykonac zaraz po utworzeniu tej klasy()
	public void init()
	{
		kategoria=new Kategoria();
	}
	
	public String utworzAkcja()
	{
		//Specjalny kod springa ktory zwraca dostep do kontenera springa
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		//pobieramy sobie klase implementujaca serwis IKategoriaSerwis
		IKategoriaSerwis serwis=ctx.getBean(IKategoriaSerwis.class);
		//wywolujemy metode biznesowa utworzenia kategori
		serwis.utworz(kategoria);
		//tworzymy wiadomosc typu info 
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Utworzono kategorie pomyslnie", "Utworzono kategorie pomyslnie");
		//pobieramy kontekst JSF
		FacesContext jsfCtx=  FacesContext.getCurrentInstance();
		//dodajemy wiadomosc dla kontekstu JSF do strony(globalna poniewaz pierwszy arg jest null)
		jsfCtx.addMessage(null, msg);
		
		//czyscimy obiekt kategori tworzac nowy
		init();
		//return null - oznacza pozostan na tejk stronie
		return null;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}
	
	
	
}
