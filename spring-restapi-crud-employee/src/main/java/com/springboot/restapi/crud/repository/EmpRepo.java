package com.springboot.restapi.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.crud.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
