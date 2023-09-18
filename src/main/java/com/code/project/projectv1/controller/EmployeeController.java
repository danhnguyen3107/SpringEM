package com.code.project.projectv1.controller;

import com.code.project.projectv1.entity.Employee;
import com.code.project.projectv1.entity.SearchText;
import com.code.project.projectv1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/HomePage")
    public String homePage(Model theModel){

        return "redirect:/employees/page/1";
    }

    @GetMapping("/page/{pageNo}")
    public String page(@RequestParam(required = false) String sortBy, @RequestParam(required = false) String textS,@PathVariable("pageNo") int pageNo, Model theModel){
        System.out.println("0: " + textS);
        System.out.println("1: " + pageNo);
        Page<Employee> emp = null;
        List < Employee > employee = null;

        if (textS != null && !textS.isEmpty() && sortBy != null && !sortBy.isEmpty()){
            emp = employeeService.findByName(pageNo,"%" + textS + "%", sortBy);
        }
        else  if (textS != null && !textS.isEmpty()){
            emp = employeeService.findByName(pageNo,"%" + textS + "%", sortBy);
        }
        else if (sortBy != null && !sortBy.isEmpty()){
            emp = employeeService.findBySort(pageNo, sortBy);
        }
        else {
            emp = employeeService.findPaginated(pageNo);
        }


        employee = emp.getContent();
        System.out.println("2: " + employee);
        theModel.addAttribute("searchText", textS);
        theModel.addAttribute("textSearch", new SearchText());
        theModel.addAttribute("currentPage", pageNo);
        theModel.addAttribute("totalPages", emp.getTotalPages());
        theModel.addAttribute("totalItems", emp.getTotalElements());
        theModel.addAttribute("employees", employee);
        theModel.addAttribute("sortText", sortBy);
        return "list_employee";
    }


    @GetMapping("/addForm")
    public String showAddForm(Model theModel){
        theModel.addAttribute("employee", new Employee());
        return "add_employee";
    }
    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,  BindingResult theBinding){
        if (theBinding.hasErrors()) return "add_employee";

        employeeService.addEmployee(employee);
        return "redirect:/employees/HomePage";
    }
    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam("empId") int id, Model theModel){
        Employee emp = employeeService.findById(id);
        System.out.println(emp);
        theModel.addAttribute("employee", emp);
        return "add_employee";
    }
    @GetMapping("/deleteForm")
    public  String delete(@RequestParam("empId") int id){
        employeeService.delete(id);
        return "redirect:/employees/HomePage";
    }
    @PostMapping("/search")
    public  String search(@ModelAttribute("textSearch") SearchText text, RedirectAttributes redirectAttrs){


        return "redirect:/employees/page/1?" + "textS=" + text.getSearchText();
    }

}


















