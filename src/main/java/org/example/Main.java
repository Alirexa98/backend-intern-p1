package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Translating Started...");
    try {
      List<Employee> result = decodeEmployeesFromJson(
          Files.readString(Paths.get("./EmployeeData.json"))
      );
      System.out.println("Reading Done: Items Count -> " + result.size());
      Files.writeString(
          Paths.get("./EmployeeData.xml"),
          encodeEmployeesToXml(result),
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING
      );
      System.out.println("Writing Done!");
    } catch (Exception e) {
      System.out.println("Operation Failed!");
      e.printStackTrace();
    }
  }

  static List<Employee> decodeEmployeesFromJson(String json) throws JsonProcessingException {
    var objectMapper = new ObjectMapper();
    return objectMapper.readValue(json, new TypeReference<List<Employee>>() {
    });
  }

  static String encodeEmployeesToXml(List<Employee> employees) throws JsonProcessingException {
    var xmlMapper = new XmlMapper();
    return xmlMapper.writeValueAsString(employees);
  }
}