package com.example.springboot12th.domain;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @GeneratedValue //Auto increament
    @Id
    @Column(name ="ID")
    private Integer id;

    @Column(name ="FIRSTNAME")
    private String firstName;

    @Column(name ="LASTNAME")
    private String lastName;

    @ManyToOne
    private Department department;

    public Employee(){

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
