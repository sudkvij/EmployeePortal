package com.socgen.employeePortal.controller;

import com.socgen.employeePortal.domain.Employee;
import com.socgen.employeePortal.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employees")
@Api(value="employees",description = "Employee Data Services", tags=("Emps"))
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Employees", notes="Gets all Soc Gen Employees", nickname="getEmps")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List empList = this.employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(empList,new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value="Create Employee", notes="Create Soc Gen Employees", nickname="createEmp")
    public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee)
    {
        Employee empRec = employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(empRec, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete Employee", notes="Delete Soc Gen Employees", nickname="delEmp")
    public HttpStatus deleteEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return HttpStatus.FORBIDDEN;
    }
}
