package cm.sherli.api.mycow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.sherli.api.mycow.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

 public  List<Group> findByNameContaining(String name);
}
