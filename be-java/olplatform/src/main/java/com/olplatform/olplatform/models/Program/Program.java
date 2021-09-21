package com.olplatform.olplatform.models.Program;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;
import com.olplatform.olplatform.models.Administrable;
import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.DTOs.ProgramDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "program")
@Data
@EqualsAndHashCode(callSuper = true)
public class Program extends Administrable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id = 0L;

  @Column(length = 255)
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

  // /**
  //  * Program entity owns the relationship. Hence, "mappedBy" is not used in the
  //  * @ManyToMany annotation. Therefore, Course entity has to specify "mappedBy"
  //  * in that annotation.
  //  */
  // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  // @JoinTable(
  //   name = "program_course",
  //   joinColumns = @JoinColumn(name = "program_id"),
  //   inverseJoinColumns = @JoinColumn(name = "course_id")
  // )
  // protected List<Course> courses = new ArrayList<Course>();

  @OneToMany(mappedBy = "program")
  protected List<Classroom> classrooms = new ArrayList<>();

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

  // public void addCourse(Course course) {
  //   this.courses.add(course);
  // }

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
