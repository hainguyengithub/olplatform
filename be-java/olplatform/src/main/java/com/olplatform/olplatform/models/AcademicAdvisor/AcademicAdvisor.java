package com.olplatform.olplatform.models.AcademicAdvisor;

import com.olplatform.olplatform.models.Person;
import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "academic_advisor")
@DiscriminatorValue("academic_advisor")
public class AcademicAdvisor extends Person {
  /**
   * The "academic_advisor_id" is a column name in the Program table.
   */
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn
  protected List<Program> programs = new ArrayList<Program>();

  public AcademicAdvisor() {}

  public void addProgram(Program program) {
    this.programs.add(program);
  }

  public void deleteProgram(Program program) {
    this.programs.remove(program);
  }

  // @todo from(AcademicDTO)
}
