package com.example.servico_api.service;

import com.example.servico_api.entity.Servico;
import com.example.servico_api.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico registerServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> getServicosByAnimal(String animalId) {
        return servicoRepository.findByAnimalId(animalId);
    }

    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }
}