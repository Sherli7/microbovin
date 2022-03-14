package cm.sherli.api.mycow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.sherli.api.mycow.model.Troupeau;

public interface TroupeauRepo extends JpaRepository<Troupeau, Long> {

	List<Troupeau> findByName(String name);
	
}
