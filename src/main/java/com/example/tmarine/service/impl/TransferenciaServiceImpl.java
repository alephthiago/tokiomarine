package com.example.tmarine.service.impl;

import org.springframework.stereotype.Service;

import com.example.tmarine.entity.Transferencia;
import com.example.tmarine.repository.TransferenciaRepository;
import com.example.tmarine.service.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {
	
	TransferenciaRepository transferenciaRepository;

	public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository) {
		this.transferenciaRepository = transferenciaRepository;
	}	

	public Transferencia agendar(Transferencia transferencia) {
		return transferenciaRepository.save(transferencia);
	}

}
