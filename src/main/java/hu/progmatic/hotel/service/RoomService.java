package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Guest;
import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    public Room createOrUpdateRoom(Room room) {
        return roomRepository.save(room);
    }


}
