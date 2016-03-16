package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Uzytkownik;
import com.software.biblioteka.core.service.IKategoriaSerwis;
import com.software.biblioteka.core.service.IUzytkownikSerwis;
import com.software.biblioteka.core.web.utility.JSFUtility;

@ManagedBean
@RequestScoped
public class ZalogujKontroler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String haslo;
	
	@ManagedProperty(value="#{sesjaUzytkownikaKontroler}")//JSF wstrzyknie kontroler SesjaUzytkownikaKontroler
	private SesjaUzytkownikaKontroler sesja;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	public String zaloguj(){
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IUzytkownikSerwis serwis=ctx.getBean(IUzytkownikSerwis.class);
		Uzytkownik u=serwis.zaloguj(login, haslo);
		if(u==null){
			JSFUtility.dodajBladGlobalny("Wprowadziles bledny login lub haslo");
			return null;
		}
		else{
			sesja.setZalogowany(u);
			return "index";
		}
		
	}
	public SesjaUzytkownikaKontroler getSesja() {
		return sesja;
	}
	public void setSesja(SesjaUzytkownikaKontroler sesja) {
		this.sesja = sesja;
	}
	
	
}
