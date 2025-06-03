package com.example.servico_api.controller;

import com.example.servico_api.entity.Servico;
import com.example.servico_api.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping("/register")
    public ResponseEntity<Servico> register(@RequestBody Servico servico) {
        Servico savedServico = servicoService.registerServico(servico);
        return ResponseEntity.ok(savedServico);
    }

    @GetMapping("/byAnimal/{animalId}")
    public ResponseEntity<List<Servico>> getByAnimal(@PathVariable String animalId) {
        List<Servico> servicos = servicoService.getServicosByAnimal(animalId);
        return ResponseEntity.ok(servicos);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos() {
        List<Servico> servicos = servicoService.getAllServicos();
        return ResponseEntity.ok(servicos);
    }
}