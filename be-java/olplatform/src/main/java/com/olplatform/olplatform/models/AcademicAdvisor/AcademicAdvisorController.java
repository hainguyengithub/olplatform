package com.olplatform.olplatform.models.AcademicAdvisor;

import com.olplatform.olplatform.models.DTOs.AcademicAdvisorDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AcademicAdvisorController {
  public static final String API_ACADEMIC_ADVISORS = "/api/academic-advisors";

  @Autowired
  private AcademicAdvisorService academicAdvisorService;

  @GetMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<List<AcademicAdvisorDTO>> getEntites() {
    List<AcademicAdvisor> carts = this.academicAdvisorService.getEntites();
    List<AcademicAdvisorDTO> cartsDto = carts
      .stream()
      .map(AcademicAdvisorDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<>(cartsDto, HttpStatus.OK);
  }

  @GetMapping(API_ACADEMIC_ADVISORS + "/{academicAdvisorId}")
  public ResponseEntity<AcademicAdvisorDTO> getEntity(
    @PathVariable final Long academicAdvisorId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorService.getEntity(academicAdvisorId);
    return new ResponseEntity<>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
  }

  @PostMapping(API_ACADEMIC_ADVISORS)
  public ResponseEntity<AcademicAdvisorDTO> addEntity(
    @RequestBody AcademicAdvisorDTO academicAdvisorDTO
  ) {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorService.addEntity(
          AcademicAdvisor.from(academicAdvisorDTO)
        );
    return new ResponseEntity<AcademicAdvisorDTO>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
  }

  @PutMapping(API_ACADEMIC_ADVISORS + "/{academicAdvisorId}")
  public ResponseEntity<AcademicAdvisorDTO> updateEntity(
    @PathVariable final Long academicAdvisorId,
    @RequestBody final AcademicAdvisorDTO academicAdvisorDTO
  )
    throws Exception {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorService.updateEntity(
          academicAdvisorId,
          AcademicAdvisor.from(academicAdvisorDTO)
        );
    return new ResponseEntity<>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
  }

  @DeleteMapping(API_ACADEMIC_ADVISORS + "/{academicAdvisorId}")
  public ResponseEntity<AcademicAdvisorDTO> deleteEntity(
    @PathVariable final Long academicAdvisorId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorService.deleteEntity(academicAdvisorId);
    return new ResponseEntity<>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
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
    AcademicAdvisor academicAdvisor = academicAdvisorService.assignAcademicAdvisorToProgram(
      academicAdvisorId,
      programId
    );
    return new ResponseEntity<>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
  }

  @DeleteMapping(
    API_ACADEMIC_ADVISORS +
    "/{academicAdvisorId}" +
    "/programs" +
    "/{programId}"
  )
  public ResponseEntity<AcademicAdvisorDTO> unAssignAcademicAdvisorToProgram(
    @PathVariable final Long academicAdvisorId,
    @PathVariable final Long programId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor =
      this.academicAdvisorService.unAssignAcademicAdvisorToProgram(
          academicAdvisorId,
          programId
        );
    return new ResponseEntity<>(
      AcademicAdvisorDTO.from(academicAdvisor),
      HttpStatus.OK
    );
  }
}
