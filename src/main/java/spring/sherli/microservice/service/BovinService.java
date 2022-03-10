package spring.sherli.microservice.service;

import java.util.List;
import java.util.Optional;

import spring.sherli.microservice.entity.Bovins;

public interface BovinService {

	Bovins saveBovin(Bovins bovin,Long id);
	
	List<Bovins> fecthBovinsList();
	
	Optional<Bovins> findById(Long id);
	
	Bovins updateBovins(Bovins bovins,Long bovinId);
	
	//Delete operation
	
    void deleteBovinById(Long bovinsId);
}
