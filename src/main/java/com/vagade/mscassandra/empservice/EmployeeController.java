package com.vagade.mscassandra.empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/save-employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/empdetails/{empname}")
    public List<Employee> selectEmployee(@PathVariable("empname") String empname) {
        List<Employee> employeeList = employeeService.selectEmployee(empname);

        return employeeList;
    }
}