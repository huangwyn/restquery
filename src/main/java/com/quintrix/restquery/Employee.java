package com.quintrix.restquery;

public class Employee {
    String name;
    int employee_id;

    public Employee(String name, int idNumber) {
        this.name = name;
        this.employee_id = idNumber;
    }

    public Employee() {
        this.name = "default";
        this.employee_id = 6969;
    }

    public String getName() {
        return name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", idNumber=" + employee_id +
                '}';
    }
}
