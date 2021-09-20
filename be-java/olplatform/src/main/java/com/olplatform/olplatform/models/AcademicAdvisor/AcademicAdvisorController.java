package com.olplatform.olplatform.models.AcademicAdvisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Academic Advisor should not be deleted but only disabled.
 */

@CrossOrigin
@RestController
public class AcademicAdvisorController {
  public static final String API_ACADEMIC_ADVISORS = "/api/academicAdvisors";

  @Autowired
  private AcademicAdvisorRepository repository;

  @GetMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<Iterable<AcademicAdvisor>> findAll() {
    Iterable<AcademicAdvisor> entities = this.repository.findAll();
    return new ResponseEntity<Iterable<AcademicAdvisor>>(
      entities,
      HttpStatus.OK
    );
  }

  @PutMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<AcademicAdvisor> updateOne(
    @RequestBody AcademicAdvisor entity
  ) {
    AcademicAdvisor updatedEntity = this.repository.save(entity);
    return new ResponseEntity<AcademicAdvisor>(updatedEntity, HttpStatus.OK);
  }

  @PostMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<AcademicAdvisor> addOne(
    @RequestBody AcademicAdvisor entity
  ) {
    AcademicAdvisor createdEntity = this.repository.save(entity);
    return new ResponseEntity<AcademicAdvisor>(createdEntity, HttpStatus.OK);
  }
}
