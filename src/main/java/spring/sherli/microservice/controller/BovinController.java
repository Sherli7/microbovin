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

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.service.BovinService;
import spring.sherli.microservice.service.TroupeauService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow/bovin")
public class BovinController {

	@Autowired
	BovinService service;
	@Autowired
	TroupeauService tServ;
	
	@PostMapping("/{id}")
	public Bovins saveBovin( @Validated @RequestBody Bovins bovin,@PathVariable("id") Long troupId)
	    {
	      return service.saveBovin(bovin,troupId);
	    }
	
	@GetMapping
	public List<Bovins> fetchBovinList(){
		return service.fecthBovinsList();
	}
	
	@GetMapping("/{id}")
	public Optional<Bovins> fetchBovinById(@PathVariable("id") Long bovinId){
		return service.findById(bovinId);
	}
	
	@PutMapping("/{id}")
	 
    public Bovins
    updateDepartment(@RequestBody Bovins bovin,
                     @PathVariable("id") Long bovinId)
    {
        return service.updateBovins(
            bovin, bovinId);
    }
	
	// Delete operation
    @DeleteMapping("/{id}")
    public String deleteBovinById(@PathVariable("id")
                                       Long bovinId)
    {
        service.deleteBovinById(
            bovinId);
        return "Deleted Successfully";
    }
}
