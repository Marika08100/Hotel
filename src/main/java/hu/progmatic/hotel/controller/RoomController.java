package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.service.ReservationService;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<Room> getAllRooms() {
        return roomService.findAllRoom();
    }

    @PostMapping("/")
    public ResponseEntity<Room> createOrUpdateRoom(Room room) {
        return ResponseEntity.ok(roomService.createOrUpdateRoom(room));
    }
}