package com.vagade.mscassandra.empservice;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public void saveEmployee(Employee employee) {
        System.out.println("employee " + employee);
        employee.setId(UUIDs.timeBased());
        employeeRepository.save(employee);
    }

    public List<Employee> selectEmployee(String empFirstname) {
        List<Employee> employeeList = employeeRepository.findByFirstName(empFirstname);

        return employeeList;
    }
}
