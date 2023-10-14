package hu.progmatic.hotel.controller;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.service.GuestService;
import hu.progmatic.hotel.service.ReservationService;
import hu.progmatic.hotel.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class Rest {
    private final GuestService guestService;
    private final RoomService roomService;
    private final ReservationService reservationService;

    @GetMapping("/guests")
    public List<Guest> getAllGuest(){
        return guestService.getAllGuest();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRoom(){
        return roomService.findAllRoom();
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservation();
    }

    public Rest(GuestService guestService, RoomService roomService, ReservationService reservationService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.reservationService = reservationService;
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
