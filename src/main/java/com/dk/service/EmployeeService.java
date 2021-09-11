package com.dk.service;

import com.dk.model.Employee;

import com.dk.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private AmqpTemplate rabbitTemplateBean;

    @Value("${backend.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${backend.rabbitmq.routingkey}")
    private String routingKey;

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
       Employee retEmp =  empRepo.save(emp);
       if (retEmp != null) {
           LOG.info("SENDING message to RabbitMQ");
           rabbitTemplateBean.convertAndSend(exchangeName, routingKey, retEmp);
       }

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
