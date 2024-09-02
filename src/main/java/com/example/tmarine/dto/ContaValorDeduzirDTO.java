package com.example.tmarine.dto;

import java.math.BigDecimal;

public class ContaValorDeduzirDTO {

	private String contaOrigem;
	
	private String contaDestino;

	private BigDecimal deduzir;

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getDeduzir() {
		return deduzir;
	}

	public void setDeduzir(BigDecimal deduzir) {
		this.deduzir = deduzir;
	}

	

}
