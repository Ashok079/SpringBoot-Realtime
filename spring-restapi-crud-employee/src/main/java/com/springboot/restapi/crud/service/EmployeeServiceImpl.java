package com.springboot.restapi.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.restapi.crud.exception.EmployeeException;
import com.springboot.restapi.crud.model.Employee;
import com.springboot.restapi.crud.repository.EmpRepo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepo repo;

	@Override
	public Employee createEmployee(Employee employee) {
		return this.repo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Optional<Employee> empDB = this.repo.findById(employee.getEmpId());

		if (empDB.isPresent()) {
			Employee empUpdate = empDB.get();
			empUpdate.setEmpId(employee.getEmpId());
			empUpdate.setEmpName(employee.getEmpName());
			empUpdate.setEmpSal(employee.getEmpSal());
			repo.save(empUpdate);
			return empUpdate;
		} else {
			throw new EmployeeException("Rsource not found with the id :" + employee.getEmpId());
		}

	}

	@Override
	public List<Employee> getAllEmps() {
		return this.repo.findAll();
	}

	@Override
	public Employee getEmpById(int eid) {
		Optional<Employee> empDb = this.repo.findById(eid);
		if (empDb.isPresent()) {
			return empDb.get();
		} else {
			throw new EmployeeException("Resource not found with the id : " + eid);
		}
	}

	@Override
	public void deleteEmp(int eid) {
		Optional<Employee> empDb = this.repo.findById(eid);
		if (empDb.isPresent()) {
			repo.deleteById(eid);
		} else {
			throw new EmployeeException("Resource not found with the id : " + eid);
		}

	}

}
