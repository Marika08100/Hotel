package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    public Guest creatOrUpdateGuest(Guest guest) {
        if (guest.getId() != null) {
            Optional<Guest> existingGuest = guestRepository.findById(guest.getId());
            if (existingGuest.isPresent()) {
                Guest updatedGuest = existingGuest.get();
                updatedGuest.setTitle(guest.getTitle());
                updatedGuest.setFirstName(guest.getFirstName());
                updatedGuest.setLastName(guest.getLastName());
                updatedGuest.setBirthPlace(guest.getBirthPlace());
                updatedGuest.setBirthDate(guest.getBirthDate());
                updatedGuest.setPersonalId(guest.getPersonalId());
                updatedGuest.setEmail(guest.getEmail());
                updatedGuest.setActive(guest.isActive());
                return guestRepository.save(updatedGuest);
            } else {
                throw new RuntimeException("A vendég nem található az adatbázisban.");
            }
        } else {
            return guestRepository.save(guest);
        }
    }

    public List<Guest> getAllGuest(){
        return guestRepository.findAll();
    }

    public List<Guest> getBirthDate(LocalDate date){
        return guestRepository.findByBirthDay(date);
    }
}
