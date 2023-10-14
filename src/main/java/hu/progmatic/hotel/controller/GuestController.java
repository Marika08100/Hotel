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
@RequestMapping("/guest")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping()
    public String showGuest(Model model) {
        List<Guest> guests = guestService.getAllGuest();
        model.addAttribute("guests", guests);
        return "guest";
    }

    @GetMapping("/{id}")
    public String getGuestById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("guest", guestService.getGuestById(id));
        return "show-guest";
    }

    @GetMapping("/new")
    public String newGuest(Model model){
        model.addAttribute("guest",new Guest());
        return "new-guest";
    }

    @PostMapping("/new")
    public String newGuest(@ModelAttribute("guest") Guest guest){
        guestService.save(guest);
        return "redirect:/guest";
    }

    @GetMapping("/birthday/{date}")
    public ResponseEntity<List<Guest>> getGuestsBornOnDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Guest> guests = guestService.getBirthDate(parsedDate);
        return ResponseEntity.ok(guests);
    }
}
