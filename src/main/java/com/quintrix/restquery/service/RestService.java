package com.quintrix.restquery.service;

import com.quintrix.restquery.model.Employee;

import java.util.List;

public interface RestService {
  public List<Employee> getEmployees();
  public Employee postEmployee(Employee employee);
  public void deleteEmployee(String name, int id);
  public void putEmployee(Employee employee);
}
