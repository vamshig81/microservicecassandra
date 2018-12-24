package com.vagade.mscassandra.empservice;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("Select * from employee where firstname=?0 allow filtering")
    List<Employee> findByFirstName(String firstName);

    @Query("Select * from employee where lastname=?0")
    List<Employee> findByLastName(String lastName);
}
