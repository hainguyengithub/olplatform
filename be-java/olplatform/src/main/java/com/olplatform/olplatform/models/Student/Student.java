package com.olplatform.olplatform.models.Student;

import com.olplatform.olplatform.models.Person;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends Person {}
