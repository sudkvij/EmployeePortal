package com.socgen.employeePortal.service;

import com.socgen.employeePortal.domain.Employee;
import com.socgen.employeePortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>)this.employeeRepository.findAll();
    }

    public Employee createOrUpdateEmployee(Employee employee)
    {
        Optional<Employee> employeeRec = employeeRepository.findById(employee.getId());
        try {
            if (employeeRec.isPresent()) {
                Employee updEmployeeRec = employeeRec.get();
                updEmployeeRec.setFirstName(employee.getFirstName());
                updEmployeeRec.setLastName(employee.getLastName());
                updEmployeeRec.setGender(employee.getGender());
                updEmployeeRec.setDepartment(employee.getDepartment());
                updEmployeeRec.setDob(employee.getDob());
                updEmployeeRec = employeeRepository.save(updEmployeeRec);
                return updEmployeeRec;
            } else {
                    Employee newEmployeeRec = employeeRepository.save(employee);
                    return newEmployeeRec;
                }
            } catch (Exception ex) {
                    throw ex;
                }
    }

    public void deleteEmployee(Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        try {
            if (employee.isPresent()) {
                employeeRepository.deleteById(id);
            }
            }
                catch (Exception ex) {
                    throw ex;
                }
        }
 }

