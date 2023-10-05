package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
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


    // TODO Valósítsd meg, hogy lehessen új vendégeket felvenni a rendszerbe és a meglévőket frissíteni, de ne lehessen vendégeket törölni!
    @PostMapping("/")
    public ResponseEntity<Guest> createOrUpdateGuest(@RequestBody Guest guest) throws NotActiveException {
        return ResponseEntity.ok(guestService.creatOrUpdateGuest(guest));
    }
}
