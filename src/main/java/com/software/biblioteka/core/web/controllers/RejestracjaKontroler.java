package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Uzytkownik;
import com.software.biblioteka.core.service.IKategoriaSerwis;
import com.software.biblioteka.core.service.IUzytkownikSerwis;
import com.software.biblioteka.core.service.LoginJuzIstniejeException;
import com.software.biblioteka.core.web.utility.JSFUtility;

@ManagedBean
@ViewScoped
public class RejestracjaKontroler implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Uzytkownik uzytkownik;
	private String haslo;
	
	@PostConstruct
	public void init()
	{
		uzytkownik=new Uzytkownik();
		haslo="";
	}
	
	public String rejestruj()
	{
		if(!uzytkownik.getHaslo().equals(haslo)){
			JSFUtility.dodajBladGlobalny("Podane hasla nie sa identyczne");
			
		}
		else{
			//Pobieramy dostep do kontenera Springa(do obiektow w kontenerze )
			ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IUzytkownikSerwis serwis=ctx.getBean(IUzytkownikSerwis.class);
			try {
				serwis.zarejestruj(uzytkownik);
				JSFUtility.dodajWiadomoscGlobalna("Pomyslnie zarejestrowano użytkownika");
				init();
			} catch (LoginJuzIstniejeException e) {

				JSFUtility.dodajBladGlobalny("Login już istnieje w bazie danych");
			}
		}
			
		return null;//zwracamy albo nazwe strony do ktorej chcemy przejsc albo null aby pozostac na tej samej stronie
	}

	public Uzytkownik getUzytkownik() {
		return uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	
}
