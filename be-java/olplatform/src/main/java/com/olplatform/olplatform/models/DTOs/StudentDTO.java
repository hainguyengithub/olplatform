package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.Student.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class StudentDTO {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  protected List<SeatDTO> seatsDTO = new ArrayList<>();

  public static StudentDTO from(Student student) {
    StudentDTO dto = new StudentDTO();
    dto.setId(student.getId());
    dto.setFirstName(student.getFirstName());
    dto.setLastName(student.getLastName());
    dto.setUsername(student.getUsername());
    dto.setPassword(student.getPassword());
    dto.setEmail(student.getEmail());
    dto.setPhoneNumber(student.getPhoneNumber());
    dto.setSeatsDTO(
      student
        .getSeats()
        .stream()
        .map(SeatDTO::from)
        .collect(Collectors.toList())
    );
    return dto;
  }
}
