package cm.sherli.api.mycow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.sherli.api.mycow.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
