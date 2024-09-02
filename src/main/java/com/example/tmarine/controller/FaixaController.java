package com.example.tmarine.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmarine.dto.FaixaDTO;
import com.example.tmarine.dto.TransferenciaDTO;
import com.example.tmarine.entity.Faixa;
import com.example.tmarine.entity.Transferencia;
import com.example.tmarine.service.ContaService;
import com.example.tmarine.service.FaixaService;
import com.example.tmarine.service.TransferenciaService;

@RestController
@RequestMapping("/api/faixa")
public class FaixaController {

	TransferenciaService transferenciaService;
	FaixaService faixaService;
	ContaService contaService;
	ModelMapper mapper;

	public FaixaController(FaixaService faixaService, ModelMapper mapper) {
		this.faixaService = faixaService;
		this.mapper = mapper;
	}

	@GetMapping("/faixas")
	public List<FaixaDTO> findFaixas() {
		System.out.println("Trying to find faixas");
		return mapper.map(faixaService.buscarFaixas(), new TypeToken<List<FaixaDTO>>() {
		}.getType());
	}

	@PostMapping("/checar")
	public Faixa checarIntervalo(@RequestBody TransferenciaDTO transferenciaDTO) {
		return faixaService.checarFaixa(mapper.map(transferenciaDTO, Transferencia.class));
	}
}
