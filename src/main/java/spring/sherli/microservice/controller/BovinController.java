package spring.sherli.microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import spring.sherli.microservice.entity.Race;
import spring.sherli.microservice.entity.Robe;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.BovinRepo;
import spring.sherli.microservice.repository.RaceRepository;
import spring.sherli.microservice.repository.TroupeauRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class BovinController {

	@Autowired
	private BovinRepo bovinRepo;
	
	@Autowired
	private TroupeauRepo troupRepo;
	
	@Autowired 
	RaceRepository raceRepo;
	
	/*
	 * Get all bovin by troupeau Id
	 */
	/*@GetMapping("/troupeau/{troupId}/bovins")
	public ResponseEntity<Bovins> getAllBovinsByTroupId(@PathVariable(value = "troupId") Long troupId){
		if(!troupRepo.existsById(troupId)) {
			throw new ResourceNotFoundException("Not found troupeau with id= "+troupId);
		}
		List<Bovins> bovin=bovinService.findByTroupeauId(troupId);
		return new ResponseEntity(bovin,HttpStatus.OK);

	}*/
	
	/*
	 * Get Bovins by troupeau Id
	 */
	 @GetMapping("/bovins/{id}")
	  public ResponseEntity<Bovins> getBovinsByTroupId(@PathVariable(value = "id") Long id) {
	    Bovins bov = bovinRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Bovin with id = " + id));

	    return new ResponseEntity<>(bov, HttpStatus.OK);
	  }
	
	 @PostMapping("/troupeau/{troupId}/bovins")
	  public ResponseEntity<Bovins> createBovin(
			  @PathVariable("troupId") Long troupId,
			  @PathVariable("raceId") Long raceId,
			  @PathVariable("robeId") Long robeId,
	      @RequestBody Bovins bovinRequest) {		 
		 Bovins bovin = troupRepo.findById(troupId).map(troup -> {
			 bovinRequest.setTroupeau(troup);
	      return bovinRepo.save(bovinRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("Not found Troup with id = " + troupId));
	    return new ResponseEntity<>(bovin, HttpStatus.CREATED);
	  }
	
	
	 @PutMapping("/bovins/{id}")
	  public ResponseEntity<Bovins> updateBovin(@PathVariable("id") long id, @RequestBody Bovins bovin) {
		 Bovins bov = bovinRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("BovinId " + id + "not found"));
		 bov.setBirthDay(bovin.getBirthDay());
			bov.setCornage(bovin.getCornage());
			bov.setCountry(bovin.getCountry());
			bov.setFirstPhysicId(bovin.getFirstPhysicId());
			bov.setSecPhysicId(bovin.getSecPhysicId());
			bov.setSex(bovin.getSex());
			bov.setModeReproduction(bovin.getModeReproduction());
			bov.setHeightAtBirth(bovin.getHeightAtBirth());
			bov.setWeightAtBirth(bovin.getWeightAtBirth());
			bov.setRace(bovin.getRace());
			bov.setRobe(bovin.getRobe());

	    return new ResponseEntity<>(bovinRepo.save(bov), HttpStatus.OK);
	  }
	
	 
	 @DeleteMapping("/troupeau/{troupId}/bovins")
	  public ResponseEntity<List<Bovins>> deleteAllBovinsOfTroupeau(@PathVariable(value = "troupId") Long troupId) {
	    if (!troupRepo.existsById(troupId)) {
	      throw new ResourceNotFoundException("Not found Troupeau with id = " + troupId);
	    }
	    bovinRepo.deleteById(troupId);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	 
	
}
