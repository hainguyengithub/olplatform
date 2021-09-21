package com.olplatform.olplatform.models.Seat;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Student.Student;
import com.olplatform.olplatform.models.Submission.Submission;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * N-N relationship between Classroom and Student captured in a new Entity.
 * A student could attend N classrooms. A classroom could have N students.
 */
@Entity
@Data
@Table(name = "seat")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "classroom_id")
  protected Classroom classroom;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  protected Student student;

  // The "academic_advisor_id" is a column name in the Program table.
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "seat_id")
  protected List<Submission> submissions = new ArrayList<>();

  public Seat() {}

  public void addSubmission(Submission submission) {
    this.submissions.add(submission);
  }
}
