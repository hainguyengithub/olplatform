package com.olplatform.olplatform.models.Program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "programs", path = "programs")
public interface ProgramRepository extends CrudRepository<Program, Long> {}
