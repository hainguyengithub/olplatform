package com.olplatform.olplatform.models.Classroom;

import com.olplatform.olplatform.models.Course.Course;
import com.olplatform.olplatform.models.Instructor.Instructor;
import com.olplatform.olplatform.models.Program.Program;
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
 * N-N relationship between Program and Course captured in classroom entity.
 *
 * For example, a course in a program could have too many students and they need
 * to be assigned to various classrooms (classes, sections, etc.).
 */
@Entity
@Data
@Table(name = "classroom")
public class Classroom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "program_id")
  protected Program program;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  protected Course course;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_id")
  protected Instructor instructor;
}
