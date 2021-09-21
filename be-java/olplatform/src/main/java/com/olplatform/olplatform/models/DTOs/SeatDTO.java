package com.olplatform.olplatform.models.DTOs;

import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainClassroomDTO;
import com.olplatform.olplatform.models.DTOs.PlainDTOs.PlainStudentDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SeatDTO {
  protected Long id;

  /* A classroom loads a list of SeatDTO (this); Hence, just load basic info of a classroom, without any list. */
  protected PlainClassroomDTO classroom;

  protected PlainStudentDTO student;

  /* All submissions of a seat should be loaded and transferred too. */
  protected List<SubmissionDTO> submissionsDTO = new ArrayList<>();
}
