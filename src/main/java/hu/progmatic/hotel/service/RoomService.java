package hu.progmatic.hotel.service;

import hu.progmatic.hotel.model.Room;
import hu.progmatic.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final  RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    public Room createOrUpdateRoom(Room room) {
        return roomRepository.save(room);
    }


    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
