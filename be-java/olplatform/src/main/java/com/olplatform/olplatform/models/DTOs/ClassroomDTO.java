package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Course.Course;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainCourseDTO;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainInstructorDTO;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainProgramDTO;
import com.olplatform.olplatform.models.Instructor.Instructor;
import com.olplatform.olplatform.models.Program.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class ClassroomDTO {
  protected Long id;

  protected PlainProgramDTO plainProgramDTO;

  protected PlainCourseDTO plainCourseDTO;

  protected PlainInstructorDTO instructor;

  protected List<SeatDTO> seats = new ArrayList<>();

  public static ClassroomDTO from(Classroom classroom) {
    ClassroomDTO classroomDTO = new ClassroomDTO();

    classroomDTO.setId(classroom.getId());

    Program program_ = classroom.getProgram();
    if (Objects.nonNull(program_)) {
      PlainProgramDTO dto = PlainProgramDTO.from(program_);
      classroomDTO.setPlainProgramDTO(dto);
    }

    Course course_ = classroom.getCourse();
    if (Objects.nonNull(course_)) {
      PlainCourseDTO dto = PlainCourseDTO.from(course_);
      classroomDTO.setPlainCourseDTO(dto);
    }

    Instructor instructor_ = classroom.getInstructor();
    if (Objects.nonNull(instructor_)) {
      PlainInstructorDTO dto = PlainInstructorDTO.from(instructor_);
      classroomDTO.setInstructor(dto);
    }

    return classroomDTO;
  }
}
