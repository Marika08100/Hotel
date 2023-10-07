package hu.progmatic.hotel.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.time.LocalTime.MAX;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    public Reservation() {
    }

    public Reservation(Long id, Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public double getTotalPrice(){
        long nights = ChronoUnit.DAYS.between(startDate,endDate);
        return nights  * room.getNightlyPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
