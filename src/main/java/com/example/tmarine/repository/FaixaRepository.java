package com.example.tmarine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tmarine.entity.Faixa;

@Repository
public interface FaixaRepository extends JpaRepository<Faixa, Long>{
	
	List<Faixa> findAll();

}
