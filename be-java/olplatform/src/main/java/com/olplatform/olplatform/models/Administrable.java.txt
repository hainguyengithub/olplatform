package com.olplatform.olplatform.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.interfaces.Manageable;
import com.olplatform.olplatform.interfaces.Terminable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(
  strategy = InheritanceType.JOINED
) /* Do not use SINGLE_TABLE to avoid conflicts. */
@DiscriminatorColumn(
  name = "administrable_type",
  discriminatorType = DiscriminatorType.STRING
)
public class Administrable implements Manageable, Terminable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;

  protected String name;

  @Column(length = 1000)
  protected String description;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd HH:mm:ss Z",
    timezone = "America/Toronto"
  )
  protected Date startDate;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd HH:mm:ss Z",
    timezone = "America/Toronto"
  )
  protected Date endDate;

  public Administrable() {
    this.id = 0L;
    this.name = "";
    this.description = "";
    this.startDate = null;
    this.endDate = null;
  }

  public Administrable(
    long id,
    String name,
    String description,
    Date startDate,
    Date endDate
  ) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
