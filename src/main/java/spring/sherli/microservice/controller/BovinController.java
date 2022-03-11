package spring.sherli.microservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.TroupeauRepo;
import spring.sherli.microservice.service.BovinService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class BovinController {

	@Autowired
	private BovinService bservice;
	
	@Autowired
	private TroupeauRepo trop;
	
	@GetMapping("/bovins")
	public List<Bovins> getAllBovins(){
		return bservice.findAllBovins();
	}
	
	@GetMapping("/bovins/{id}")
	public Optional<Bovins> getBovinById(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return bservice.findById(id);
	}
	

	
	@PostMapping("/bovins")
	public Bovins saveBovin(@Valid @RequestBody Bovins bovin) throws ResourceNotFoundException{
		return bservice.saveBovins(bovin);
	}
    

	@PutMapping("/bovins/{id}")
	public Bovins updateBovins(@Valid  @RequestBody Bovins bovin, @PathVariable("id") Long bovinId) throws ResourceNotFoundException {
		return bservice.updateBovins(bovin, bovinId);
		
	}
	
	@PutMapping("/troupeau/{troupId}/bovins/{id}")
	public Bovins updateBovinsTroupeau(@Valid  @RequestBody Bovins bovin,@PathVariable("troupId") Long troupId, @PathVariable("id") Long id) throws ResourceNotFoundException {
		return bservice.ChangeBovinsTroupeau(bovin,id,troupId);
		
	}
	
	@DeleteMapping("/bovins/{id}")
	public Boolean deleteBovins(@PathVariable("id") Long id) throws ResourceNotFoundException
	{
	 return	(Boolean) bservice.findById(id).map(bov->{
		try {
			return bservice.deleteBovins(id);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			new ResourceNotFoundException("Could not found bovin by id", null, id);
		}
		return null;
	 }).orElseThrow(()-> new ResourceNotFoundException("This Bovin doesn't exist",null, id));
	
	}
	
	
}
