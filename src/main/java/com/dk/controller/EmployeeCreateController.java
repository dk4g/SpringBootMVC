package com.dk.controller;

import com.dk.model.Employee;
import com.dk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/empcreate")
public class EmployeeCreateController {

    @Autowired
    private EmployeeService empSrv;

    @PostMapping
    public String postEmpForm(@Valid @ModelAttribute Employee employee, Model model, BindingResult result){

        if(result.hasErrors()){
            return "empcreate";
        }
        model.addAttribute("employee", employee);
        empSrv.createEmp(employee);
        return "redirect:/";
    }

    @GetMapping
    public String getEmpForm(Model model){
        model.addAttribute("employee",new Employee());
        return "empcreate";
    }
}
