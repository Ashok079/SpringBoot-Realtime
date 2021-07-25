package com.springboot.restapi.crud.service;

import java.util.List;

import com.springboot.restapi.crud.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public List<Employee> getAllEmps();

	public Employee getEmpById(int eid);

	public void deleteEmp(int eid);
}
