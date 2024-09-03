package com.example.tmarine.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.tmarine.entity.Faixa;
import com.example.tmarine.entity.Transferencia;
import com.example.tmarine.repository.FaixaRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FaixaServiceImplTest {

    @Mock
    private FaixaRepository faixaRepository;

    @InjectMocks
    private FaixaServiceImpl faixaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarFaixas() {
        // Arrange
        Faixa faixa1 = new Faixa();
        faixa1.setDiaInicial(0);
        faixa1.setDiaInicial(0);
        Faixa faixa2 = new Faixa();
        faixa2.setDiaInicial(1);
        faixa2.setDiaInicial(10);
        when(faixaRepository.findAll()).thenReturn(Arrays.asList(faixa1, faixa2));        
        List<Faixa> faixas = faixaService.buscarFaixas();
        assertEquals(2, faixas.size());
        verify(faixaRepository, times(1)).findAll();
    }

    @Test
    public void testChecarFaixaComFaixaExistente() {        
        Faixa faixa1 = new Faixa();
        faixa1.setDiaInicial(-1); 
        faixa1.setDiaFinal(1);
        when(faixaRepository.findAll()).thenReturn(Arrays.asList(faixa1));
        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(LocalDateTime.now());        
        Faixa result = faixaService.checarFaixa(transferencia);        
        assertEquals(faixa1, result);
    }

    @Test
    public void testChecarFaixaSemFaixaCorrespondente() {
        Faixa faixa1 = new Faixa();
        faixa1.setDiaInicial(-10);
        faixa1.setDiaFinal(-5);
        when(faixaRepository.findAll()).thenReturn(Arrays.asList(faixa1));
        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(LocalDateTime.now());        
        Faixa result = faixaService.checarFaixa(transferencia);        
        assertNull(result);
    }
}
