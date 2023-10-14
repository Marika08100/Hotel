package hu.progmatic.hotel.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.time.temporal.ChronoUnit;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "capacity")
    private int capacity;
    @Column(name = "nightly_price")
    private double nightlyPrice;
    @Column(name = "has_Jacuzzi")
    private boolean hasJacuzzi;
    @Column(name = "has_sauna")
    private boolean hasSauna;


    public Room() {
    }

    public Room(Long id, String roomNumber, int capacity, double nightlyPrice, boolean hasJacuzzi, boolean hasSauna) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.nightlyPrice = nightlyPrice;
        this.hasJacuzzi = hasJacuzzi;
        this.hasSauna = hasSauna;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(double nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }

    public boolean isHasSauna() {
        return hasSauna;
    }

    public void setHasSauna(boolean hasSauna) {
        this.hasSauna = hasSauna;
    }
}
