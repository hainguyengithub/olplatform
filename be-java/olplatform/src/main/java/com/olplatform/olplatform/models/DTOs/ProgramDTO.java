package com.olplatform.olplatform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainAcademicAdvisorDTO;
import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class ProgramDTO {
  protected long id;

  protected String name;

  protected String description;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd HH:mm:ss Z",
    timezone = "America/Toronto"
  )
  protected Date startDate;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd HH:mm:ss Z",
    timezone = "America/Toronto"
  )
  protected Date endDate;

  protected PlainAcademicAdvisorDTO plainAcademicAdvisorDTO;

  protected List<ClassroomDTO> classroomsDTO = new ArrayList<>();

  public static ProgramDTO from(Program program) {
    ProgramDTO programDTO = new ProgramDTO();
    programDTO.setId(program.getId());
    programDTO.setName(program.getName());
    programDTO.setDescription(program.getDescription());
    programDTO.setStartDate(program.getStartDate());
    programDTO.setEndDate(program.getEndDate());
    if (Objects.nonNull(program.getAcademicAdvisor())) {
      programDTO.setPlainAcademicAdvisorDTO(
        PlainAcademicAdvisorDTO.from(program.getAcademicAdvisor())
      );
    }
    programDTO.setClassroomsDTO(
      program
        .getClassrooms()
        .stream()
        .map(ClassroomDTO::from)
        .collect(Collectors.toList())
    );
    return programDTO;
  }
}
