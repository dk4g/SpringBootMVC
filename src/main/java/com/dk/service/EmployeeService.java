package com.dk.service;

import com.dk.model.Employee;

import com.dk.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

//    private List<Employee> empList = new ArrayList<Employee>(Arrays.asList(
//            new Employee("I1","Bruce","Wayne","USA"),
//            new Employee("I2","Peter","Parker","USA")
//            ));

    @Autowired
    private EmployeeRepository empRepo;


    public List<Employee> getAll(){
        //return empList;
//        List<Employee> empList= new ArrayList<>();
//         empRepo.findAll().forEach((emp)->{ empList.add(emp);  });
//        return empList;
        return empRepo.findAll();
    }


    public Employee getEmp(String empId) {
//        for(Employee emp: empList){
//            if(emp.getEmployeeID().equals(empId)){
//                return emp;
//            }
//        }
//        return null;
        return empRepo.findByEmployeeID(empId);
    }


    public void createEmp(Employee emp) {
//        empList.add(emp);
        empRepo.save(emp);
    }


    public void deleteEmp(String empId) {
//        empList.removeIf((emp)-> emp.getEmployeeID().equals(empId));
          empRepo.deleteById(empId);
    }


    public void updateEmp(String empId, Employee emp) {
//        for(int i=0; i<empList.size(); i++){
//            if(empList.get(i).getEmployeeID().equals(empId)){
//                empList.set(i, emp);
//                return;
//            }
//        }

        empRepo.save(emp);
    }

}
