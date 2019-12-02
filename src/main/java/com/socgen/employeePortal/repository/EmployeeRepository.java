package com.socgen.employeePortal.repository;

import com.socgen.employeePortal.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
