package com.ishostak.thymeleafdemo.controller;

import com.ishostak.thymeleafdemo.Entity.Employee;
import com.ishostak.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model model) {

        List<Employee> theEmployees = employeeService.findAll();

        model.addAttribute("employeesList", theEmployees);

        return "emplist";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
                                    Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
            employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
