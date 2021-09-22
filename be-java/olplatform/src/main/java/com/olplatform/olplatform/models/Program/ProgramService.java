package com.olplatform.olplatform.models.Program;

import com.olplatform.olplatform.models.Classroom.Classroom;
import com.olplatform.olplatform.models.Classroom.ClassroomService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {
  @Autowired
  private ProgramRepository programRepository;

  @Autowired
  private ClassroomService classroomService;

  public List<Program> getEntities() {
    return StreamSupport
      .stream(this.programRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }

  public Program getEntity(Long programId) throws Exception {
    return programRepository
      .findById(programId)
      .orElseThrow(() -> new Exception(""));
  }

  public Program addEntity(Program program) {
    return this.programRepository.save(program);
  }

  @Transactional
  public Program updateEntity(Long programId, Program program)
    throws Exception {
    Program updatedProgram = this.getEntity(programId);
    updatedProgram.setName(program.getName());
    updatedProgram.setDescription(program.getDescription());
    updatedProgram.setStartDate(program.getStartDate());
    updatedProgram.setEndDate(program.getEndDate());
    return updatedProgram;
  }

  public Program deleteEntity(Long programId) throws Exception {
    Program program = this.getEntity(programId);
    this.programRepository.delete(program);
    return program;
  }

  public List<Classroom> getClassroomsOfProgram(Long programId)
    throws Exception {
    return this.classroomService.getClassroomsOfProgram(programId);
  }
}
