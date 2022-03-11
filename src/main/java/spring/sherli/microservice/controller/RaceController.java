package spring.sherli.microservice.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import org.springframework.web.bind.annotation.RestController;

import spring.sherli.microservice.entity.Race;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.BovinRepo;
import spring.sherli.microservice.repository.RaceRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class RaceController {

	@Autowired
	private RaceRepository raceRepo;
	
	@Autowired
	private BovinRepo bovinRepo;
	
	@GetMapping("/race")
	public List<Race> getAllRace(){
		return raceRepo.findAll(); 
	}
	
	@PostMapping("/race")
	public Race addRace(@RequestBody Race race) {
		return raceRepo.save(race);
	}
	
	
	
}
