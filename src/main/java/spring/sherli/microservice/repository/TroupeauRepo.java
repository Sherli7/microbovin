package spring.sherli.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sherli.microservice.entity.Troupeau;

public interface TroupeauRepo extends JpaRepository<Troupeau, Long> {

}
