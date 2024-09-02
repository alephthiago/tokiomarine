package com.example.tmarine.controller;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmarine.dto.TransferenciaDTO;
import com.example.tmarine.entity.Transferencia;
import com.example.tmarine.service.ContaService;
import com.example.tmarine.service.FaixaService;
import com.example.tmarine.service.TransferenciaService;


@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {
	
	TransferenciaService transferenciaService;
	FaixaService faixaService;	
	ContaService contaService;
	ModelMapper mapper;
	
	public TransferenciaController (FaixaService faixaService, ContaService contaService, TransferenciaService transferenciaService, ModelMapper mapper) {
		this.faixaService = faixaService;
		this.contaService = contaService;
		this.transferenciaService = transferenciaService;
		this.mapper = mapper;
	}	
	
	@PostMapping("/agendar")
	public ResponseEntity<HttpStatus> agendar(@RequestBody TransferenciaDTO transferenciaDTO){		
		transferenciaService.agendar(mapper.map(transferenciaDTO, Transferencia.class));
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@GetMapping("/date")
	public LocalDateTime findDate() {
		System.out.println("Trying to find date");
		return LocalDateTime.now();
	}
	
	@PostMapping("/post-date")
	public LocalDateTime postDate(@RequestBody TransferenciaDTO transferenciaDTO) {
		System.out.println("this is your date"+transferenciaDTO.getDataTransferencia());
		return transferenciaDTO.getDataTransferencia();

	}

}
