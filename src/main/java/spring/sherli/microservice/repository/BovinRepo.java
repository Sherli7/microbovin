package spring.sherli.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Bovins;

public interface BovinRepo extends JpaRepository<Bovins, Long>{
	
}
