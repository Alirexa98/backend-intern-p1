package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTranslatorTest {

  private EmployeeTranslator classUnderTest;

  @BeforeEach
  public void init() {
    classUnderTest = EmployeeTranslator.getInstance();
  }

  @Test
  public void testEmployeeDecoding() {
    String testJson = "[{\n" +
        "        \"id\": 3050,\n" +
        "        \"name\": \"Neeraj1993\",\n" +
        "        \"email\": \"neeraj.singh@adequateinfosoft.com\",\n" +
        "        \"password\": \"286956\",\n" +
        "        \"about\": null,\n" +
        "        \"token\": \"562c2fb5-6799-4b51-8733-a60564c96adc\",\n" +
        "        \"country\": null,\n" +
        "        \"location\": null,\n" +
        "        \"lng\": 0,\n" +
        "        \"lat\": 0,\n" +
        "        \"dob\": null,\n" +
        "        \"gender\": 0,\n" +
        "        \"userType\": 1,\n" +
        "        \"userStatus\": 1,\n" +
        "        \"profilePicture\": null,\n" +
        "        \"coverPicture\": null,\n" +
        "        \"enablefollowme\": false,\n" +
        "        \"sendmenotifications\": false,\n" +
        "        \"sendTextmessages\": false,\n" +
        "        \"enabletagging\": false,\n" +
        "        \"createdAt\": \"2019-12-27T10:16:05.6578091\",\n" +
        "        \"updatedAt\": \"2019-12-27T10:22:30.8416992\",\n" +
        "        \"livelng\": 77.389849,\n" +
        "        \"livelat\": 28.6282231,\n" +
        "        \"liveLocation\": \"Unnamed Road, Chhijarsi, Sector 63, Noida, Uttar Pradesh 201307, India\",\n" +
        "        \"creditBalance\": 0,\n" +
        "        \"myCash\": 0\n" +
        "    }]";

    var result = assertDoesNotThrow(
        () -> classUnderTest.decodeEmployeesFromJson(testJson),
        "Should not throw exception"
    );
    assertNotNull(result);
    assertEquals(1, result.size(), "Result Size Should Be One");
    var employee = result.get(0);
    assertEquals(3050, employee.getId());
    assertEquals("286956", employee.getPassword());
    // todo: testing other fields later or overriding equals method for Employee class
  }

  @Test
  void testEmployeeEncoding() {
    var input = new LinkedList<Employee>() {
      {
        add(new Employee());
      }
    };
    var result = assertDoesNotThrow(
        () -> classUnderTest.encodeEmployeesToXml(input),
        "Should not throw exception"
    );
    assertNotNull(result);
    // todo: testing result with expected
  }
}