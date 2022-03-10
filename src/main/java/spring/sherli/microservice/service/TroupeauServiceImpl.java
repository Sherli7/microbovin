package spring.sherli.microservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.repository.TroupeauRepo;

@Service
public class TroupeauServiceImpl implements TroupeauService {

	@Autowired
	TroupeauRepo repo;
	
	@Override
	public Troupeau saveTroupeau(Troupeau troupeau) {
		// TODO Auto-generated method stub
		return repo.save(troupeau);
	}

	@Override
	public Optional<Troupeau> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Troupeau updateTroupeau(Troupeau troupeau, Long troupeauId) {
Troupeau troupeauDB=repo.findById(troupeauId).get();
		
		if (Objects.nonNull(troupeau.getName())&& !"".equalsIgnoreCase(troupeau.getName())){
			troupeauDB.setName(troupeau.getName());
		}
		
		return repo.save(troupeauDB);
	}


	@Override
	public List<Troupeau> fecthTroupeauList() {
		// TODO Auto-generated method stub
		return (List<Troupeau>) repo.findAll();
	}

	@Override
	public void deleteTroupById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	
}
