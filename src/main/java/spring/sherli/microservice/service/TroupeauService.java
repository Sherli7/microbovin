package spring.sherli.microservice.service;

import java.util.List;
import java.util.Optional;

import spring.sherli.microservice.entity.Troupeau;

public interface TroupeauService {

	Troupeau saveTroupeau(Troupeau troupeau);
	List<Troupeau> fecthTroupeauList();
    Optional<Troupeau> findById(Long id);
    Troupeau updateTroupeau(Troupeau bovins,Long bovinId);
	//Delete operation
    void deleteTroupById(Long bovinsId);
}
