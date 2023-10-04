package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.service.ReservationService;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/")
    public ResponseEntity<Room> createOrUpdateRoom(Room room) {
        return ResponseEntity.ok(roomService.createOrUpdateRoom(room));
    }
}
