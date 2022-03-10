package spring.sherli.microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.service.TroupeauService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow/troupeau")
@Slf4j
public class TroupeauController {

	@Autowired
	TroupeauService service;
	
	
	@GetMapping("/{id}")
	public Optional<Troupeau> getTroupeauById(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@PostMapping
	public Troupeau saveTroupeau( @Validated @RequestBody Troupeau troupeau)
	    {
	        return service.saveTroupeau(troupeau);
	    }
	
	@GetMapping
	public List<Troupeau> fetchBovinList(){
		return service.fecthTroupeauList();
	}
	
	@PutMapping("/{id}")
	 
    public Troupeau
    updateTroupeau(@RequestBody Troupeau troupeau,
                     @PathVariable("id") Long troupeauId)
    {
        return service.updateTroupeau(
        		troupeau, troupeauId);
    }

	@DeleteMapping("/{id}")
    public String deleteTroupById(@PathVariable("id")
                                       Long id)
    {
        service.deleteTroupById(
            id);
        return "Deleted Successfully";
    }

}
