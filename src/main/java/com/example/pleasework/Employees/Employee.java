package com.example.pleasework.Employees;


import jakarta.persistence.*;

@Entity
@Table(name = "employeelist")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department;

    public Employee(Long id, String name, String email, String department)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Employee()
    {

    }

    public Employee(String name, String email, String department)
    {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }
}
