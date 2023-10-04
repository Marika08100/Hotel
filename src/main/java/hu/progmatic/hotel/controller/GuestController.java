package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guests")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping("")
    public List<Guest> getAllGuest(){
        return guestService.getAllGuest();
    }

    @PostMapping("")
    public ResponseEntity<Guest> createOrUpdateGuest(@RequestBody Guest guest){
        return ResponseEntity.ok(guestService.creatOrUpdateGuest(guest));
    }
}
