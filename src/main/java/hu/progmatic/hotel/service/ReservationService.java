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

    // TODO a szállodai adott napon lévő telítettségéről
    public long getOccupancyForDate(LocalDate date, LocalDate localDate) {
        List<Reservation> reservationsForDate = reservationRepository.findByStartDateAndEndDate(date, localDate);
        return reservationsForDate.size();
    }

    public double getOccupancyPercentageForDate(LocalDate date) {
        int totalRooms = (int) roomRepository.count();
        int reservationsForDate = reservationRepository.findReservationsForDate(date).size();
        return (double) reservationsForDate / totalRooms * 100;
    }


}
