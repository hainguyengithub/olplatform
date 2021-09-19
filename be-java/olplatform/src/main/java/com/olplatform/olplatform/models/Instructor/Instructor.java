package com.olplatform.olplatform.models.Instructor;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Person;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("instructor")
public class Instructor extends Person {
  protected long salary;

  protected String sin;

  /**
   * The mappedBy property is what we use to tell Hibernate which variable we're
   * using to represent the parent class in our child class.
   */
  @OneToMany(mappedBy = "instructor")
  protected Set<Classroom> classrooms;

  public Instructor() {
    super();
    this.salary = 0L;
    this.sin = "";
  }

  public Instructor(
    long id,
    String firstName,
    String lastName,
    String username,
    String password,
    String email,
    String phoneNumber,
    long salary,
    String sin
  ) {
    super(id, firstName, lastName, username, password, email, phoneNumber);
    this.salary = salary;
    this.sin = sin;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  public String getSin() {
    return sin;
  }

  public void setSin(String sin) {
    this.sin = sin;
  }
}
