package com.olplatform.olplatform.models.Registration;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Student.Student;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * N-N relationship between Classroom and Student captured in a new Entity.
 * A student could attend N classrooms. A classroom could have N students.
 */
@Entity
@Data
@Table(name = "class_registration")
public class ClassRegistration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "classroom_id")
  protected Classroom classroom;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  protected Student student;
  // // @todo: Evaluations
}
