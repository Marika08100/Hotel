package hu.progmatic.hotel.model;

import jakarta.persistence.*;

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
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "number_of_guest" )
    private int numberOfGuest;

    public Reservation() {
    }

    public Reservation(Long id, Guest guest, Room room) {
        this.id = id;
        this.guest = guest;
        this.room = room;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuest;
    }


}
