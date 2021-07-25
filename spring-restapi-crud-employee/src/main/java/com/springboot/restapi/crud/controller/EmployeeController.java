package com.springboot.restapi.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.crud.model.Employee;
import com.springboot.restapi.crud.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(service.getAllEmps());
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(service.createEmployee(employee));
	}

	@GetMapping("/employee/{empID}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int empID) {
		return ResponseEntity.ok().body(this.service.getEmpById(empID));
	}

	@PutMapping("/employee/{empID}")
	public ResponseEntity<Employee> updateEmpById(@PathVariable int empID, @RequestBody Employee employee) {
		employee.setEmpId(empID);
		return ResponseEntity.ok().body(service.updateEmployee(employee));
	}

	@DeleteMapping("/employee/{eid}")
	public HttpStatus delEmployee(@PathVariable int eid) {
		this.service.deleteEmp(eid);
		return HttpStatus.OK;
	}

}
