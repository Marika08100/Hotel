package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.repository.ReservationRepository;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
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
    public List<Reservation> getReservationsForToday() {
        LocalDate today = LocalDate.now();
        return reservationRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(today, today);
    }

    public List<Reservation> getReservationsForDate(LocalDate date) {
        return reservationRepository.findByStartDate(date);
    }

    public double getReservationTotalPrice(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            return reservation.get().getTotalPrice();
        } else {
            throw new IllegalArgumentException("Reservation not found with id: " + reservationId);
        }


    }
}
