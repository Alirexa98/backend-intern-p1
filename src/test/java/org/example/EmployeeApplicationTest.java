package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmployeeApplicationTest {
  @Mock
  private EmployeeTranslator mockTranslator;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testStart(@TempDir Path dir) throws IOException {
    Path input = Paths.get(dir.toString(), "input.json");
    Path output = Paths.get(dir.toString(), "output.xml");
    String testContent = "Salam";
    Files.writeString(input, testContent, StandardOpenOption.CREATE);
    when(mockTranslator.encodeEmployeesToXml(any())).thenReturn(testContent);

    var classUnderTest = new EmployeeApplication(mockTranslator, input, output);
    classUnderTest.start();

    verify(mockTranslator, Mockito.times(1)).decodeEmployeesFromJson(testContent);
    String actualContent = Files.readString(output);
    assertEquals(testContent, actualContent);
  }
}