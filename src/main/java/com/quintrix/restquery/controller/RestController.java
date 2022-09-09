package com.quintrix.restquery.controller;

import com.quintrix.restquery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${employee.url}")
    String URL;

    @GetMapping("/employee")
    public String getEmployees(){
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        return response.getBody();
    }

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        return restTemplate.postForObject(URL, request, Employee.class);
    }

    @DeleteMapping("/employee/{name}/{id}")
    public void deleteEmployee(@PathVariable String name, @PathVariable int id){
        restTemplate.delete(URL + "/"+ name + "/" + id);
    }

    @PutMapping("/employee")
    public void putEmployee(@RequestBody Employee employee){
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        restTemplate.put(URL, request);
    }
}
