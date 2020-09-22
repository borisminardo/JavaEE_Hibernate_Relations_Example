package com.boris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
	@Column(name = "cognome", nullable = false)
	private String cognome;
	@Column(name = "indirizzo", nullable = false)
	private String indirizzo;
	
	@OneToOne
	@MapsId
	private DatiAziendali datiAziendali;
	
	public Impiegato() {
	}

	public Impiegato(String nome, String cognome, String indirizzo, DatiAziendali datiAziendali) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.datiAziendali = datiAziendali;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public DatiAziendali getDatiAziendali() {
		return datiAziendali;
	}

	public void setDatiAziendali(DatiAziendali datiAziendali) {
		this.datiAziendali = datiAziendali;
	}

}
