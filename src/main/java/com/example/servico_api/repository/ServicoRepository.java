package com.example.servico_api.repository;

import com.example.servico_api.entity.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ServicoRepository extends MongoRepository<Servico, String> {
    List<Servico> findByAnimalId(String animalId);
}