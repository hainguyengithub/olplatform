package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.Instructor.Instructor;
import lombok.Data;

@Data
public class PlainInstructorDTO {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  protected long salary;

  protected String sin;

  public static PlainInstructorDTO from(Instructor instructor) {
    PlainInstructorDTO dto = new PlainInstructorDTO();
    dto.setId(instructor.getId());
    dto.setFirstName(instructor.getFirstName());
    dto.setLastName(instructor.getLastName());
    dto.setUsername(instructor.getUsername());
    dto.setPassword(instructor.getPassword());
    dto.setEmail(instructor.getEmail());
    dto.setPhoneNumber(instructor.getPhoneNumber());
    dto.setSalary(instructor.getSalary());
    dto.setSin(instructor.getSin());
    return dto;
  }
}
