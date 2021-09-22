package com.olplatform.olplatform.models.Seat;

import com.olplatform.olplatform.models.DTOs.SeatDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
public class SeatController {
  public static final String API_SEATS = "/api/seats";

  @Autowired
  private SeatService seatService;

  @GetMapping(API_SEATS + "/{studentId}")
  public ResponseEntity<List<SeatDTO>> getSeatsOfStudent(
    @PathVariable Long studentId
  )
    throws Exception {
    List<Seat> seats = this.seatService.getSeatsOfStudent(studentId);
    List<SeatDTO> seatsDTO = seats
      .stream()
      .map(SeatDTO::from)
      .collect(Collectors.toList());
    return new ResponseEntity<List<SeatDTO>>(seatsDTO, HttpStatus.OK);
  }
}
