package hu.progmatic.hotel.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String birthPlace;
    private Date birthDate;
    private String personalId;
    private String email;
    @Column(columnDefinition ="boolean default true" )
    private boolean isActive = true; //talan az archivalashoz

    public Guest() {
    }

    public Guest(Long id, String title, String firstName, String lastName, String birthPlace, Date birthDate, String personalId, String email, boolean isActive) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.personalId = personalId;
        this.email = email;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
