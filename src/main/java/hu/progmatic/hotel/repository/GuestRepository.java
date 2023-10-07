package hu.progmatic.hotel.repository;

import hu.progmatic.hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Date;
import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
    List<Guest> findByIsActiveTrue();

    @Query("SELECT g FROM Guest g WHERE DATE_FORMAT(g.birthDate, '%m-%d') = DATE_FORMAT(:localDate, '%m-%d')")
    List<Guest> findByBirthDay(@Param("localDate") LocalDate localDate);

}
