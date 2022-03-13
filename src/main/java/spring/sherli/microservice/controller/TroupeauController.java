package spring.sherli.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.TroupeauRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class TroupeauController {

	@Autowired
	TroupeauRepo troupRepo;
	
	@GetMapping("/troupeau")
	  public ResponseEntity<List<Troupeau>> getAllTroupeau(@RequestParam(required = false) String name) {
	    List<Troupeau> troups = new ArrayList<Troupeau>();

	    if (name == null)
	    	troupRepo.findAll().forEach(troups::add);
	    else
	    	troupRepo.findByName(name).forEach(troups::add);

	    if (troups.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(troups, HttpStatus.OK);
	  }

	  @GetMapping("/troupeau/{id}")
	  public ResponseEntity<Troupeau> getTroupeauById(@PathVariable("id") long id) {
		  Troupeau troups = troupRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Troupeau with id = " + id));

	    return new ResponseEntity<>(troups, HttpStatus.OK);
	  }

	  @PostMapping("/troupeau")
	  public ResponseEntity<Troupeau> createTroupeau(@RequestBody Troupeau troup) {
		  Troupeau _troups = troupRepo.save(new Troupeau(troup.getName(), troup.getDescription()));
	    return new ResponseEntity<>(_troups, HttpStatus.CREATED);
	  }

	  @PutMapping("/troupeau/{id}")
	  public ResponseEntity<Troupeau> updateTroupeau(@PathVariable("id") long id, @RequestBody Troupeau tutorial) {
		  Troupeau _troup = troupRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Troupeau with id = " + id));

	    _troup.setName(tutorial.getName());
	    _troup.setDescription(tutorial.getDescription());
	    
	    return new ResponseEntity<>(troupRepo.save(_troup), HttpStatus.OK);
	  }

	  @DeleteMapping("/troupeau/{id}")
	  public ResponseEntity<HttpStatus> deleteTroupeau(@PathVariable("id") long id) {
		  troupRepo.deleteById(id);
	  
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	  @DeleteMapping("/troupeau")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
		  troupRepo.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	

}
