package com.olplatform.olplatform.models.Program;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.DTOs.ClassroomDTO;
import com.olplatform.olplatform.models.DTOs.ProgramDTO;
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
public class ProgramController {
  public static final String API_PROGRAMS = "/api/programs";

  @Autowired
  private ProgramService programService;

  @GetMapping(API_PROGRAMS)
  public ResponseEntity<List<ProgramDTO>> getEntities() {
    List<Program> programs = this.programService.getEntities();
    List<ProgramDTO> programsDTO = programs
      .stream()
      .map(ProgramDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<>(programsDTO, HttpStatus.OK);
  }

  @GetMapping(API_PROGRAMS + "/{programId}")
  public ResponseEntity<ProgramDTO> getEntity(
    @PathVariable final Long programId
  )
    throws Exception {
    Program program = this.programService.getEntity(programId);
    return new ResponseEntity<>(ProgramDTO.from(program), HttpStatus.OK);
  }

  @PostMapping(API_PROGRAMS)
  public ResponseEntity<ProgramDTO> addEntity(
    @RequestBody final ProgramDTO programDTO
  ) {
    Program createdProgram =
      this.programService.addEntity(Program.from(programDTO));
    return new ResponseEntity<ProgramDTO>(
      ProgramDTO.from(createdProgram),
      HttpStatus.OK
    );
  }

  @PutMapping(API_PROGRAMS + "/{programId}")
  public ResponseEntity<ProgramDTO> updateEntity(
    @PathVariable final Long programId,
    @RequestBody final ProgramDTO programDTO
  )
    throws Exception {
    Program program =
      this.programService.updateEntity(programId, Program.from(programDTO));
    return new ResponseEntity<>(ProgramDTO.from(program), HttpStatus.OK);
  }

  @DeleteMapping(API_PROGRAMS + "/{programId}")
  public ResponseEntity<ProgramDTO> deleteItem(
    @PathVariable final Long programId
  )
    throws Exception {
    Program program = this.programService.deleteEntity(programId);
    return new ResponseEntity<>(ProgramDTO.from(program), HttpStatus.OK);
  }

  /*****************************************************************************
   * Program N - N Course
   ****************************************************************************/

  public static final String API_PROGRAMS_COURSES =
    "/api/programs/{programId}/courses";

  @GetMapping(API_PROGRAMS_COURSES)
  public ResponseEntity<List<ClassroomDTO>> getCoursesOfProgram(
    @PathVariable long programId
  )
    throws Exception {
    List<Classroom> classrooms =
      this.programService.getClassroomsOfProgram(programId);
    List<ClassroomDTO> classroomsDTO = classrooms
      .stream()
      .map(ClassroomDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<List<ClassroomDTO>>(classroomsDTO, HttpStatus.OK);
  }
}
