package com.example.springboot12th.service;

import com.example.springboot12th.domain.Employee;
import com.example.springboot12th.exception.UnprocessableException;
import com.example.springboot12th.repository.EmployeeRepository;
import com.example.springboot12th.response.EmployeeDepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDepartmentResponse getDepartment(Integer id){
        return repository.getEmployeeDepartment(id);
    }

    @Transactional
    public void save (Employee employee){
        repository.save(employee);
    }

    public List<Employee> list(){
        return repository.list();
    }

    @Transactional
    public void update(Integer id, Employee param){
        Employee employee = repository.get(id);
        if(employee == null){
            throw new RuntimeException("Data not found");
        }
        employee.setFirstName(param.getFirstName());
        employee.setLastName(param.getLastName());
        try {
            repository.save(employee);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Data Conflict");
        }
    }

    public Employee get(Integer id){
        Employee employee = repository.get(id);
        if(employee == null){
            throw new UnprocessableException("Data not found");
        }
        return employee;
    }

    public List<Employee> getName(String firstName){
        List<Employee> employee = repository.getName(firstName);
        if(employee == null){
            throw new RuntimeException("Data not found");
        }
        return employee;
    }

    @Transactional
    public void delete(Integer id){
        Employee employee = repository.get(id);
//        if(employee == null){
//            throw new RuntimeException("Data not found");
//        }
        try {
            repository.delete(employee);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
