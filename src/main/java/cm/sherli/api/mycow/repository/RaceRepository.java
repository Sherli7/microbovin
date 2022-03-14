package cm.sherli.api.mycow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.sherli.api.mycow.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long>{
	List<Race> findByName(Race race);
}
