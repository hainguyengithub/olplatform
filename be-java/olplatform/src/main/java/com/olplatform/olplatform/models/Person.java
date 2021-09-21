package com.olplatform.olplatform.models;

import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Person {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  // For AcademicAdvisor
  protected List<Program> programs = new ArrayList<Program>();

  // For Instructor
  protected long salary;

  protected String sin;

  public Person() {
    this.id = 0L;
    this.firstName = "";
    this.lastName = "";
    this.username = "";
    this.password = "";
    this.email = "";
    this.phoneNumber = "";
  }

  public Person(
    long id,
    String firstName,
    String lastName,
    String username,
    String password,
    String email,
    String phoneNumber
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
}
