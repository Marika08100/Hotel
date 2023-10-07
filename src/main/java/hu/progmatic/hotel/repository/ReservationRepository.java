// ReservationRepository.java
package hu.progmatic.hotel.repository;

import hu.progmatic.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate today, LocalDate localDate);


    List<Reservation> findReservationsForDate(LocalDate startDate);

    List<Reservation> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
