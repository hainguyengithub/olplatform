package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;

import lombok.Data;

@Data
public class PlainAcademicAdvisorDTO {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  public static PlainAcademicAdvisorDTO from(AcademicAdvisor academicAdvisor) {
    PlainAcademicAdvisorDTO plainAcademicAdvisorDTO = new PlainAcademicAdvisorDTO();
    plainAcademicAdvisorDTO.setId(academicAdvisor.getId());
    plainAcademicAdvisorDTO.setFirstName(academicAdvisor.getFirstName());
    plainAcademicAdvisorDTO.setLastName(academicAdvisor.getLastName());
    plainAcademicAdvisorDTO.setUsername(academicAdvisor.getUsername());
    plainAcademicAdvisorDTO.setEmail(academicAdvisor.getEmail());
    plainAcademicAdvisorDTO.setPhoneNumber(academicAdvisor.getPhoneNumber());
    return plainAcademicAdvisorDTO;
  }
}
