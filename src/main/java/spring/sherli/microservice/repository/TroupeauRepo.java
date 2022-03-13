package spring.sherli.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Troupeau;

public interface TroupeauRepo extends JpaRepository<Troupeau, Long> {

	List<Troupeau> findByName(String name);
	
}
