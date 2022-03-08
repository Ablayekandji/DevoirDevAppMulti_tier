package com.example.wsdevoir.controller;

import com.example.wsdevoir.model.Employe;
import com.example.wsdevoir.repository.EmployeRepository;
import com.example.wsdevoir.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeController {
    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeRepository employeRepository;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",this.employeRepository.findAll());
        return "index";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employe employe = new Employe();
        model.addAttribute("employe",employe);
        return "new_employe";
    }
    @PostMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") Employe employe){
        this.employeService.saveEmploye(employe);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable (value = "id") long id,Model model){
        Employe employe=this.employeService.getEmployeById(id);
        model.addAttribute("employe",employe);
        return "update_employe";
    }

    @GetMapping("/deleteEmploye/{id}")
    public String deleteEmploye(@PathVariable (value = "id") long id){
        this.employeRepository.deleteById(id);
        return "redirect:/";
    }
}
