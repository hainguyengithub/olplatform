package com.olplatform.olplatform.models.Program;

import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;
import com.olplatform.olplatform.models.DTOs.ProgramDTO;
import com.olplatform.olplatform.models.Administrable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Program extends Administrable {
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
    super(id, name, description, startDate, endDate);
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
