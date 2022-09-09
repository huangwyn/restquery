package com.quintrix.restquery.controller;

import com.quintrix.restquery.model.Employee;
import com.quintrix.restquery.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    RestService restService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){

        return restService.getEmployees();
    }

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){
        return restService.postEmployee(employee);
    }

    @DeleteMapping("/employee/{name}/{id}")
    public void deleteEmployee(@PathVariable String name, @PathVariable int id){
        restService.deleteEmployee(name, id);
    }

    @PutMapping("/employee")
    public void putEmployee(@RequestBody Employee employee){
        restService.putEmployee(employee);
    }
}
