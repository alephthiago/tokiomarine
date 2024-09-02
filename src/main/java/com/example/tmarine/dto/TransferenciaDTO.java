package com.example.tmarine.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class TransferenciaDTO {

	
	private String contaOrigem;

	private String contaDestino;

	private LocalDateTime dataTransferencia;

	private LocalDateTime dataAgendamento;

	private BigDecimal valor;

	private BigDecimal taxa;

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}	

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

	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
