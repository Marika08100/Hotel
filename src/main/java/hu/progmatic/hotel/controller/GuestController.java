package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Date;
import java.util.List;

@Controller
public class GuestController {
    @Autowired
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guest")
    public String showGuest(Model model) {
        List<Guest> guests = guestService.getAllGuest();
        model.addAttribute("guest", guests);
        return "guest";
    }

    @PostMapping("/register")
    public String createOrUpdateGuest(@ModelAttribute Guest guest) {
        guestService.getAllGuest();
        if (!guest.isActive()) {
            return "redirect:/guest";
        }
        return "register";
    }
    @GetMapping("/birthday/{date}")
    public ResponseEntity<List<Guest>> getGuestsBornOnDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Guest> guests = guestService.getBirthDate(parsedDate);
        return ResponseEntity.ok(guests);
    }
}
