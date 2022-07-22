package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Employee {

  private Integer id;
  private String name;
  private String email;
  private String password;
  private String about;
  private String token;
  private Object country;
  private String location;
  private Integer lng;
  private Integer lat;
  private String dob;
  private Integer gender;
  private Integer userType;
  private Integer userStatus;
  private String profilePicture;
  private String coverPicture;
  private Boolean enablefollowme;
  private Boolean sendmenotifications;
  private Boolean sendTextmessages;
  private Boolean enabletagging;
  private String createdAt;
  private String updatedAt;
  private Double livelng;
  private Double livelat;
  private String liveLocation;
  private Integer creditBalance;
  private Integer myCash;

}