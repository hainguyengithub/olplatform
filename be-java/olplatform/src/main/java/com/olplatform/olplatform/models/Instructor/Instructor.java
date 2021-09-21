package com.olplatform.olplatform.models.Instructor;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "instructror")
public class Instructor extends Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  protected long salary;

  protected String sin;

  /**
   * The mappedBy property is what we use to tell Hibernate which variable we're
   * using to represent the parent class in our child class.
   */
  @OneToMany(mappedBy = "instructor")
  protected List<Classroom> classrooms = new ArrayList<>();

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
}
