package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainClassroomDTO;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainStudentDTO;
import com.olplatform.olplatform.models.Seat.Seat;
import com.olplatform.olplatform.models.Student.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class SeatDTO {
  protected Long id;

  /* A classroom loads a list of SeatDTO (this); Hence, just load basic info of a classroom, without any list. */
  protected PlainClassroomDTO plainClassroomDTO;

  protected PlainStudentDTO plainStudentDTO;

  /* All submissions of a seat should be loaded and transferred too. */
  protected List<SubmissionDTO> submissionsDTO = new ArrayList<>();

  public static SeatDTO from(Seat seat) {
    SeatDTO dto = new SeatDTO();
    dto.setId(seat.getId());

    Classroom classroom_ = seat.getClassroom();
    if (Objects.nonNull(classroom_)) {
      dto.setPlainClassroomDTO(PlainClassroomDTO.from(classroom_));
    }

    Student student_ = seat.getStudent();
    if (Objects.nonNull(student_)) {
      dto.setPlainStudentDTO(PlainStudentDTO.from(student_));
    }

    return dto;
  }
}
