package com.olplatform.olplatform.models.Instructor;

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
public class InstructorController {
  public static final String API_INSTRUCTORS = "/api/instructors";

  @Autowired
  private InstructorRepository instructorRepository;

  @GetMapping(API_INSTRUCTORS)
  public ResponseEntity<Iterable<Instructor>> findAll() {
    Iterable<Instructor> instructors = this.instructorRepository.findAll();
    return new ResponseEntity<Iterable<Instructor>>(instructors, HttpStatus.OK);
  }

  @PostMapping(API_INSTRUCTORS)
  public ResponseEntity<Instructor> addOne(@RequestBody Instructor instructor) {
    Instructor createdInstructor = this.instructorRepository.save(instructor);
    return new ResponseEntity<Instructor>(createdInstructor, HttpStatus.OK);
  }

  @PutMapping(API_INSTRUCTORS)
  public ResponseEntity<Instructor> updateOne(
    @RequestBody Instructor instructor
  ) {
    Instructor updatedInstructor = this.instructorRepository.save(instructor);
    return new ResponseEntity<Instructor>(updatedInstructor, HttpStatus.OK);
  }

  @DeleteMapping(API_INSTRUCTORS + "/{instructorId}")
  public ResponseEntity<Integer> deleteOne(@PathVariable long instructorId) {
    int result = this.instructorRepository.deleteOne(instructorId);
    return new ResponseEntity<Integer>(result, HttpStatus.OK);
  }
}
