package com.olplatform.olplatform.models.AcademicAdvisor;

import com.olplatform.olplatform.models.Program.Program;
import com.olplatform.olplatform.models.Program.ProgramService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicAdvisorService {
  @Autowired
  private AcademicAdvisorRepository academicAdvisorRepository;

  @Autowired
  private ProgramService programService;

  public List<AcademicAdvisor> getEntites() {
    return StreamSupport
      .stream(academicAdvisorRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }

  public AcademicAdvisor getEntity(Long id) throws Exception {
    return academicAdvisorRepository
      .findById(id)
      .orElseThrow(() -> new Exception(""));
  }

  public AcademicAdvisor addEntity(AcademicAdvisor academicAdvisor) {
    return academicAdvisorRepository.save(academicAdvisor);
  }

  @Transactional
  public AcademicAdvisor updateEntity(
    Long academicAdvisorId,
    AcademicAdvisor academicAdvisor
  )
    throws Exception {
    AcademicAdvisor updatedAcademicAdvisor = this.getEntity(academicAdvisorId);
    updatedAcademicAdvisor.setFirstName(academicAdvisor.getFirstName());
    updatedAcademicAdvisor.setLastName(academicAdvisor.getLastName());
    updatedAcademicAdvisor.setUsername(academicAdvisor.getUsername());
    updatedAcademicAdvisor.setEmail(academicAdvisor.getEmail());
    updatedAcademicAdvisor.setPhoneNumber(academicAdvisor.getPhoneNumber());
    return updatedAcademicAdvisor;
  }

  public AcademicAdvisor deleteEntity(Long academicAdvisorId) throws Exception {
    AcademicAdvisor academicAdvisor = this.getEntity(academicAdvisorId);
    this.academicAdvisorRepository.delete(academicAdvisor);
    return academicAdvisor;
  }

  @Transactional
  public AcademicAdvisor assignAcademicAdvisorToProgram(
    Long academicAdvisorId,
    Long programId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor = getEntity(academicAdvisorId);
    Program program = programService.getEntity(programId);
    if (Objects.nonNull(program.getAcademicAdvisor())) {
      throw new Exception("");
    }
    academicAdvisor.addProgram(program);
    program.setAcademicAdvisor(academicAdvisor);
    return academicAdvisor;
  }

  @Transactional
  public AcademicAdvisor unAssignAcademicAdvisorToProgram(
    Long academicAdvisorId,
    Long programId
  )
    throws Exception {
    AcademicAdvisor academicAdvisor = this.getEntity(academicAdvisorId);
    Program program = this.programService.getEntity(programId);
    academicAdvisor.deleteProgram(program);
    return academicAdvisor;
  }
}
