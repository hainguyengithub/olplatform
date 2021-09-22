package com.olplatform.olplatform.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;

  // @todo
  // public List<Student> getEntities() {}

  public Student getEntity(Long studentId) throws Exception {
    return this.studentRepository.findById(studentId)
      .orElseThrow(() -> new Exception(""));
  }
}
