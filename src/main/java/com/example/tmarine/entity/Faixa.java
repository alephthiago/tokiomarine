package com.example.tmarine.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FAIXA")
public class Faixa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "dia_inicial")
	private int diaInicial;

	@Column(name = "dia_final")
	private int diaFinal;

	@Column
	private BigDecimal taxa;

	public long getId() {
		return id;
	}

	public int getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(int diaInicial) {
		this.diaInicial = diaInicial;
	}

	public int getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(int diaFinal) {
		this.diaFinal = diaFinal;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

}
