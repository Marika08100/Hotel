package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    Map<Long, Integer> occupancyMap = new HashMap<>();

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping()
    public String showReservation(Model model) {
        List<Reservation> reservations = reservationService.getAllReservation();
        model.addAttribute("reservations", reservations);
        return "reservation";
    }

    @GetMapping({"/id"})

    // TODO Valósítsd meg, hogy lehessen foglalásokat létrehozni, módosítani és törölni!
    @PostMapping("/")
    public ResponseEntity<Reservation> createOrUpdateReservation(Reservation reservation) {
        return ResponseEntity.ok(reservationService.createOrUpdateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/occupancy")
    public ResponseEntity<List<Reservation>> getRoomOccupancy() {
        List<Reservation> occupancyData = reservationService.getReservationsForToday();
        return ResponseEntity.ok(occupancyData);
    }

    @GetMapping("/occupancy/{date}")
    public ResponseEntity<List<Reservation>> getOccupancyForDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Reservation> reservations = reservationService.getReservationsForDate(parsedDate);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("{reservationsId}/total-price")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long reservationsId) {
        return ResponseEntity.ok(reservationService.getReservationTotalPrice(reservationsId));
    }


}
