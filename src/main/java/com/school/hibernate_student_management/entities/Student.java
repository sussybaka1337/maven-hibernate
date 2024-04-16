package com.school.hibernate_student_management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String address;
    @Column(name = "class_name")
    private String className;
    private double gpa;

    public Student() {

    }

    public Student(String name, String email, String address, String className, double gpa) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.className = className;
        this.gpa = gpa;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    
    public String getClassName() {
        return className;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void printEntity() {
        System.out.println("=====================================");
        System.out.println("Student ID: " + id);
        System.out.println("Student name: " + name);
        System.out.println("Student email: " + email);
        System.out.println("Student address: " + address);
        System.out.println("Student class name: " + className);
        System.out.println("Student GPA: " + gpa);
    }
}
