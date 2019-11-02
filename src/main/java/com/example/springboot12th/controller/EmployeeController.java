package com.example.springboot12th.controller;
import com.example.springboot12th.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees") //Main Path
//@Controller
public class EmployeeController {

//    @RequestMapping("/employees")
//    @ResponseBody
    @GetMapping
    public List<Employee> list(@RequestParam(required = false) String firstName){ //required = false that is mean param not required receive

        System.out.println("parameter firstName : "+ firstName);

        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Twin");
        employee.setLastName("Chaimakum");

        employeeList.add(employee);

        return employeeList;
    }

//    @RequestMapping("/employees/{id}")
//    @ResponseBody
    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("Twin");
        employee.setLastName("Chaimakum");
        return employee;
    }

//    @RequestMapping(value = "/employees", method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping
    public void create(@RequestBody Employee employeeParam){
        System.out.println("id : " + employeeParam.getId());
        System.out.println("FirstName : " + employeeParam.getFirstName());
        System.out.println("LastName : " + employeeParam.getLastName());
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Employee employeeParam){
        System.out.println("============== ID ==================");
        System.out.println("id : " +id);

        System.out.println("============== Data Updated ==================");
        System.out.println("id : " + employeeParam.getId());
        System.out.println("FirstName : " + employeeParam.getFirstName());
        System.out.println("LastName : " + employeeParam.getLastName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("============== ID ==================");
        System.out.println("Delete id : " +id);
    }

}
