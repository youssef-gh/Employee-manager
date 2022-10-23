package tech.prjct.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.prjct.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
