package com.olplatform.olplatform.models.Resource.Material;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olplatform.olplatform.interfaces.Manageable;
import com.olplatform.olplatform.interfaces.Terminable;
import com.olplatform.olplatform.models.Administrable;
import com.olplatform.olplatform.models.Classroom.Classroom;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "program")
@Data
@EqualsAndHashCode(callSuper = true)
public class Material extends Administrable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id = 0L;

  @Column(length = 255)
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

  @Lob
  @Column(name = "attachment")
  protected byte[] attachment;

  @Column(name = "attachment_name", length = 255)
  protected String attachmentName;

  @Column(name = "attachment_enabled", nullable = false)
  protected boolean attachmentEnabled;

  @ManyToOne
  protected Classroom classroom;
}
