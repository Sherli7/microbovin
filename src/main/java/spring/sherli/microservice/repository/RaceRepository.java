package spring.sherli.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long>{

}
