package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.repository.ReservationRepository;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    public Reservation createOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

// TODO a szálloda jelenlegi telítettségéről
    public Map<Long, Integer> getOccupancy() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<Room> rooms = roomRepository.findAll();
        Map<Long, Integer> occupancyMap = new HashMap<>();

        for (Room room : rooms) {
            occupancyMap.put(room.getId(), 0);
        }

        for (Reservation reservation : reservations) {
            Long roomId = reservation.getRoom().getId();
            int currentOccupancy = occupancyMap.get(roomId);
            occupancyMap.put(roomId, currentOccupancy + 1);
        }

        return occupancyMap;
    }


// TODO a szállodai adott napon lévő telítettségéről

    public List<Reservation> findByStartDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) {
        List<Reservation> reservations = reservationRepository.findByStartDate(startDate);
        List<Reservation> filteredReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getStartDate().equals(startDate)) {
                filteredReservations.add(reservation);
            }
        }

        return filteredReservations;
    }
}
