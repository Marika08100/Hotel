package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.repository.ReservationRepository;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public Reservation createOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    public List<Reservation> betweenDates(LocalDate start, LocalDate end) {
        return reservationRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(start, end);
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
