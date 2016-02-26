package com.software.biblioteka.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="KATEGORIA")

@NamedQueries({
	@NamedQuery(name="Kategoria.znajdzWszystkie" , query="select k from Kategoria k")
})
public class Kategoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id//wskazuje ktore pole jest kluczem podstawowym
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="kategoria_id")
	private Integer id;
	
	@Column(length=20, nullable=false)
	private String nazwa;
	
	@OneToMany(mappedBy="kategoria", cascade=CascadeType.REMOVE)
	//jesli kategoria zostanie suuanieta to wszytskie jej ksiazki tez
	private List<Ksiazka> ksiazki;
	
	public Kategoria() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Kategoria [id=" + id + "]";
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
		Kategoria other = (Kategoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
