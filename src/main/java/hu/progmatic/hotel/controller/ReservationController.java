package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("")
    public List<Reservation> getAllReservation(){
        return  reservationService.getAllReservation();
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createOrUpdateReservation(Reservation reservation) {
        return ResponseEntity.ok(reservationService.createOrUpdateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

}
