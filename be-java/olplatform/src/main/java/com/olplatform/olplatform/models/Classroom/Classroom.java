package com.olplatform.olplatform.models.Classroom;

import com.olplatform.olplatform.models.Course.Course;
import com.olplatform.olplatform.models.Instructor.Instructor;
import com.olplatform.olplatform.models.Program.Program;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * N-N relationship between Program and Course captured in classroom entity.
 *
 * For example, a course in a program could have too many students and they need
 * to be assigned to various classrooms (classes, sections, etc.).
 */
@Entity
public class Classroom {
  @Id
  protected Long id;

  @ManyToOne
  @JoinColumn(name = "program.id")
  protected Program program;

  @ManyToOne
  @JoinColumn(name = "course.id")
  protected Course course;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(
    name = "instructor_id",
    referencedColumnName = "id",
    nullable = false
  )
  protected Instructor instructor;
}
