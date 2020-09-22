package com.boris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Indirizzo")
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indirizzo_generator")
	@SequenceGenerator(name = "indirizzo_generator", sequenceName = "indirizzo_seq", allocationSize = 1)
	@Column(name="id_indirizzo")
	private long id;
	
	@Column(name = "via", nullable = false)
	private String via;
	
	@Column(name = "cap", nullable = false)
	private String cap;
	
	@Column(name = "citta", nullable = false)
	private String citta;
	
	@Column(name = "provincia", nullable = false)
	private String provincia;

	public Indirizzo(String via, String cap, String citta, String provincia) {
		super();
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
	}

	public Indirizzo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
	
}
