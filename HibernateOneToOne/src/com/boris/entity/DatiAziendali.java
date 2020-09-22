package com.boris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DatiAziendali")
public class DatiAziendali {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dati_generator")
	@SequenceGenerator(name = "dati_generator", sequenceName = "dati_seq", allocationSize = 1)
	@Column(name = "id_dati")
	private long id;
	@Column(name = "codice", nullable = false)
	private String codice;
	@Column(name = "reparto", nullable = false)
	private String reparto;
	@Column(name = "stipendio", nullable = false)
	private double stipendio;
	
	public DatiAziendali() {
	}
	
	public DatiAziendali(String codice, String reparto, double stipendio) {
		super();
		this.codice = codice;
		this.reparto = reparto;
		this.stipendio = stipendio;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
}
