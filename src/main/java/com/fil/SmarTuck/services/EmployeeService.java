package com.fil.SmarTuck.services;

import java.util.List;
import java.util.Optional;

import com.fil.SmarTuck.models.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
	public Optional<Employee> getEmployee(String aId);
	
	public void addEmployee(Employee e);
	
	public void deleteEmployee(Employee e);
	
	public Boolean validateEmployee(String aId, String password);
	
}
