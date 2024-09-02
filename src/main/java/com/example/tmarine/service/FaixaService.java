package com.example.tmarine.service;

import java.util.List;

import com.example.tmarine.entity.Faixa;
import com.example.tmarine.entity.Transferencia;

public interface FaixaService {

	List<Faixa> buscarFaixas();

	Faixa checarFaixa(Transferencia transferencia);

	

}
