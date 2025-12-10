package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Employee;
import com.main.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/msg")
	public String getMsg() {
		return "WELCOME TO SPRING BOOT AND REACT";
	}
	
	

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee) {
		Employee saveEmp = employeeService.saveEmp(employee);
		return ResponseEntity //just class name
				.status(HttpStatus.CREATED) // setting status as created
				.header("appname", "empjpa") //creating header in response object
				.body(saveEmp); //adding result object in response body
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(employeeService.getAll());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity getempById(@PathVariable int id) {
		Employee dbEmp = employeeService.getById(id);
		if (dbEmp == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("emp not present in db with given id:" + id);
		}

		return ResponseEntity //class name
				.status(HttpStatus.FOUND) //adding response status
				.body(dbEmp); // adding result in response body

	}

	@GetMapping("/getbyname")
	public ResponseEntity getByName(
			@RequestParam String name) {
		return new ResponseEntity(employeeService.findByName(name), HttpStatus.FOUND);
	}
	
	@GetMapping("/getByNameAndAddress")
	public ResponseEntity getByNameAndAddress(
			@RequestParam String name,
			@RequestParam String addr
			) {
		Employee byNameAndAddr = employeeService.findByNameAndAddr(name, addr);
		if(byNameAndAddr==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DATA not found with this data, Name: "+ name + " , address : "+ addr );
		else
			return new ResponseEntity(employeeService.findByNameAndAddr(name, addr), HttpStatus.FOUND);
	}

	@GetMapping("/maxsal")
	public ResponseEntity max(@RequestParam String department) {
		//storing result in variable
		Double maxSal = employeeService.maxSal(department);
		return ResponseEntity.ok(maxSal);
	}
	
	@GetMapping("/getEmpByDepartments")
	public ResponseEntity getEmpsByListOfDepartments(@RequestBody List<String> departmentList) {
		//storing result in variable
		List<Employee> empFromGivenDepartmentList = employeeService.getEmpFromGivenDepartmentList(departmentList);
		return ResponseEntity.ok(empFromGivenDepartmentList);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity deleteAll() {
		employeeService.deleteAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteById(@PathVariable int id) {
		employeeService.deleteEmpById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity updateEmp(
			@PathVariable int id,
			@RequestBody Employee newEmp
			) {
		
		Employee updatedEmployee = employeeService.updateEmployee(id, newEmp);
		if(updatedEmployee==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMP NOT AVAILABLE WITH this Id : " + id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
		
	}
	

}
