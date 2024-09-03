package com.example.tmarine.dto;

import java.math.BigDecimal;

public class FaixaDTO {

	private int diaInicial;

	private int diaFinal;

	private BigDecimal taxa;
	
	private Boolean semEquadramento;

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

	public Boolean getSemEquadramento() {
		return semEquadramento;
	}

	public void setSemEquadramento(Boolean semEquadramento) {
		this.semEquadramento = semEquadramento;
	}
	
	

}
