package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    public Guest creatOrUpdateGuest(Guest guest) throws NotActiveException {
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
                throw new NotActiveException();
            }
        } else {
            return guestRepository.save(guest);
        }
    }
    public List<Guest> getAllGuest(){
        return guestRepository.findAll();
    }
}
