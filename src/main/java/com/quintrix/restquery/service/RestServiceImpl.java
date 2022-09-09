package com.quintrix.restquery.service;

import com.quintrix.restquery.dao.RestDao;
import com.quintrix.restquery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestServiceImpl implements RestService{

  @Autowired
  RestDao restDao;

  @Override
  public List<Employee> getEmployees() {
    return restDao.getEmployees();
  }

  @Override
  public Employee postEmployee(Employee employee) {
    return restDao.postEmployee(employee);
  }

  @Override
  public void deleteEmployee(String name, int id) {
    restDao.deleteEmployee(name, id);
  }

  @Override
  public void putEmployee(Employee employee) {
    restDao.putEmployee(employee);
  }
}
