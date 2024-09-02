package com.example.tmarine.dto;

import java.math.BigDecimal;

public class FaixaDTO {

	private int diaInicial;

	private int diaFinal;

	private BigDecimal taxa;

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
