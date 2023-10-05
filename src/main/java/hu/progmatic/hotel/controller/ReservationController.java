package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.service.ReservationService;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    Map<Long, Integer> occupancyMap = new HashMap<>();


    @GetMapping("")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }


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
    public ResponseEntity<Map<Long, Integer>> getRoomOccupancy() {
        Map<Long, Integer> occupancyData = reservationService.getOccupancy();
        return ResponseEntity.ok(occupancyData);
    }

    @GetMapping("/occupancy/{date}")
    public ResponseEntity<Map<Long, Integer>> getOccupancyByDate(@PathVariable @
            DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Reservation> reservations = reservationService.findByStartDate(date);

        for (Reservation reservation : reservations) {
            Long roomId = reservation.getRoom().getId();
            occupancyMap.put(roomId, occupancyMap.getOrDefault(roomId, 0) + 1);
        }
        return ResponseEntity.ok(occupancyMap);
    }

}
