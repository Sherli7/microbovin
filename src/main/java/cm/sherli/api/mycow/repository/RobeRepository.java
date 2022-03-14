package cm.sherli.api.mycow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.sherli.api.mycow.model.Race;
import cm.sherli.api.mycow.model.Robe;

public interface RobeRepository extends JpaRepository<Robe, Long> {
	List<Robe> findByName(String name);
}
