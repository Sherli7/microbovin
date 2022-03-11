package spring.sherli.microservice.service;
import spring.sherli.microservice.entity.Troupeau;
import spring.sherli.microservice.exception.ResourceNotFoundException;

public interface TroupService {
	Troupeau updateTroupeau(Troupeau bovin, Long bovinId) throws ResourceNotFoundException;
}
