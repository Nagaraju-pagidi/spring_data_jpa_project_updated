**Spring Boot Employee CRUD API**

This project is a simple Spring Boot application where we can store, update, delete and read employee records using REST API.
It also supports searching employees by name, department etc.

**What the project does?**

✔ Add new employee
✔ Get all employees
✔ Get employee by ID
✔ Search employee by name
✔ Search using name + address
✔ Find max salary based on department
✔ Get employees from multiple departments
✔ Update employee
✔ Delete one or all employees

**Base URL**
http://localhost:8080/employees

API Endpoints 
Work	API
Welcome message	GET /employees/msg
Save an employee	POST /employees/save
Get all employees	GET /employees/getAll
Get employee by id	GET /employees/get/{id}
Get employee by name	GET /employees/getByName?name=xyz
Get by name + address	GET /employees/getByNameAndAddress?name=xyz&addr=abc
Maximum salary by department	GET /employees/maxSalary?department=xyz
Employees by multiple departments	POST /employees/getByDepartments
Delete all employees	DELETE /employees/deleteAll
Delete employee by ID	DELETE /employees/delete/{id}
Update employee details	PATCH /employees/update/{id}

Example JSON for saving employee
{
  "name": "Raju",
  "address": "Hyd",
  "department": "IT",
  "salary": 50000
}

**Technologies Used**
Spring Boot
Spring Web
Spring Data JPA
MySQL Database
(React can be used as frontend – CORS allowed)
