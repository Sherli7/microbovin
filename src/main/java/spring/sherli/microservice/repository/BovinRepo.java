package spring.sherli.microservice.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.sherli.microservice.entity.Bovins;

@Repository
public interface BovinRepo extends JpaRepository<Bovins, Long>{

}
