package spring.sherli.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Race;
import spring.sherli.microservice.entity.Robe;

public interface RobeRepository extends JpaRepository<Robe, Long> {
	List<Robe> findByName(String name);
}
