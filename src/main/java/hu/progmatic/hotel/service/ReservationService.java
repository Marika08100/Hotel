package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Reservation;
import hu.progmatic.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createOrUpdateReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
}
