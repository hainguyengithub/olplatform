package com.olplatform.olplatform.models.Program;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "programs", path = "programs")
public interface ProgramRepository extends CrudRepository<Program, Long> {
  @Modifying
  @Transactional
  @Query("DELETE FROM Program WHERE id = ?1")
  public int deleteOne(Long programId);
}
