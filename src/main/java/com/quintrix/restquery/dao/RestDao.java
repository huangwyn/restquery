package com.quintrix.restquery.dao;

import com.quintrix.restquery.model.Employee;

import java.util.List;

public interface RestDao {
  public List<Employee> getEmployees();
  public Employee postEmployee(Employee employee);
  public void deleteEmployee(String name, int id);
  public void putEmployee(Employee employee);
}

