package org.example;

import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) {
    var app = new EmployeeApplication(new EmployeeTranslator(), Paths.get("./EmployeeData.json"), Paths.get("./EmployeeData.xml"));
    System.out.println("Translating Started...");
    try {
      app.start();
      System.out.println("Writing Done!");
    } catch (Exception e) {
      System.out.println("Operation Failed!");
      e.printStackTrace();
    }
  }
}