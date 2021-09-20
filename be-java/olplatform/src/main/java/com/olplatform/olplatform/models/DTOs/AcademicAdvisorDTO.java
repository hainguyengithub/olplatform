package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class AcademicAdvisorDTO {
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  protected List<ProgramDTO> programsDTO = new ArrayList<>();

  public static AcademicAdvisorDTO from(AcademicAdvisor academicAdvisor) {
    AcademicAdvisorDTO academicAdvisorDTO = new AcademicAdvisorDTO();
    academicAdvisorDTO.setId(academicAdvisor.getId());
    academicAdvisorDTO.setFirstName(academicAdvisor.getFirstName());
    academicAdvisorDTO.setLastName(academicAdvisor.getLastName());
    academicAdvisorDTO.setUsername(academicAdvisor.getUsername());
    academicAdvisorDTO.setEmail(academicAdvisor.getEmail());
    academicAdvisorDTO.setPhoneNumber(academicAdvisor.getPhoneNumber());
    academicAdvisorDTO.setProgramsDTO(
      academicAdvisor
        .getPrograms()
        .stream()
        .map(ProgramDTO::from)
        .collect(Collectors.toList())
    );
    return academicAdvisorDTO;
  }
}
