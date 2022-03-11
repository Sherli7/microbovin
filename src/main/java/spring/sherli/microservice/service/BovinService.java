package spring.sherli.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.exception.ResourceNotFoundException;

public interface BovinService {

	public List<Bovins> findAllBovins();
	public Optional<Bovins> findById(Long bovinId);
	public Optional<List<Bovins>> findBovinsByTroupeau(Long troupeau);
	public Optional<List<Bovins>> findByUniqueId(String uniqueId);
	public Bovins saveBovins(Bovins bovin) throws ResourceNotFoundException;
	public Bovins updateBovins(Bovins bovin, Long bovinId) throws ResourceNotFoundException;
	public Bovins ChangeBovinsTroupeau(Bovins bovin, Long bovinId,Long troupeauId) throws ResourceNotFoundException;
	boolean deleteBovins(Long bovinId) throws ResourceNotFoundException;
}
