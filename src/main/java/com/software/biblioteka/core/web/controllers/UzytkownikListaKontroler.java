package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Kategoria;
import com.software.biblioteka.core.domain.Uzytkownik;
import com.software.biblioteka.core.service.IKategoriaSerwis;
import com.software.biblioteka.core.service.IUzytkownikSerwis;
@ManagedBean
@ViewScoped
public class UzytkownikListaKontroler implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Uzytkownik> getLista(){
	ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	IUzytkownikSerwis serwis=ctx.getBean(IUzytkownikSerwis.class);
	return serwis.znajdzWszystkie();
	}
	
}
