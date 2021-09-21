package com.olplatform.olplatform.models.DTOs.PlainDTOs;

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
}
