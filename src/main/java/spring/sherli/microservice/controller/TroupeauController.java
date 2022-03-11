package spring.sherli.microservice.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.BovinRepo;
import spring.sherli.microservice.repository.TroupeauRepo;
import spring.sherli.microservice.service.TroupService;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class TroupeauController {

	
	@Autowired
	private TroupeauRepo tRepo;
	@Autowired
	private TroupService tservice;
	
	@Autowired
	private BovinRepo brepo;

	@GetMapping("/troupeau")
	public List<Troupeau> getTroupeau() {
		return tRepo.findAll();
	}

	@PostMapping("/troupeau")
	public Troupeau createTroupeau(@RequestBody Troupeau troupeau) {
		return tRepo.save(troupeau);
	}
    
	@PostMapping("/troupeau/{id}/bovins")
    public Bovins createBovinFromTroupeau(@PathVariable("id") Long id,@Valid @RequestBody Bovins bovin) throws ResourceNotFoundException {
		return tRepo.findById(id).map(t->{
			bovin.setTroupeau(t);
			return brepo.save(bovin);
		}).orElseThrow(()->new ResourceNotFoundException("TroupeauId",null, bovin));
	}
	
	
	@GetMapping("troupeau/{id}")
	public Optional<Troupeau> getTroupeauById(@PathVariable("id") Long id) {
		return tRepo.findById(id);
	}
	
	@PutMapping("/troupeau/{id}")
	public Troupeau updateTroupeau(@PathVariable("id") Long id, @RequestBody Troupeau troup) throws ResourceNotFoundException {
		return tservice.updateTroupeau(troup, id);
		
	}
	
	@DeleteMapping("/troupeau/{id}")
	public void deleteTroupeauById(@PathVariable("id") Long id) {
		tRepo.deleteById(id);
		return;
	}

	

}
