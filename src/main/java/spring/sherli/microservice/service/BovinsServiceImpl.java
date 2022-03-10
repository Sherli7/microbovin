package spring.sherli.microservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.sherli.microservice.entity.Bovins;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.repository.BovinRepo;

@Service
public class BovinsServiceImpl implements BovinService{

	@Autowired
	BovinRepo repo;

	@Autowired
	TroupeauService tserv;
	
	@Override
	public List<Bovins> fecthBovinsList() {
		return (List<Bovins>) repo.findAll();
	}

	@Override
	public Bovins updateBovins(Bovins bovins, Long bovinId) {
		Bovins bovinDB=repo.findById(bovinId).get();
		
		if (Objects.nonNull(bovins.getRace())&& !"".equalsIgnoreCase(bovins.getRace())){
			bovinDB.setRace(bovins.getRace());
		}
		if (Objects.nonNull(bovins.getRobe())&& !"".equalsIgnoreCase(bovins.getRobe())){
			bovinDB.setRace(bovins.getRobe());
		}
		
		if (Objects.nonNull(bovins.getCornage())&& !"".equalsIgnoreCase(bovins.getCornage())){
			bovinDB.setRace(bovins.getRace());
		}
		
		return repo.save(bovinDB);
	          
	}

	@Override
	public void deleteBovinById(Long bovinsId) {
		repo.deleteById(bovinsId);
		
	}

	@Override
	public Optional<Bovins> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Bovins saveBovin(Bovins bovin, Long id) {
		Troupeau dbTroup=tserv.findById(id).get();
		bovin.setTroupeau(dbTroup);
		return repo.save(bovin);
	}

	
}
