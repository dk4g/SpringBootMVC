package com.dk.controller;

import com.dk.model.Employee;
import com.dk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeApiController {

    @Autowired
    private EmployeeService empSrv;

    @GetMapping("employees")
    public List<Employee> getAllEmps(){
        return empSrv.getAll();
    }

    @GetMapping("employees/{empId}")
    public Employee getEmp(@PathVariable String empId){
        return empSrv.getEmp(empId);
    }

    @PostMapping("employees")
    public void createEmployee(@RequestBody Employee emp){
        empSrv.createEmp(emp);
    }

    @DeleteMapping("employees/{empId}")
    public void deleteEmp(@PathVariable String empId){
        empSrv.deleteEmp( empId);

    }

    @PutMapping("employees/{empId}")
    public void updateEmployee(@PathVariable String empId, @RequestBody Employee emp){

        empSrv.updateEmp(empId, emp);
    }


}
