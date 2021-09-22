package com.olplatform.olplatform.models.Seat;

import com.olplatform.olplatform.models.Student.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "seats", path = "seats")
public interface SeatRepository extends CrudRepository<Seat, Long> {
  @Query("SELECT s FROM Seat s WHERE s.student = ?1")
  public List<Seat> getSeatsOfStudent(Student student);
}
