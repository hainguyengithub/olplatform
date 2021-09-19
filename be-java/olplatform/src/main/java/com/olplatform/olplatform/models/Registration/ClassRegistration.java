package com.olplatform.olplatform.models.Registration;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Student.Student;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * N-N relationship between Classroom and Student captured in a new Entity.
 */
@Entity
public class ClassRegistration {
  @Id
  protected Long id;

  @ManyToOne
  @JoinColumn(name = "classroom.id")
  protected Classroom classroom;

  @ManyToOne
  @JoinColumn(name = "person.id")
  protected Student student;

  // @todo: Evaluations
}
