package com.software.biblioteka.core.web.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.software.biblioteka.core.domain.Uzytkownik;

@ManagedBean
@SessionScoped//ten kontrole bedzie zyl az do mkomemntu wylogowania sie uzytkownika lub az mu sesja nie wygasnie
public class SesjaUzytkownikaKontroler implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Uzytkownik zalogowany;

	public Uzytkownik getZalogowany() {
		return zalogowany;
	}

	public void setZalogowany(Uzytkownik zalogowany) {
		this.zalogowany = zalogowany;
	}
}
