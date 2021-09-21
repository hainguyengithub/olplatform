package com.olplatform.olplatform.models.DTOs.PlainDTOs;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Course.Course;
import com.olplatform.olplatform.models.DTOs.ProgramDTO;
import com.olplatform.olplatform.models.Instructor.Instructor;
import com.olplatform.olplatform.models.Program.Program;
import java.util.Objects;
import lombok.Data;

@Data
public class PlainClassroomDTO {
  protected Long id;

  protected PlainProgramDTO plainProgramDTO;

  protected PlainCourseDTO plainCourseDTO;

  protected PlainInstructorDTO instructor;

  public static PlainClassroomDTO from(Classroom classroom) {
    PlainClassroomDTO dto = new PlainClassroomDTO();
    dto.setId(classroom.getId());

    Program program_ = classroom.getProgram();
    if (Objects.nonNull(program_)) {
      dto.setPlainProgramDTO(PlainProgramDTO.from(program_));
    }

    Course course_ = classroom.getCourse();
    if (Objects.nonNull(course_)) {
      dto.setPlainCourseDTO(PlainCourseDTO.from(course_));
    }

    Instructor instructor_ = classroom.getInstructor();
    if (Objects.nonNull(instructor_)) {
      dto.setPlainInstructorDTO(PlainInstructorDTO.from(instructor_));
    }

    return dto;
  }
}
