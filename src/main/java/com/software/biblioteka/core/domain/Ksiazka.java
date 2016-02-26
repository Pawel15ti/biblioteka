package com.software.biblioteka.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//zapisanie zapytan dotyczacych danej encji 
@NamedQueries({
	@NamedQuery(name="Ksiazka.findByOpis",query="select k from Ksiazka k where k.opis=:opis"),//reprezentuje jedno zapytanie; :opis - nazwa parametru
	@NamedQuery(name="Ksiazka.findByKategoria",query="select k from Ksiazka k where k.kategoria=:kategoria"),
	@NamedQuery(name="Ksiazka.findByKategoriaID",query="select k from Ksiazka k join k.kategoria o where o.id=:id"),
	@NamedQuery(name="Ksiazka.findByAutorID",query="select k from Ksiazka k join k.autorzy a where a.id=:id"),
	@NamedQuery(name="Ksiazka.findCount",query="select Count(k) from Ksiazka k ")
})

@Entity
@Table(name="KSIAZKA")
public class Ksiazka implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length=13, columnDefinition="char(13)")
	private String isbn;
	@Column(name="liczba_stron",nullable=false)
	private Short liczbaStron;
	@Column(length=50)
	private String tytul;
	@Column(length=200)
	private String opis;
	@ManyToOne(fetch=FetchType.EAGER)
	//FetchType.EAGER - automatycznie przy pobieraniu ksiazki zostana pobrane informacje o Kategori
	@JoinColumn(name="kategoria_id")
	private Kategoria kategoria;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	//FetchType.LAZY - ta kolekcja domyslnie nie jest pobierana z bazy danych jak pobiera sie ksiazke
	@JoinTable(joinColumns=@JoinColumn(name="ksiazka_id"),inverseJoinColumns=@JoinColumn(name="autor_id"), name="ksiazka_autor")
	private List<Autor> autorzy;
	
	public Ksiazka() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Ksiazka [isbn=" + isbn + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ksiazka other = (Ksiazka) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}



	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Short getLiczbaStron() {
		return liczbaStron;
	}
	public void setLiczbaStron(Short liczbaStron) {
		this.liczbaStron = liczbaStron;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Kategoria getKategoria() {
		return kategoria;
	}
	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}



	public List<Autor> getAutorzy() {
		return autorzy;
	}



	public void setAutorzy(List<Autor> autorzy) {
		this.autorzy = autorzy;
	}
	

}
