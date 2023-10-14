package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public String showRooms(Model model) {
        List<Room> rooms = roomService.findAllRoom();
        model.addAttribute("rooms", rooms);
        return "room";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable("id") Long id, Model model){
        model.addAttribute("room", roomService.getRoomById(id));
        return "show-room";
    }

    // TODO Új szállodai szobákat ne lehessen se felvenni, se törölni, ám legyenek módosíthatóak a meglévők!
    @PostMapping("/")
    public ResponseEntity<Room> createOrUpdateRoom(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.createOrUpdateRoom(room));
    }

}
