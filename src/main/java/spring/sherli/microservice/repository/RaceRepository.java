package spring.sherli.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long>{
	List<Race> findByName(Race race);
}
