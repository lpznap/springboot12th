package com.example.springboot12th.response;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//For response not table
@Entity
public class EmployeeDepartmentResponse {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lasttName;

    @Column(name = "DEPARTMENT")
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
