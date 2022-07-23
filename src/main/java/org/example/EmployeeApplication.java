package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EmployeeApplication {

  EmployeeTranslator translator;
  private Path inputFile;
  private Path outputFile;

  public EmployeeApplication(EmployeeTranslator pTranslator, Path pInputFile, Path pOutputFile) {
    translator = pTranslator;
    this.inputFile = pInputFile;
    this.outputFile = pOutputFile;
  }

  public void start() throws IOException {
    List<Employee> result = translator.decodeEmployeesFromJson(
        Files.readString(inputFile)
    );
    Files.writeString(
        outputFile,
        translator.encodeEmployeesToXml(result),
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING
    );
  }

}
