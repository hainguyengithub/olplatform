package com.olplatform.olplatform.models.Classroom;

import com.olplatform.olplatform.models.DTOs.ClassroomDTO;
import com.olplatform.olplatform.models.Program.Program;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(
  collectionResourceRel = "classrooms",
  path = "classrooms"
)
public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
  // @Query("SELECT cl FROM classroom cl WHERE cl.program_id = ?1")
  @Query("SELECT cl FROM Classroom cl WHERE cl.program = ?1")
  // public List<Classroom> getClassroomsOfProgram(Long programId);
  public List<Classroom> getClassroomsOfProgram(Program program);
}
