package spring.sherli.microservice.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.TroupeauRepo;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mycow")
public class TroupeauController {

	
	@Autowired
	private TroupeauRepo tRepo;

	@GetMapping("/troupeau")
	public List<Troupeau> getTroupeau() {
		return tRepo.findAll();
	}

	@PostMapping("/troupeau")
	public Troupeau createTroupeau(@RequestBody Troupeau troupeau) {
		return tRepo.save(troupeau);
	}
	
	@PutMapping("/troupeau/{id}")
	public Troupeau updaTroupeau(@PathVariable("id") Long id, @RequestBody Troupeau troupeauRequest ){
		return tRepo.findById(id).map(
			troup -> {
				troup.setName(troupeauRequest.getName());
				troup.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
				troup.setDesciption(troupeauRequest.getDesciption());
				return tRepo.save(troup);
			}
		).orElseThrow(()-> new ResourceNotFoundException("TroupeauId"+id+" not found"));
	}

	@DeleteMapping("/troupeau/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return tRepo.findById(id).map(post -> {
            tRepo.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("TroupeauId " + id + " not found"));
    }


}
