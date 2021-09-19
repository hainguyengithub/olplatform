package com.olplatform.olplatform.models.Student;

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
public class StudentController {
  public static final String API_STUDENTS = "/api/students";

  @Autowired
  private StudentRepository studentRepository;

  @GetMapping(API_STUDENTS)
  public ResponseEntity<Iterable<Student>> findAll() {
    Iterable<Student> students = this.studentRepository.findAll();
    return new ResponseEntity<Iterable<Student>>(students, HttpStatus.OK);
  }

  @PostMapping(API_STUDENTS)
  public ResponseEntity<Student> addOne(@RequestBody Student student) {
    Student createdStudent = this.studentRepository.save(student);
    return new ResponseEntity<Student>(createdStudent, HttpStatus.OK);
  }

  @PutMapping(API_STUDENTS)
  public ResponseEntity<Student> updateOne(@RequestBody Student student) {
    Student updatedStudent = this.studentRepository.save(student);
    return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
  }

  @DeleteMapping(API_STUDENTS + "/{studentId}")
  public ResponseEntity<Integer> deleteOne(@PathVariable long studentId) {
    int result = this.studentRepository.deleteOne(studentId);
    return new ResponseEntity<Integer>(result, HttpStatus.OK);
  }
}
