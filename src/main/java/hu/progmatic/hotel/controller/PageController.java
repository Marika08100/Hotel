package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.service.GuestService;
import hu.progmatic.hotel.service.ReservationService;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    private final GuestService guestService;
    private final RoomService roomService;
    private final ReservationService reservationService;

    public PageController(GuestService guestService, RoomService roomService, ReservationService reservationService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.reservationService = reservationService;
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }


    public GuestService getGuestService() {
        return guestService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }
}
