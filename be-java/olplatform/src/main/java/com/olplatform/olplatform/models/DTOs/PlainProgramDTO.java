package com.olplatform.olplatform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;
import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class PlainProgramDTO {
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

  public static PlainProgramDTO from(Program program) {
    PlainProgramDTO dto = new PlainProgramDTO();
    dto.setId(program.getId());
    dto.setName(program.getName());
    dto.setDescription(program.getDescription());
    dto.setStartDate(program.getStartDate());
    dto.setEndDate(program.getEndDate());
    AcademicAdvisor academicAdvisor_ = program.getAcademicAdvisor();
    if (Objects.nonNull(academicAdvisor_)) {
      PlainAcademicAdvisorDTO plainAcademicAdvisorDTO = PlainAcademicAdvisorDTO.from(
        academicAdvisor_
      );
      dto.setPlainAcademicAdvisorDTO(plainAcademicAdvisorDTO);
    }
    return dto;
  }
}
