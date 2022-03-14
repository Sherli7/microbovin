package cm.sherli.api.mycow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.sherli.api.mycow.model.Bovins;

public interface BovinRepo extends JpaRepository<Bovins, Long>{
	
}
