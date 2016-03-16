package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.service.IAutorSerwis;
import com.software.biblioteka.core.service.KategoriaServiceImpl;
import com.software.biblioteka.core.web.utility.JSFUtility;
//   getXxxx  - moteda odczytujaca(zwracajaca dane), setXxxx - metody ustawiajace , isXxx - metody zwracajace dla typow boolean 
@ManagedBean
@ViewScoped
public class AutorListaKontroler implements Serializable{
	
	private static final Logger logger=LoggerFactory.getLogger(AutorListaKontroler.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Autor> getLista(){
		ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IAutorSerwis serwis=ctx.getBean(IAutorSerwis.class);
		
		return serwis.znajdzWszystkie();
	}
	//Jezeli jest action to funkcja moze zwraca void lub String
	public void usunAutora(int id)
	{
		ApplicationContext ctx=FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IAutorSerwis serwis=ctx.getBean(IAutorSerwis.class);
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
	
	public void usunAutora2()
	{
		
		String parameter=JSFUtility.pobierzParametrZadania("autorID");
		if(parameter!=null)
		{
			Integer id=Integer.parseInt(parameter);
			usunAutora(id);
		}
		else
		{
			logger.error("Nie odnaleziono parametru o naziwe autorID");
		}
		
	}

}
