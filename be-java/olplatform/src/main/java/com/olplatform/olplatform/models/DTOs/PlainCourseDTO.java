package com.olplatform.olplatform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.Course.Course;
import java.util.Date;
import lombok.Data;

@Data
public class PlainCourseDTO {
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

  protected String code;

  public static PlainCourseDTO from(Course course) {
    PlainCourseDTO dto = new PlainCourseDTO();
    dto.setId(course.getId());
    dto.setName(course.getName());
    dto.setDescription(course.getDescription());
    dto.setStartDate(course.getStartDate());
    dto.setEndDate(course.getEndDate());
    dto.setCode(course.getCode());
    return dto;
  }
}
