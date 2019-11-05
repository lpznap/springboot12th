package com.example.springboot12th.repository;

import com.example.springboot12th.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataJpaRepository extends JpaRepository<Employee, Integer> {

}
