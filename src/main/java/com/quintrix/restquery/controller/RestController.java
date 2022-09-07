package com.quintrix.restquery.controller;

import com.quintrix.restquery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/employee")
    public String getEmployees(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/employee", String.class);
        return response.getBody() + " \n" + response.getStatusCode() + " \n" + response.getHeaders() + " \n" + response.getStatusCodeValue();
    }

    @PostMapping("/employee")
    public String postEmployee(@RequestBody Employee employee){
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        return restTemplate.postForObject("http://localhost:8080/employee", request, String.class);
    }

    @DeleteMapping("/employee/{name}/{id}")
    public void deleteEmployee(@PathVariable String name, @PathVariable int id){
        restTemplate.delete("http://localhost:8080/employee/"+ name + "/" + id);
    }

    @PutMapping("/employee")
    public void putEmployee(@RequestBody Employee employee){
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        restTemplate.put("http://localhost:8080/employee/", request);
    }
}
