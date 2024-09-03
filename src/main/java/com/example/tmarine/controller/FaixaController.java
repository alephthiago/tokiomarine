package com.example.tmarine.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:5173")
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
		return mapper.map(faixaService.buscarFaixas(), new TypeToken<List<FaixaDTO>>() {
		}.getType());
	}

	@PostMapping("/checar")
	public FaixaDTO checarIntervalo(@RequestBody TransferenciaDTO transferenciaDTO) {
		Faixa checada = faixaService.checarFaixa(mapper.map(transferenciaDTO, Transferencia.class));
		if(checada != null) {
			return mapper.map(faixaService.checarFaixa(mapper.map(transferenciaDTO, Transferencia.class)),FaixaDTO.class);
		}else {
			//apesar do set de propriedade feito aqui, ele não é de negocio e sim de display e uso do front
			FaixaDTO dtoSemEnquandramento = new FaixaDTO();
			dtoSemEnquandramento.setSemEquadramento(Boolean.TRUE);
			return dtoSemEnquandramento;
		}
	}
}
