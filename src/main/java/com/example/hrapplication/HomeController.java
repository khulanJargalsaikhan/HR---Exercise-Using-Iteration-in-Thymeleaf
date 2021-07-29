package com.example.hrapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/employeeform")
    public String loadEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @PostMapping("/confirmform")
    public String processEmployeeForm(@ModelAttribute Employee employee, Model model){
        model.addAttribute("employee", employee);
        employees.add(employee);
        return "confirmform";
    }

    @RequestMapping("/listall")
    public String showAll(Model model){
        //add array list of employees to model
        model.addAttribute("employees", employees);
        return "listall";
    }
}
