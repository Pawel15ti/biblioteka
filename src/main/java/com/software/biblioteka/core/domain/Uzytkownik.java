package com.software.biblioteka.core.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
@NamedQueries({
	@NamedQuery(name="Uzytkownik.znajdzWszystkie",query="select u from Uzytkownik u"),
	@NamedQuery(name="Uzytkownik.znajdzPoLoginieiHasle",query="select u from Uzytkownik u where u.login=:login and u.haslo=:haslo"),
	@NamedQuery(name="Uzytkownik.znajdzPoLoginie",query="select u from Uzytkownik u where u.login=:login")
})
@Entity
@Table(name="Uzytkownicy")
public class Uzytkownik implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message="imie jest wymagana")
	@Size.List({
		@Size(min=2, message="imie nie może mieć mniej niż {min} znaków"),
		@Size(max=20, message="imie nie może mieć więcej niż {max} znaków")
	})
	private String imie;
	@NotNull(message="nazwisko jest wymagane")
	@Size.List({
		@Size(min=3, message="nazwisko nie moze miec mniej niz {min} znaków"),
		@Size(max =30, message="nazwisko nie może mieć więcej niż {max} znaków")
	})
	private String nazwisko;
	//private String typ;
	@NotNull(message="login jest wymagany")
	@Size.List({
		@Size(min=5, message="login nie moze mieć mniej niż {min} znaków"),
		@Size(max=10,message="login nie moze byc wiekszy niz {max} znaków")
	})
	private String login;
	@NotNull(message="haslo jest wymagany")
	@Size.List({
		@Size(min=8, message="haslo nie moze mieć mniej niż {min} znaków"),
		@Size(max=256)
		
	})
	private String haslo;
	
	@NotNull(message="email jest wymagany")
	@Email(message="Wprowadz poprawny adres email")
	@Size(min=1, message="email jest wymagany")
	private String mail;
	
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
		Uzytkownik other = (Uzytkownik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Uzytkownik() {
		super();
	}
	@Override
	public String toString() {
		return "Uzytkownik [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + "]";
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
