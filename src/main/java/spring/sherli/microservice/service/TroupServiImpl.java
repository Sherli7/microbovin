package spring.sherli.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.TroupeauRepo;

@Service
public class TroupServiImpl implements TroupService {

	@Autowired
	TroupeauRepo tRepo;
	@Override
	public Troupeau updateTroupeau(Troupeau troup, Long treoupId) throws ResourceNotFoundException {
		return this.tRepo.findById(treoupId).map(t->{
			t.setDescription(troup.getDescription());
			t.setName(troup.getName());
			return tRepo.save(t);
			}).orElseThrow(()-> new ResourceNotFoundException("This Troupeau could not be found",null, treoupId));
		}
}
