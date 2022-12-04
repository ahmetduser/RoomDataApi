package com.example.lucampusroomdata.service;

import com.example.lucampusroomdata.model.Room;
import com.example.lucampusroomdata.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repo;

    public RoomServiceImpl(RoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public void saveRoom(Room room) throws SQLException {
        repo.saveRoom(room);
    }

    @Override
    public List<Room> fetchRoomList() {
        return repo.fetchAllRooms();
    }

    @Override
    public Room updateRoom(Room room, int id) {
        return repo.updateRoom(room, id).get();
    }

    @Override
    public Room findRoom(int id) {
        return repo.findRoom(id).get();
    }
}
