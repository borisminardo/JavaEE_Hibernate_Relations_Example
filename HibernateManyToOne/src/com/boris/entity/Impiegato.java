package com.boris.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Impiegato")
public class Impiegato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imp_generator")
	@SequenceGenerator(name = "imp_generator", sequenceName = "imp_seq", allocationSize = 1)
	@Column(name = "id_imp")
	private long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "stipendio", nullable = false)
	private double stipendio;

	@Column(name = "reparto", nullable = false)
	private String reparto;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_indirizzo")
	private Indirizzo indirizzo;

	public Impiegato(String nome, double stipendio, String reparto, Indirizzo indirizzo) {
		this.nome = nome;
		this.stipendio = stipendio;
		this.reparto = reparto;
		this.indirizzo = indirizzo;
	}

	public Impiegato() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	
}
