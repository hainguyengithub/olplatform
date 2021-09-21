package com.olplatform.olplatform.models.DTOs.PlainDTOs;

import com.olplatform.olplatform.models.Student.Student;
import lombok.Data;

@Data
public class PlainStudentDTO {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  public static PlainStudentDTO from(Student student) {
    PlainStudentDTO dto = new PlainStudentDTO();
    dto.setId(student.getId());
    dto.setFirstName(student.getFirstName());
    dto.setLastName(student.getLastName());
    dto.setUsername(student.getUsername());
    dto.setPassword(student.getPassword());
    dto.setEmail(student.getEmail());
    dto.setPhoneNumber(student.getPhoneNumber());
    return dto;
  }
}
