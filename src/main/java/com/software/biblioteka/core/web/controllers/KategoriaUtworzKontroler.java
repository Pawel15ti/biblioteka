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
import com.software.biblioteka.core.service.NazwaKategoriJuzIstniejeException;
import com.software.biblioteka.core.web.utility.JSFUtility;
//Fazy JSF
//W pierwszej fazie zadania JSF konwertuje  wpisane wartosc prez uzytkownika
//w drugiej fazie zadania JSF waliduje wpisane wartosc 
//w trzecie fazie wywoluje akcje jesli nie ma bledow walidacji i konwersji
@ManagedBean //kontroler JSF
@ViewScoped //zasieg widoku - do poki jestemy na stronie to kontroler zapamietuje swoj stan a po wyjsciu z tej strony kontoler zostaje usuniety z pamieci
public class KategoriaUtworzKontroler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kategoria kategoria;
	private Integer pole;
	
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
		try {
			serwis.utworz(kategoria);//jesli tutaj wyjatek wyskoczy to odrazu idziemy do catch
			JSFUtility.dodajWiadomoscGlobalna("Utworzono kategorie pomyslnie");
			//czyscimy obiekt kategori tworzac nowy
			init();
		} catch (NazwaKategoriJuzIstniejeException e) {
			
			JSFUtility.dodajBladGlobalny(e.getMessage());
			
		}
		
		//return null - oznacza pozostan na tejk stronie
		return null;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public Integer getPole() {
		return pole;
	}

	public void setPole(Integer pole) {
		this.pole = pole;
	}
	
	
	
}
