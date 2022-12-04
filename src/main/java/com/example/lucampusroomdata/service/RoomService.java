package com.example.lucampusroomdata.service;

import com.example.lucampusroomdata.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    void saveRoom(Room room) throws SQLException;

    List<Room> fetchRoomList();

    Room updateRoom(Room room, int id);

    Room findRoom(int id);
}
