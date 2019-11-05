package com.example.springboot12th.controller;
import com.example.springboot12th.domain.Employee;
import com.example.springboot12th.repository.EmployeeDataJpaRepository;
import com.example.springboot12th.response.EmployeeDepartmentResponse;
import com.example.springboot12th.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees") //Main Path
//@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDataJpaRepository employeeDataJpaRepository;

    @Autowired
    private EmployeeService employeeService;
//    @RequestMapping("/employees")
//    @ResponseBody
    @GetMapping("/{id}/department")
    public EmployeeDepartmentResponse getDepartment(@PathVariable Integer id){
        return employeeService.getDepartment(id);
    }

    @GetMapping
    public List<Employee> list(@RequestParam(required = false) String firstName){ //required = false that is mean param not required receive

        System.out.println("parameter firstName : "+ firstName);
//
//        return employeeService.list();
        if(firstName != null){
            return employeeService.getName(firstName);
        }
//        return employeeService.list();
        return employeeDataJpaRepository.findAll();
    }

//    @RequestMapping("/employees/{id}")
//    @ResponseBody
    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id){
//        Employee employee = new Employee();
//        employee.setId(id);
//        employee.setFirstName("Twin");
//        employee.setLastName("Chaimakum");
//        return employee;
//        return employeeRepository.get(id);
        return employeeService.get(id);
//        return employeeDataJpaRepository.findById(id).get();
    }

//    @RequestMapping(value = "/employees", method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping
    public void create(@RequestBody Employee employeeParam){
        System.out.println("FirstName : " + employeeParam.getFirstName());
        System.out.println("LastName : " + employeeParam.getLastName());
//        employeeRepository.save(employeeParam);
        employeeService.save(employeeParam);

    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Employee employeeParam){
        System.out.println("============== ID ==================");
        System.out.println("id : " +id);
//        Employee employeeEntity =  employeeRepository.get(id);
//        employeeEntity.setFirstName(employeeParam.getFirstName());
//        employeeEntity.setLastName(employeeParam.getLastName());
//        employeeRepository.save(employeeEntity);
        employeeService.update(id, employeeParam);
        System.out.println("============== Data Updated ==================");
        System.out.println("id : " +id);
        System.out.println("FirstName : " + employeeParam.getFirstName());
        System.out.println("LastName : " + employeeParam.getLastName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("============== ID ==================");
        System.out.println("Delete id : " +id);
//        Employee employee = employeeRepository.get(id);
//        employeeRepository.delete(employee);

        employeeService.delete(id);
    }

}
