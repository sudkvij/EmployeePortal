package com.socgen.employeePortal.service;

import com.socgen.employeePortal.domain.Employee;
import com.socgen.employeePortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>)this.employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id)  {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
 }

