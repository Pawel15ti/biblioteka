package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.software.biblioteka.core.domain.Autor;
import com.software.biblioteka.core.service.IAutorSerwis;

@ManagedBean
@ViewScoped
public class AutorUtworzKontroler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Autor autor;

	@PostConstruct
	public void init() {
		autor = new Autor();
	}

	public String utworzAkcja()
	{
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IAutorSerwis serwis=ctx.getBean(IAutorSerwis.class);
		serwis.utworz(autor);
		
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,"Utworzono autora pomyslnie", "Utworzono autora");
		FacesContext jsfCtx=FacesContext.getCurrentInstance();
		jsfCtx.addMessage(null, msg);
		
		init();
		
		return null;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
