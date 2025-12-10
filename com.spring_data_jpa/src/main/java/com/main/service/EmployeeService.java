package com.main.service;

import java.util.List;

import com.main.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmp(Employee employee);
	public Employee getById(int id);
	public void deleteEmpById(int id);
	public List<Employee> getAll();
	public Employee findByName(String name);
	public Employee findByNameAndAddr(String name, String addr);
	public Double maxSal(String departmet);
	public List<Employee> getEmpFromGivenDepartmentList(List<String> departments);
	public void deleteAllEmployees();
	public Employee updateEmployee(int id, Employee newEmp);

}
