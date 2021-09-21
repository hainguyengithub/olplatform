package com.olplatform.olplatform.models.DTOs.PlainDTOs;

import lombok.Data;

@Data
public class PlainClassroomDTO {
  protected Long id;

  protected PlainProgramDTO plainProgramDTO;

  protected PlainCourseDTO plainCourseDTO;

  protected PlainInstructorDTO instructor;
}
