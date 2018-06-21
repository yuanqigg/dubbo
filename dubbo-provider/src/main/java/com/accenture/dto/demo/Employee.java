package com.accenture.dto.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="employee")
public class Employee implements  Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    public Employee(){};

    public Employee(String firstName,String lastName,int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    };
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transient
    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
