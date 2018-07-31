package com.fil.tuck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.tuck.model.Employee;
import com.fil.tuck.model.EmployeeRepository;

@Service  
public class EmployeeService {

	@Autowired  
    private EmployeeRepository employeeRepository;  
	
    public List<Employee> getAllEmployee(){  
        List<Employee> employeeRecords = new ArrayList<>();  
        employeeRepository.findAll().forEach(e -> employeeRecords.add(e));    //lambda expression
        return employeeRecords;  
    }
    
    public Optional<Employee> getEmployee(String id){  
        return employeeRepository.findById(id);  
    }
    
    public void addEmployee(Employee e){  
        employeeRepository.save(e);  
    }
    
    public void deleteEmployee(Employee e){  
        employeeRepository.delete(e);  
    }  
	
	
}
