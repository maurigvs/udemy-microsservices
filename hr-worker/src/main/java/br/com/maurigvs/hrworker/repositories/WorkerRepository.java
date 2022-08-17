package br.com.maurigvs.hrworker.repositories;

import br.com.maurigvs.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
