package spring.sherli.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.sherli.microservice.entity.Robe;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.repository.RobeRepository;

@RestController
@RequestMapping("/api/mycow/")
public class PhysiqueController {

	@Autowired
	private RobeRepository robeRepo;
	
	@GetMapping("/robe")
	public List<Robe> getAllRobe(){
		return robeRepo.findAll();
	}
	
	@PostMapping("/robe")
	public Robe createRobe(@RequestBody Robe robe) {
		return robeRepo.save(robe);
	}
	
	
	
}
