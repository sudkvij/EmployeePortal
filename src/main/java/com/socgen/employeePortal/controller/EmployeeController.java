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
import java.util.Optional;

@RestController
@RequestMapping(value="/employees")
@Api(value="employees",description = "Employee Data Services", tags=("Emps"))
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    @ApiOperation(value="Get All Employees", notes="Gets all Soc Gen Employees", nickname="getEmps")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List empList = this.employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(empList,new HttpHeaders(),HttpStatus.OK);
    }

    @RequestMapping(value = "/create/{id}",method = RequestMethod.POST)
    @ApiOperation(value="Create Employee", notes="Create Soc Gen Employees", nickname="createEmp")
    public ResponseEntity<Employee> createEmployee(@RequestBody  Employee employee)
    {
        Employee empRec = employeeService.createEmployee(employee);
        return new ResponseEntity<Employee>(empRec, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    @ApiOperation(value="Update Employee", notes="Update Soc Gen Employees", nickname="updEmp")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Long id) throws Exception
    {
       Optional<Employee> emp =  employeeService.getEmployeeById(id);
       if (!emp.isPresent())
            throw new Exception("Cannot find Employee with Id: " + id);
       System.out.println(employee);
       if(employee.getFirstName() == null || employee.getFirstName().isEmpty())
           employee.setFirstName(emp.get().getFirstName());
       if(employee.getLastName() == null || employee.getLastName().isEmpty())
           employee.setLastName(emp.get().getLastName());
       if(employee.getGender() == null || employee.getGender().isEmpty())
           employee.setGender(emp.get().getGender());
       if(employee.getDepartment() == null || employee.getDepartment().isEmpty())
           employee.setDepartment(emp.get().getDepartment());
       if(employee.getDob() == null )
           employee.setDob(emp.get().getDob());
        employee.setId(emp.get().getId());
        Employee empRec = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(empRec, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete Employee", notes="Delete Soc Gen Employees", nickname="delEmp")
    public HttpStatus deleteEmployee(@PathVariable("id") Long id) throws Exception
    {
        Optional<Employee> emp =  employeeService.getEmployeeById(id);
        if (!emp.isPresent())
            throw new Exception("Cannot find Employee with Id: " + id);
        employeeService.deleteEmployee(id);
        return HttpStatus.FORBIDDEN;
    }
}
