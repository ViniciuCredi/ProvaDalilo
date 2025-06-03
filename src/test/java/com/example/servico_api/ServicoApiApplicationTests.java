package com.example.servico_api;

import com.example.servico_api.entity.Servico;
import com.example.servico_api.repository.ServicoRepository;
import com.example.servico_api.service.ServicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ServicoServiceTest {

	private ServicoRepository servicoRepository;
	private ServicoService servicoService;

	@BeforeEach
	void setUp() {
		servicoRepository = Mockito.mock(ServicoRepository.class);
		servicoService = new ServicoService(servicoRepository);
	}

	@Test
	void testRegisterServico() {
		Servico servico = new Servico();
		when(servicoRepository.save(servico)).thenReturn(servico);

		Servico result = servicoService.registerServico(servico);
		assertEquals(servico, result);
		verify(servicoRepository, times(1)).save(servico);
	}

	@Test
	void testGetAllServicos() {
		Servico s1 = new Servico();
		Servico s2 = new Servico();
		List<Servico> mockList = Arrays.asList(s1, s2);

		when(servicoRepository.findAll()).thenReturn(mockList);

		List<Servico> result = servicoService.getAllServicos();
		assertEquals(2, result.size());
		verify(servicoRepository, times(1)).findAll();
	}

	@Test
	void testGetServicosByAnimal() {
		String animalId = "abc123";
		Servico s1 = new Servico();
		List<Servico> mockList = List.of(s1);

		when(servicoRepository.findByAnimalId(animalId)).thenReturn(mockList);

		List<Servico> result = servicoService.getServicosByAnimal(animalId);
		assertEquals(1, result.size());
		verify(servicoRepository, times(1)).findByAnimalId(animalId);
	}
}
