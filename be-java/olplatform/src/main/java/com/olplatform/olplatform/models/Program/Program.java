package com.olplatform.olplatform.models.Program;

import com.olplatform.olplatform.models.AcademicAdvisor.AcademicAdvisor;
import com.olplatform.olplatform.models.Administrable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Program extends Administrable {
  @ManyToOne
  @JoinColumn(name = "id", nullable = false)
  protected AcademicAdvisor academicAdvisor;
}
