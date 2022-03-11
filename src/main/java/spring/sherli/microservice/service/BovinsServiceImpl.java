package spring.sherli.microservice.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;
import spring.sherli.microservice.repository.BovinRepo;
import spring.sherli.microservice.repository.TroupeauRepo;

@Service
public class BovinsServiceImpl implements BovinService {

	@Autowired
	BovinRepo brepo;
	
	@Autowired
	TroupeauRepo tRepo;
	
	@Override
	public List findAllBovins() {
		// TODO Auto-generated method stub
		return (List) brepo.findAll();
	}
	
	@Override
	public Optional<Bovins> findById(Long bovinId){
		return brepo.findById(bovinId);
	}
		
	@Override
	public Bovins updateBovins(Bovins bovin, Long bovinId) throws ResourceNotFoundException{
		return this.brepo.findById(bovinId).map(bov->{
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
		return brepo.save(bov);
		}).orElseThrow(()-> new ResourceNotFoundException("This Bovin could not be found",null, bovinId));
	}
	
	@Override
	public boolean deleteBovins(Long bovinId) throws ResourceNotFoundException {
		return this.brepo.findById(bovinId).map(bov->{
			brepo.delete(bov);
			return true;
		}).orElseThrow(()->new ResourceNotFoundException("This Bovin doesn't exist", null, bovinId));
	}
	@Override
	public Optional<List<Bovins>> findBovinsByTroupeau(Long troupeau) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<List<Bovins>> findByUniqueId(String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Bovins saveBovins(Bovins bovin){
		if(!brepo.equals(bovin.getUniqueid()) && !bovin.getUniqueid().isBlank()){
			brepo.save(bovin);
		}
		return bovin;
	}

	@Override
	public Bovins ChangeBovinsTroupeau(Bovins bovin, Long bovinId, Long troupeauId) throws ResourceNotFoundException {
		Optional<Troupeau> troupData=tRepo.findById(troupeauId);
		if(!tRepo.existsById(troupeauId)) {
			throw new ResourceNotFoundException("This Group id does not exist", null, troupData);
		}
		return brepo.findById(bovinId).map(b->{
			b.setTroupeau(bovin.getTroupeau());
			return brepo.save(b);
		}).orElseThrow(()->new ResourceNotFoundException("BovinId not found", null, bovinId));
	}

}
















