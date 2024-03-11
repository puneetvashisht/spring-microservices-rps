package com.rps.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	List<Employee> employees =  new ArrayList<>();
	
	{
		employees.add(new Employee(1, "Ravi", 343343.34));
		employees.add(new Employee(2, "Priya", 44444.34));
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public List<Employee> fetchEmployees(){
		return employees;
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST , produces = {"application/json" , "application/xml"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		
	}

	// delete employee
	@RequestMapping(path = "/employees/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteEmployee(@PathVariable("id") int id) {
		
		Employee emp = null;
		for(Employee e : employees) {
			if(e.getId() == id) {
				emp = e;
				break;
			}
		}
		if(emp != null) {
			employees.remove(emp);
		}
	}

	// get employee by id
	@RequestMapping(path = "/employees/{id}", method = RequestMethod.GET)
	public Employee fetchEmployee(@PathVariable("id") int id) {
		Employee emp = null;
		for(Employee e : employees) {
			if(e.getId() == id) {
				emp = e;
				break;
			}
		}

		if(emp == null) {
			throw new EmployeeNotFoundException("Employee not found");
		}

		return emp;
	}

	// update employee salary
	@RequestMapping(path = "/employees/{id}", method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.OK)
	public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee emp = null;
		for(Employee e : employees) {
			if(e.getId() == id) {
				emp = e;
				break;
			}
		}
		if(emp != null) {
			emp.setSalary(employee.getSalary());
		}
	}
}
