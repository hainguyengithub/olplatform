package com.olplatform.olplatform.models.Classroom;

import com.olplatform.olplatform.models.DTOs.ClassroomDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class ClassroomController {
  public static final String API_CLASSROOMS = "/api/classrooms";

  @Autowired
  private ClassroomService classroomService;

  @GetMapping(API_CLASSROOMS)
  public ResponseEntity<List<ClassroomDTO>> getEntities() {
    List<Classroom> classrooms = this.classroomService.getEntities();
    List<ClassroomDTO> classroomsDTO = classrooms
      .stream()
      .map(ClassroomDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<>(classroomsDTO, HttpStatus.OK);
  }
}
