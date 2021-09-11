package com.dk.controller;


import com.dk.model.Employee;
import com.dk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private EmployeeService empSrv;

    @GetMapping("/home")
    public String getHomePage(Model model){

        return "index";
    }

    @GetMapping("/employees")
    public String getEmployeePage(Model model){

        List<Employee> empList = empSrv.getAll();

        model.addAttribute("empList", empList);
        return "employee";
    }


}
