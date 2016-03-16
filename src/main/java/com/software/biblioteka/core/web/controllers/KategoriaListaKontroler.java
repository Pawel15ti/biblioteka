package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Kategoria;
import com.software.biblioteka.core.service.IAutorSerwis;
import com.software.biblioteka.core.service.IKategoriaSerwis;
import com.software.biblioteka.core.web.utility.JSFUtility;

@ManagedBean
@ViewScoped//dopoki jestem na stronie to kontrole zyje
public class KategoriaListaKontroler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Kategoria> getLista()
	{
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IKategoriaSerwis serwis=ctx.getBean(IKategoriaSerwis.class);
		return serwis.znajdzWszystkie();
	}
	
	public void usunKategoria(int id)
	{
		ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IKategoriaSerwis serwis=ctx.getBean(IKategoriaSerwis.class);
		boolean wynik=serwis.usun(id);
		if(wynik)
		{
			JSFUtility.dodajWiadomoscGlobalna("Usunięto autora pomyślnie");
		}
		else
		{
			JSFUtility.dodajOstrzezenieGlobalne("Podany autor juz nie istnieje w systemie");
		}
	}
	
}
