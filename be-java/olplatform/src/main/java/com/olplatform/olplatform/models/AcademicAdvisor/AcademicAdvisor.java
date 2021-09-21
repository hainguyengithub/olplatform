package com.olplatform.olplatform.models.AcademicAdvisor;

import com.olplatform.olplatform.models.Person;
import com.olplatform.olplatform.models.DTOs.AcademicAdvisorDTO;
import com.olplatform.olplatform.models.Program.Program;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "academic_advisor")
public class AcademicAdvisor extends Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  // The "academic_advisor_id" is a column name in the Program table.
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "academic_advisor_id")
  protected List<Program> programs = new ArrayList<Program>();

  public AcademicAdvisor() {
    super();
  }

  public void addProgram(Program program) {
    this.programs.add(program);
  }

  public void deleteProgram(Program program) {
    this.programs.remove(program);
  }

  public static AcademicAdvisor from(AcademicAdvisorDTO academicAdvisorDTO) {
    AcademicAdvisor academicAdvisor = new AcademicAdvisor();
    academicAdvisor.setId(academicAdvisorDTO.getId());
    academicAdvisor.setFirstName(academicAdvisorDTO.getFirstName());
    academicAdvisor.setLastName(academicAdvisorDTO.getLastName());
    academicAdvisor.setUsername(academicAdvisorDTO.getUsername());
    academicAdvisor.setEmail(academicAdvisorDTO.getEmail());
    academicAdvisor.setPhoneNumber(academicAdvisorDTO.getPhoneNumber());
    return academicAdvisor;
  }
}
