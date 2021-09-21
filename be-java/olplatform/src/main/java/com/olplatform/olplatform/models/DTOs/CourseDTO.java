package com.olplatform.olplatform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.Course.Course;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class CourseDTO {
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

  protected List<ClassroomDTO> classroomsDTO = new ArrayList<>();

  public CourseDTO from(Course course) {
    CourseDTO dto = new CourseDTO();
    dto.setId(course.getId());
    dto.setName(course.getName());
    dto.setDescription(course.getDescription());
    dto.setStartDate(course.getStartDate());
    dto.setEndDate(course.getEndDate());
    dto.setCode(course.getCode());
    dto.setClassroomsDTO(
      course
        .getClassrooms()
        .stream()
        .map(ClassroomDTO::from)
        .collect(Collectors.toList())
    );
    return dto;
  }
}
