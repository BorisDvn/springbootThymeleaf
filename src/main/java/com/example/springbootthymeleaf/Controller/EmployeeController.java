package com.example.springbootthymeleaf.Controller;

import com.example.springbootthymeleaf.Entitie.Employee;
import com.example.springbootthymeleaf.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/list", "/showEmployees", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", employeeRepository.findAll());
        return mav;
    }

    // to open the form for adding
    @GetMapping({"/addEmployeeForm"})
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping({"/saveEmployee"})
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/list";
    }

    @GetMapping({"/showUpdateForm"})
    public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        mav.addObject("employee", employee);
        return mav;
    }

    // @DeleteMapping({"/deleteEmployee"})
    @GetMapping({"/deleteEmployee"})
    public String deleteEmployee(@RequestParam Long employeeId) {
        //ModelAndView mav = new ModelAndView("add-employee-form");
        employeeRepository.deleteById(employeeId);
        return "redirect:/list";
        //mav.addObject("employee", employee);
        //return mav;
    }

}
