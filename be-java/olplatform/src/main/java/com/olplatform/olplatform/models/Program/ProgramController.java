package com.olplatform.olplatform.models.Program;

import com.olplatform.olplatform.models.DTOs.ProgramDTO;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
  @Autowired
  private ProgramRepository programRepository;

  @GetMapping("/api/programs")
  public ResponseEntity<List<ProgramDTO>> findAll() {
    List<Program> programs = StreamSupport
      .stream(this.programRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
    List<ProgramDTO> programsDTO = programs
      .stream()
      .map(ProgramDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<List<ProgramDTO>>(programsDTO, HttpStatus.OK);
  }

  @PutMapping("/api/programs")
  public ResponseEntity<ProgramDTO> updateOne(@RequestBody Program program) {
    Program updatedProgram = this.programRepository.save(program);
    return new ResponseEntity<ProgramDTO>(
      ProgramDTO.from(updatedProgram),
      HttpStatus.OK
    );
  }

  @PostMapping("/api/programs")
  public ResponseEntity<ProgramDTO> addOne(
    @RequestBody final ProgramDTO programDTO
  ) {
    Program createdProgram =
      this.programRepository.save(Program.from(programDTO));
    return new ResponseEntity<ProgramDTO>(
      ProgramDTO.from(createdProgram),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/api/programs/{programId}")
  public ResponseEntity<Integer> deleteOne(@PathVariable long programId) {
    int result = this.programRepository.deleteOne(programId);
    return new ResponseEntity<Integer>(result, HttpStatus.OK);
  }
}
