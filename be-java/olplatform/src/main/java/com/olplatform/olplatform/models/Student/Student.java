package com.olplatform.olplatform.models.Student;

import com.olplatform.olplatform.models.Person;
import com.olplatform.olplatform.models.Seat.Seat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "student")
public class Student extends Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;

  protected String firstName;

  protected String lastName;

  protected String username;

  protected String password;

  protected String email;

  protected String phoneNumber;

  @OneToMany(mappedBy = "student")/* student is an attribute in Seat. */
  protected List<Seat> seats = new ArrayList<>();

  public Student() {
    super();
  }

  public Student(
    long id,
    String firstName,
    String lastName,
    String username,
    String password,
    String email,
    String phoneNumber
  ) {
    super(id, firstName, lastName, username, password, email, phoneNumber);
  }
}
