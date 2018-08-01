package com.fil.SmarTuck.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.SmarTuck.models.Employee;
import com.fil.SmarTuck.models.EmployeeRepository;

@Service  
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired  
    private EmployeeRepository employeeRepository;  
	
	@Override
    public List<Employee> getAllEmployees(){  
        List<Employee> employeeRecords = new ArrayList<>();  
        employeeRepository.findAll().forEach(e -> employeeRecords.add(e));    //lambda expression
        return employeeRecords;  
    }
    
	@Override
    public Optional<Employee> getEmployeeById(String aId){  
        return employeeRepository.findById(aId);  
    }
    
	@Override
    public void addEmployee(Employee e){  
        employeeRepository.save(e);  
    }
    
	@Override
    public void deleteEmployee(Employee e){  
        employeeRepository.delete(e);  
    }  
	
	@Override
    public Boolean validateEmployee(String aId, String password){
    	Optional<Employee> e = new EmployeeServiceImplementation().getEmployeeById(aId);
    	if(e.isPresent()){
    		if(e.get().getPassword().equals(password)){
    			return true;
    		}
    		else{
    			return false;
    		}
    	}  
    	else{
    		return false;
    	}
    }
	
}
