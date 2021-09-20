package com.olplatform.olplatform.models.Program;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.interfaces.Manageable;
import com.olplatform.olplatform.interfaces.Terminable;
import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;
import com.olplatform.olplatform.models.DTOs.ProgramDTO;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Program implements Terminable, Manageable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id = 0L;

  protected String name;

  @Column(length = 1000)
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

  @ManyToOne
  protected AcademicAdvisor academicAdvisor;

  public Program() {
    super();
  }

  protected Program(
    long id,
    String name,
    String description,
    Date startDate,
    Date endDate,
    AcademicAdvisor academicAdvisor
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.academicAdvisor = academicAdvisor;
  }

  public AcademicAdvisor getAcademicAdvisor() {
    return academicAdvisor;
  }

  public void setAcademicAdvisor(AcademicAdvisor academicAdvisor) {
    this.academicAdvisor = academicAdvisor;
  }

  public static Program from(ProgramDTO programDTO) {
    Program program = new Program();
    program.setId(programDTO.getId());
    program.setName(programDTO.getName());
    program.setDescription(programDTO.getDescription());
    program.setStartDate(programDTO.getStartDate());
    program.setEndDate(programDTO.getEndDate());
    return program;
  }
}
