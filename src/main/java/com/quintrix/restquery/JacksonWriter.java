package com.quintrix.restquery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.restquery.model.Employee;

import java.io.File;
import java.io.IOException;

public class JacksonWriter {
  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();

    // Java object to JSON file
    try {
      mapper.writeValue(new File("test.json"), new Employee("billy", 2));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // Java object to JSON string
    String jsonString = null;
    try {
      jsonString = mapper.writeValueAsString(new Employee("Bob", 1));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    System.out.println(jsonString);
  }
}
