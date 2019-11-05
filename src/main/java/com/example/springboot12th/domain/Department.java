package com.example.springboot12th.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DEPARTMENT")
public class Department {

    @GeneratedValue //Auto increament
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DEPARTNAME")
    private String departName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department (){

    }

    public Department(String departName) {
        this.departName = departName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
