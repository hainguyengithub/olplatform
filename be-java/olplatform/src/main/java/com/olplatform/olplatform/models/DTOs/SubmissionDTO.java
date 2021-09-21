package com.olplatform.olplatform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.Submission.Submission;
import java.util.Date;
import lombok.Data;

@Data
public class SubmissionDTO {
  protected Long id;

  protected Float grade;

  protected Float weight;

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

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd HH:mm:ss Z",
    timezone = "America/Toronto"
  )
  protected Date submissionDate;

  public static SubmissionDTO from(Submission submission) {
    SubmissionDTO dto = new SubmissionDTO();
    dto.setId(submission.getId());
    dto.setGrade(submission.getGrade());
    dto.setWeight(submission.getWeight());
    dto.setStartDate(submission.getStartDate());
    dto.setEndDate(submission.getEndDate());
    dto.setSubmissionDate(submission.getSubmissionDate());
    return dto;
  }
}
