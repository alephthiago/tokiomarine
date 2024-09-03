package com.example.tmarine.service;

import java.util.List;

import com.example.tmarine.entity.Transferencia;

public interface TransferenciaService {

	Transferencia agendar(Transferencia transferencia);
	
	List<Transferencia> buscarTransferencias();

}
