package com.example.tmarine.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tmarine.entity.Faixa;
import com.example.tmarine.entity.Transferencia;
import com.example.tmarine.repository.FaixaRepository;
import com.example.tmarine.service.FaixaService;

@Service
public class FaixaServiceImpl implements FaixaService {

	FaixaRepository faixaRepository;

	public FaixaServiceImpl(FaixaRepository faixaRepository) {
		this.faixaRepository = faixaRepository;
	}

	public List<Faixa> buscarFaixas() {
		return faixaRepository.findAll();
	}

	public Faixa checarFaixa(Transferencia transferencia) {
		List<Faixa> faixas = faixaRepository.findAll();
		return checarIntervalos(faixas, transferencia.getDataTransferencia());
	}

	private Faixa checarIntervalos(List<Faixa> faixas, LocalDateTime data) {
		for (Faixa faixa : faixas) {
			if (data.isAfter(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plusDays(faixa.getDiaInicial()))
					&& data.isBefore(LocalDateTime.now().plusDays(faixa.getDiaFinal()).plusHours(23).plusMinutes(59)
							.plusSeconds(59))) {
				return faixa;
			}

		}
		return null;
	}

}
