package spring.sherli.microservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.sherli.microservice.entity.Bovins;

@Repository
public interface BovinRepo extends CrudRepository<Bovins, Long>{
  
}
