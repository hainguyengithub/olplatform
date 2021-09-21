package com.olplatform.olplatform.models.Instructor;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(
  collectionResourceRel = "instructors",
  path = "instructors"
)
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
  @Modifying
  @Transactional
  @Query("DELETE FROM Instructor WHERE id = ?1")
  public int deleteOne(Long instructorId);
}
