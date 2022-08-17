package br.com.maurigvs.hrworker.resources;

import br.com.maurigvs.hrworker.entities.Worker;
import br.com.maurigvs.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> selectAll(){

        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok().body(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> selectById(@PathVariable Long id){
        // Implementação simplificada sem tratamento de exceções
        Optional<Worker> worker = repository.findById(id);
        return ResponseEntity.ok().body(worker.get());
    }
}
