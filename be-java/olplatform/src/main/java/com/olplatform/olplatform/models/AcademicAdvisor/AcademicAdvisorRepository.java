package com.olplatform.olplatform.models.AcademicAdvisor;

// import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(
  collectionResourceRel = "academic-advisors",
  path = "academic-advisors"
)
public interface AcademicAdvisorRepository
  extends CrudRepository<AcademicAdvisor, Long> {}
