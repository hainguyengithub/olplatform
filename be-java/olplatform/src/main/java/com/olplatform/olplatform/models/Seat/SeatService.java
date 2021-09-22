package com.olplatform.olplatform.models.Seat;

import com.olplatform.olplatform.models.Student.Student;
import com.olplatform.olplatform.models.Student.StudentService;
import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class SeatService {
  @Autowired
  private SeatRepository seatRepository;

  @Autowired
  private StudentService studentService;

  @Transactional
  public List<Seat> getSeatsOfStudent(Long studentId) throws Exception {
    Student student = this.studentService.getEntity(studentId);
    return this.seatRepository.getSeatsOfStudent(student);
  }
}
