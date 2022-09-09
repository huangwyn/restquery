package com.quintrix.restquery.dao;

import com.quintrix.restquery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestDaoImpl implements RestDao {
  @Autowired
  RestTemplate restTemplate;

  @Value("${employee.url}")
  String URL;

  @Override
  public List<Employee> getEmployees(){
    try {
      ResponseEntity<List<Employee>>
          response = ResponseEntity.ok(restTemplate.getForObject(URL, List.class));
      return response.getBody();
    } catch (RestClientException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Employee postEmployee(Employee employee){
    HttpEntity<Employee> request = new HttpEntity<>(employee);
    return restTemplate.postForObject(URL, request, Employee.class);
  }

  @Override
  public void deleteEmployee(String name, int id){
    restTemplate.delete(URL + "/"+ name + "/" + id);
  }

  @Override
  public void putEmployee(Employee employee){
    HttpEntity<Employee> request = new HttpEntity<>(employee);
    restTemplate.put(URL, request);
  }
}
