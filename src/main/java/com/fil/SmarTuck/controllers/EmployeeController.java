package com.fil.SmarTuck.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fil.SmarTuck.models.Employee;
import com.fil.SmarTuck.services.EmployeeServiceImplementation;


@RestController 
public class EmployeeController {

	@Autowired  
    private EmployeeServiceImplementation employeeService;   
   
	@RequestMapping("/employees")  
    public List<Employee> getAllUser(){  
        return employeeService.getAllEmployee();  
    }
	
    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)  
    public void addEmployee(@RequestBody Employee e){  
        employeeService.addEmployee(e);  
    }
    
    @RequestMapping(value = "/delete-employee", method = RequestMethod.POST)  
    public void deleteEmployee(@RequestBody Employee e){  
        employeeService.deleteEmployee(e);  
    }
    
    @RequestMapping(value = "/employee/{aId}", method = RequestMethod.GET)  
    public Optional<Employee> getEmployee(@PathVariable String id){  
        return employeeService.getEmployee(id);  
    }  
	
	
}
