package tech.prjct.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.prjct.employeemanager.exception.UserNotFoundException;
import tech.prjct.employeemanager.model.Employee;
import tech.prjct.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
//        we need to generate the ID automatically
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {

        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()->new UserNotFoundException("User of the id:"+id+"not found"));
    }
    public void deleteEmployeeById(Long id) {

        employeeRepo.deleteEmployeeById(id);
    }
}
