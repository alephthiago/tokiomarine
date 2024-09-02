package com.example.tmarine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.tmarine.entity.Conta;

public interface ContaService {

	List<Conta> buscarTodasContas();
	
	Boolean checarSaldo(String conta, BigDecimal aDeduzir);
	
	Boolean contaExiste(String conta);
	
	

}
