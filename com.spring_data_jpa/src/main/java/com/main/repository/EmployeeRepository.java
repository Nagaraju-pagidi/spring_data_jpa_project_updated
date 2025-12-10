package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//finding employee by name
	public Optional<Employee> findByName(String name);
	
	//find emp by name and address
	public Optional<Employee> findByNameAndAddr(String name, String addr);
	
	//byUsing @query annotation we can write out sql queries manually
	@Query("select max(e.salary) from Employee e where e.department = ?1")
	public Optional<Double> maxSal(String departmet);
	
	//find emps that are present in given department list
	@Query("select e from Employee e where e.department in ?1")
	public Optional<List<Employee>> getEmps(List<String> departments);
	
	
}
