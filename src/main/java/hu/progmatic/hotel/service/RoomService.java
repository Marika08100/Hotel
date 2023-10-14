package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReservationService reservationService;

    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
    }

    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    public Room createOrUpdateRoom(Room room) {
        return roomRepository.save(room);
    }


    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }


    public List<Room> findAlAvailableRoom(LocalDate startDate, LocalDate endDate) {
        List<Reservation> wrongReservations = reservationService.betweenDates(startDate, endDate);
        Set<Long> wrongRoomID = new HashSet<>();
        for (Reservation actual : wrongReservations) {
            wrongRoomID.add(actual.getRoom().getId());
        }
        return roomRepository.findAllByIdNotIn((List<Long>) wrongRoomID);
    }
}
