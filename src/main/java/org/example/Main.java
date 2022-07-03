package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Translating Started...");

        var xmlMapper = new XmlMapper();
        var objectMapper = new ObjectMapper();

        List<Employee> result = new ArrayList<>(0);

        try (var inputStream = Files.newInputStream(Paths.get("./EmployeeData.json"));
             var outputStream = Files.newOutputStream(Paths.get("./EmployeeData.xml"),
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            result = objectMapper.readValue(inputStream, result.getClass());

            System.out.println("Reading Done: Items Count -> " + result.size());

            xmlMapper.writeValue(outputStream, result);

            System.out.println("Writing Done!");
        } catch (Exception e) {
            System.out.println("Operation Failed!");
            e.printStackTrace();
        }
    }
}