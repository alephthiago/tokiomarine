package com.example.tmarine.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tmarine.entity.Conta;
import com.example.tmarine.repository.ContaRepository;
import com.example.tmarine.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	ContaRepository contaRepository;

	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public List<Conta> buscarTodasContas() {
		return contaRepository.findAll();
	}

	public Boolean checarSaldo(String conta, BigDecimal aDeduzir) {
		Conta contaCompleta = contaRepository.findByNumero(conta);
		if (contaCompleta.getValor().compareTo(aDeduzir) > -1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Boolean contaExiste(String conta) {
		if (contaRepository.findByNumero(conta) == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
