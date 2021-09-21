package com.olplatform.olplatform.models.Course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.models.Administrable;
import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course extends Administrable {
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

  // "courses" is an attribute in the Program class.
  @ManyToMany(
    mappedBy = "courses",
    fetch = FetchType.EAGER,
    cascade = CascadeType.PERSIST
  )
  protected List<Program> programs = new ArrayList<Program>();

  public void addProgram(Program program) {
    this.programs.add(program);
  }
}
