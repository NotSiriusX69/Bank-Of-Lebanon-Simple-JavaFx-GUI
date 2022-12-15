package com.bank.bank_of_lebanon;

public class Employee {

    private String id,email,password;
    private double salary;

    public Employee(String id, String email, String password, double salary) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
