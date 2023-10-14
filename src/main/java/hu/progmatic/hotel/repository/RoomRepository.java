package hu.progmatic.hotel.repository;

import hu.progmatic.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    long  count();
    List<Room> findAllByIdNotIn(List<Long> ids);


}
