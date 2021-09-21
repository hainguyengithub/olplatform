package com.olplatform.olplatform.models.Classroom;

import com.olplatform.olplatform.models.DTOs.ClassroomDTO;
import com.olplatform.olplatform.models.Program.Program;
import com.olplatform.olplatform.models.Program.ProgramRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
  @Autowired
  private ClassroomRepository classroomRepository;

  @Autowired
  private ProgramRepository programRepository;

  public List<Classroom> getEntities() {
    return StreamSupport
      .stream(this.classroomRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }

  @Transactional
  public List<Classroom> getClassroomsOfProgram(Long programId) {
    Program program = this.programRepository.findById(programId).get();
    return this.classroomRepository.getClassroomsOfProgram(program);
  }
}
