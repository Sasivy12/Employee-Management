package com.example.pleasework.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/employees", "/", ""})
    public String showEmployees(Model model)
    {
       List<Employee> employees= employeeRepository.findAll();
       model.addAttribute("employees", employees);

       return "employees";
    }

    @GetMapping("/employees/add")
    public String AddEmployee(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "addemployee";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeRepository.save(employee);

        return "redirect:/employees";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam Long empId)
    {
        employeeRepository.deleteById(empId);

        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model)
    {
        model.addAttribute("employee", employeeRepository.findById(id).get());

        return "edit_student";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee)
    {
        Employee existingEmployee = employeeRepository.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        employeeRepository.save(employee);

        return "redirect:/employees";
    }
}
