package com.dk.repository;


import com.dk.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    public List<Employee> findAll();

    public Employee findByEmployeeID(String employeeID);

}