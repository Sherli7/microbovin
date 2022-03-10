package spring.sherli.microservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.BovinRepo;
import spring.sherli.microservice.repository.TroupeauRepo;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class BovinController {

	@Autowired
	private TroupeauRepo tRepo;

	@Autowired
	private BovinRepo bRepo;
	

	@GetMapping("/troupeau/{troupId}/bovins")
	public Optional<Bovins> getAllBovinsByTroupId(@PathVariable("troupId") Long troupId){
		if(!bRepo.existsById(troupId)){
			throw new ResourceNotFoundException("Not found Tutorial with id = " + troupId);
		}
		return bRepo.findById(troupId);
	}
    
	@PostMapping("/troupeau/{troupId}/bovins")
    public Bovins createComment(@PathVariable (value = "troupId") Long troupId,
                                  @RequestBody Bovins bovin) {
					 return tRepo.findById(troupId).map(troup -> {
							bovin.setTroupeau(troup);
				return bRepo.save(bovin);
				}).orElseThrow(() -> new ResourceNotFoundException("troupId " + troupId + " not found"));
	}

	//Changing the herd of a cow
	@PutMapping("/troupeau/{troupId}/bovins/{bovinId}")
    public Bovins updateComment(@PathVariable (value = "troupId") Long troupId,
                                 @PathVariable (value = "bovinId") Long bovinId,
                                 @RequestBody Bovins bovinRequest) {
        if(!tRepo.existsById(troupId)) {
            throw new ResourceNotFoundException("TroupId " + troupId + " not found");
        }

        return bRepo.findById(bovinId).map(bovin -> {
            bovin.setTroupeau(bovinRequest.getTroupeau());
            return bRepo.save(bovin);
        }).orElseThrow(() -> new ResourceNotFoundException("BovinId " + bovinId + "not found"));
    }

	//De-allocating a bovine to a group
	@DeleteMapping("/troupeau/{troupId}/bovin/{bovinId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "troupId") Long troupId,
                              @PathVariable (value = "bovinId") Long bovinId) {
        return bRepo.findById(troupId).map(bovin -> {
            bRepo.delete(bovin);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Bovin not found with id " + bovinId + " and postId " + troupId));
    }
}
