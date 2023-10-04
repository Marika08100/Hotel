package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    public Guest creatOrUpdateGuest(Guest guest){
        return guestRepository.save(guest);
    }
    public List<Guest> getAllGuest(){
        return guestRepository.findAll();
    }
}
