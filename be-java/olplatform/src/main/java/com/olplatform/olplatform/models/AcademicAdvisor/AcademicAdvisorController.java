package com.olplatform.olplatform.models.AcademicAdvisor;

import com.olplatform.olplatform.models.DTOs.AcademicAdvisorDTO;
import com.olplatform.olplatform.models.Program.Program;
import com.olplatform.olplatform.models.Program.ProgramRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public static final String API_ACADEMIC_ADVISORS = "/api/academic-advisors";

  @Autowired
  private AcademicAdvisorRepository academicAdvisorRepository;

  @Autowired
  private ProgramRepository programRepository;

  @GetMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<Iterable<AcademicAdvisor>> findAll() {
    Iterable<AcademicAdvisor> entities =
      this.academicAdvisorRepository.findAll();
    return new ResponseEntity<Iterable<AcademicAdvisor>>(
      entities,
      HttpStatus.OK
    );
  }

  @PutMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<AcademicAdvisor> updateOne(
    @RequestBody AcademicAdvisor entity
  ) {
    AcademicAdvisor updatedEntity = this.academicAdvisorRepository.save(entity);
    return new ResponseEntity<AcademicAdvisor>(updatedEntity, HttpStatus.OK);
  }

  @PostMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<AcademicAdvisor> addOne(
    @RequestBody AcademicAdvisor entity
  ) {
    AcademicAdvisor createdEntity = this.academicAdvisorRepository.save(entity);
    return new ResponseEntity<AcademicAdvisor>(createdEntity, HttpStatus.OK);
  }

  @PostMapping(
    API_ACADEMIC_ADVISORS +
    "/{academicAdvisorId}" +
    "/programs" +
    "/{programId}"
  )
  public ResponseEntity<AcademicAdvisorDTO> assignAcademicAdvisorToProgram(
    @PathVariable final long academicAdvisorId,
    @PathVariable final long programId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorRepository.findById(academicAdvisorId).get();
    Program program = this.programRepository.findById(programId).get();
    if (academicAdvisor != null && program != null) {
      if (Objects.nonNull(program.getAcademicAdvisor())) {
        throw new Exception(
          "Program is already assigned to another academic advisor."
        );
      }
      academicAdvisor.addProgram(program);
      program.setAcademicAdvisor(academicAdvisor);
      return new ResponseEntity<AcademicAdvisorDTO>(
        AcademicAdvisorDTO.from(academicAdvisor),
        HttpStatus.OK
      );
    } else {
      throw new Exception(
        "Something went wrong. Please try again later. Or if the problem persists, please contact us."
      );
    }
  }
}
