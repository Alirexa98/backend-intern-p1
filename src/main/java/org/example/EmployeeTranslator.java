package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class EmployeeTranslator {
  private XmlMapper xmlMapper = new XmlMapper(); // these objects must be injected in a real-world app
  private ObjectMapper objectMapper = new ObjectMapper();

  private EmployeeTranslator() {}

  private static EmployeeTranslator instance;

  public static EmployeeTranslator getInstance() {
    if (instance == null) {
      instance = new EmployeeTranslator();
    }
    return instance;
  }

  List<Employee> decodeEmployeesFromJson(String json) throws JsonProcessingException {
    return objectMapper.readValue(json, new TypeReference<List<Employee>>() {
    });
  }

  String encodeEmployeesToXml(List<Employee> employees) throws JsonProcessingException {
    return xmlMapper.writeValueAsString(employees);
  }
}
