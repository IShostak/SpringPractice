package com.ishostak.springboot.cruddemo.rest;

import com.ishostak.springboot.cruddemo.entity.Employee;
import com.ishostak.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {

        Employee employee = service.findById(employeeID);

        if (employee == null) {
            throw new RuntimeException("Emp not found: " + employeeID);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        service.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId) {

        Employee employee = service.findById(empId);

        if(employee == null) {
            throw new RuntimeException("No employee + " + empId );
        }
        service.deleteById(empId);

        return "Deleted employee: " + empId;
    }
}
