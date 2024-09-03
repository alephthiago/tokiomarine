package com.example.tmarine.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmarine.dto.ContaDTO;
import com.example.tmarine.dto.ContaValorDeduzirDTO;
import com.example.tmarine.service.ContaService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/conta")
public class ContaController {

	ContaService contaService;
	ModelMapper mapper;
	MessageSource messageSource;

	public ContaController(ContaService contaService, ModelMapper mapper, MessageSource messageSource) {
		this.contaService = contaService;
		this.mapper = mapper;
		this.messageSource = messageSource;
	}

	@PostMapping("/checar")
	public ResponseEntity<String> checarSaldo(@RequestBody ContaValorDeduzirDTO contaValorDeduzirDTO) {
		if (!contaService.contaExiste(contaValorDeduzirDTO.getContaOrigem())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageSource.getMessage("account.source.not.found", null, Locale.getDefault()));
		} 
		if (!contaService.contaExiste(contaValorDeduzirDTO.getContaDestino())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageSource.getMessage("account.destination.not.found", null, Locale.getDefault()));
		}
		if (contaService.checarSaldo(contaValorDeduzirDTO.getContaOrigem(), contaValorDeduzirDTO.getDeduzir())) {
			return ResponseEntity.ok(messageSource.getMessage("account.has.balance", null, Locale.getDefault()));
		} else {
			return ResponseEntity.ok(messageSource.getMessage("account.no.balance", null, Locale.getDefault()));
		}
	}

	@GetMapping("/contas")
	public List<ContaDTO> trazerContas() {
		return mapper.map(contaService.buscarTodasContas(), new TypeToken<List<ContaDTO>>() {
		}.getType());
	}

}
