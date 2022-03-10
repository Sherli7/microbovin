package spring.sherli.microservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.sherli.microservice.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {

	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public boolean findByEmail(@Param("email") String email);
}
