package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Kategoria;
import com.software.biblioteka.core.service.IKategoriaSerwis;
import com.software.biblioteka.core.web.utility.JSFUtility;
@ManagedBean
@RequestScoped
public class KategoriaPodgladKontroler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Kategoria kategoria;
	@PostConstruct //ta funkcja ma sie wywolac zaraz po utworzeniu obiektu tej klasy
	public void init()
	{
		String id=JSFUtility.pobierzParametrZadania("id");
		ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IKategoriaSerwis serwis=ctx.getBean(IKategoriaSerwis.class);
		if(id!=null)
		{
			kategoria=serwis.znajdz(Integer.parseInt(id));
			if(kategoria==null){
				JSFUtility.dodajOstrzezenieGlobalne("Nie odnaleziono kategori w bazie danych");
			}
		}
		else
		{
			JSFUtility.dodajOstrzezenieGlobalne("Brak parametru id kategori");
		}
	}
	public Kategoria getKategoria() {
		return kategoria;
	}
	
}
