package com.example.tmarine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tmarine.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	List<Conta> findAll();
	
	Conta findByNumero(String numero);

}
