package spring.sherli.microservice.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.sherli.microservice.entity.Race;
import spring.sherli.microservice.entity.Robe;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.RaceRepository;
import spring.sherli.microservice.repository.RobeRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class PhysiqueController {

	@Autowired
	RaceRepository raceRepo;
	

	@Autowired
	RobeRepository robeRepo;
	
	@GetMapping("/race")
	  public ResponseEntity<List<Race>> getAllRace(@RequestParam(required = false) Race name) {
	    List<Race> races = new ArrayList<Race>();
	    if (name == null)raceRepo.findAll().forEach(races::add);
	    else raceRepo.findByName(name).forEach(races::add);

	    if (races.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(races, HttpStatus.OK);
	  }
	
	@GetMapping("/robe")
	  public ResponseEntity<List<Robe>> getAllRobe(@RequestParam(required = false) String name) {
	    List<Robe> robes = new ArrayList<Robe>();
	    if (name == null)robeRepo.findAll().forEach(robes::add);
	    else robeRepo.findByName(name).forEach(robes::add);
	    if (robes.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(robes, HttpStatus.OK);
	  }

	  @GetMapping("/race/{id}")
	  public ResponseEntity<Race> getRaceById(@PathVariable("id") long id) {
		  Race races = raceRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Race with id = " + id));

	    return new ResponseEntity<>(races, HttpStatus.OK);
	  }
	  
	  @GetMapping("/robe/{id}")
	  public ResponseEntity<Robe> getRobeById(@PathVariable("id") long id) {
		  Robe robes = robeRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Race with id = " + id));

	    return new ResponseEntity<>(robes, HttpStatus.OK);
	  }

	  @PostMapping("/robe")
	  public ResponseEntity<Robe> createRobe(@RequestBody Robe robe) {
		  Robe _robes = robeRepo.save(new Robe(robe.getName(), robe.getDescription(), robe.getPays()));
	    return new ResponseEntity<>(_robes, HttpStatus.CREATED);
	  }
	  
	  @PostMapping("/race")
	  public ResponseEntity<Race> createRace(@RequestBody Race race) {
		  Race _races = raceRepo.save(new Race(race.getName(), race.getDescription(), race.getPays()));
	    return new ResponseEntity<>(_races, HttpStatus.CREATED);
	  }

	  @PutMapping("/race/{id}")
	  public ResponseEntity<Race> updateRace(@PathVariable("id") long id, @RequestBody Race race) {
		  Race _race = raceRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Race with id = " + id));

		  _race.setName(race.getName());
		  _race.setDescription(race.getDescription());
		  _race.setPays(race.getPays());
	    
	    return new ResponseEntity<>(raceRepo.save(_race), HttpStatus.OK);
	  }
 
	  @PutMapping("/robe/{id}")
	  public ResponseEntity<Robe> updateRobe(@PathVariable("id") long id, @RequestBody Robe robe) {
		  Robe _robe = robeRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Robe with id = " + id));

		  _robe.setName(robe.getName());
		  _robe.setDescription(robe.getDescription());
		  _robe.setPays(robe.getPays());
	    
	    return new ResponseEntity<>(robeRepo.save(_robe), HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/race/{id}")
	  public ResponseEntity<HttpStatus> deleteRace(@PathVariable("id") long id) {
		  raceRepo.deleteById(id);
	  
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @DeleteMapping("/robe/{id}")
	  public ResponseEntity<HttpStatus> deleteRobe(@PathVariable("id") long id) {
		  robeRepo.deleteById(id);
	  
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	  @DeleteMapping("/race")
	  public ResponseEntity<HttpStatus> deleteAllRace() {
		  raceRepo.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	
	
	
}
