package com.software.biblioteka.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@NamedQueries({
	
	@NamedQuery(name="Autor.znajdzWszystkie",query="select a from Autor a "),

@NamedQuery(name="Autor.findByTytul",query="select a from Autor a join a.ksiazki k where k.tytul=:tytul"),
@NamedQuery(name="Autor.findByKategoriaID",query="select distinct a from Autor a join a.ksiazki k join k.kategoria g where g.id=:id")
})
@Entity
@Table(name = "Autor")
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message="Nazwa jest wymagana")
	@Size.List({
		@Size(min=5, message="Nazwa nie może mieć mniej niż {min} znaków"),
		@Size(max=20, message="Nazwa nie może mieć więcej niż {max} znaków")
	})
	private String imie;
	@NotNull(message="Nazwa jest wymagana")
	@Size.List({
		@Size(min=6, message="Nazwa nie może mieć mniej niż {min} znaków"),
		@Size(max=20, message="Nazwa nie może mieć więcej niż {max} znaków")
	})
	private String nazwisko;
	@Size.List({
		
		@Size(max=500, message="Nazwa nie może mieć więcej niż {max} znaków")
	})
	private String zyciorys;
	
	@ManyToMany(mappedBy="autorzy")
	private List<Ksiazka> ksiazki;

	public Autor() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getZyciorys() {
		return zyciorys;
	}

	public void setZyciorys(String zyciorys) {
		this.zyciorys = zyciorys;
	}

	public List<Ksiazka> getKsiazki() {
		return ksiazki;
	}

	public void setKsiazki(List<Ksiazka> ksiazki) {
		this.ksiazki = ksiazki;
	}

}
