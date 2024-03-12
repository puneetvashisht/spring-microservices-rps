package com.rps.springbootjpademo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepsitory extends JpaRepository<Employee, Integer>{

}
