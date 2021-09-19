package com.olplatform.olplatform.models.Program;

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
  public ResponseEntity<Iterable<Program>> findAll() {
    Iterable<Program> programs = this.programRepository.findAll();
    return new ResponseEntity<Iterable<Program>>(programs, HttpStatus.OK);
  }

  @PutMapping("/api/programs")
  public ResponseEntity<Program> updateOne(@RequestBody Program program) {
    Program updatedProgram = this.programRepository.save(program);
    return new ResponseEntity<Program>(updatedProgram, HttpStatus.OK);
  }

  @PostMapping("/api/programs")
  public ResponseEntity<Program> addOne(@RequestBody Program program) {
    Program createdProgram = this.programRepository.save(program);
    return new ResponseEntity<Program>(createdProgram, HttpStatus.OK);
  }

  @DeleteMapping("/api/programs/{programId}")
  public ResponseEntity<Integer> deleteOne(@PathVariable long programId) {
    int result = this.programRepository.deleteOne(programId);
    return new ResponseEntity<Integer>(result, HttpStatus.OK);
  }
}
