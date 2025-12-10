package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.controller.EmployeeController;
import com.main.model.Employee;
import com.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    
	//creating repository object and injecting object by using autowired annotation
	@Autowired
	private EmployeeRepository employeeRepository;


    
	
	
	//save employee 
	@Override
	public Employee saveEmp(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//find employee by using primary key id
	@Override
	public Employee getById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	//delete employee by id
	@Override
	public void deleteEmpById(int id) {
		employeeRepository.deleteById(id);
	}

	//delete all employees 
	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}
	
	//gel all employees
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	//find employee by name
	@Override
	public Employee findByName(String name) {
		Optional<Employee> optional = employeeRepository.findByName(name);
		if(optional.isEmpty()) {
			return  null;
		}
		//get() method will return emp if emp present in optional class
		return optional.get() ;
	}

	@Override
	public Employee findByNameAndAddr(String name, String addr) {
		Optional<Employee> byNameAndAddr = employeeRepository.findByNameAndAddr(name, addr);
		if(byNameAndAddr.isPresent()) {
			return byNameAndAddr.get();
		}
		return null;
	}

	@Override
	public Double maxSal(String departmet) {
		Optional<Double> maxSal = employeeRepository.maxSal(departmet);
		if(maxSal.isPresent()) {
			return maxSal.get();
		}
		return null;
	}

	@Override
	public List<Employee> getEmpFromGivenDepartmentList(List<String> departments) {
		return employeeRepository.getEmps(departments).get();
		
	}

	@Override
	public Employee updateEmployee(int id, Employee newEmp) {
		//first find emp with given id
		Optional<Employee> optional = employeeRepository.findById(id);
		//check weather emp present r nott
		if(optional.isEmpty()) {
			return null;
		}
		//store into one object
		Employee db_emp = optional.get();
		//update values 
		db_emp.setName(newEmp.getName());
		db_emp.setAddr(newEmp.getAddr());
		db_emp.setDepartment(newEmp.getDepartment());
		db_emp.setSalary(newEmp.getSalary());
		db_emp.setId(id);
		//now update the employee by calling save method
		return employeeRepository.save(db_emp);
	}
	
	
	
	
	
}
