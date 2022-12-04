package com.example.lucampusroomdata.repository;

import com.example.lucampusroomdata.model.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {
    private Connection con = null;
    @Value("${spring.datasource.url}")
    String dbUrl;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;


    private Connection getDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return con;
    }

    // TODO delete id from sql insert stat
    public void saveRoom(Room room) throws SQLException {
        String create = "INSERT INTO room (id, roomNumber, capacity, floor) " +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement stm = getDBConnection().prepareStatement(create);

        stm.setLong(1, room.getId());
        stm.setString(2, room.getRoomNumber());
        stm.setInt(3, room.getCapacity());
        stm.setInt(4, room.getFloor());
        stm.executeUpdate();
    }

    public List<Room> fetchAllRooms() {
        List<Room> roomList = new ArrayList<>();
        Room room;
        String selectAll = "SELECT * FROM room";

        try {
            Statement stm = getDBConnection().createStatement();
            ResultSet rs = stm.executeQuery(selectAll);

            while (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("roomNumber"));
                room.setCapacity(rs.getInt("capacity"));
                room.setFloor(rs.getInt("floor"));
                roomList.add(room);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomList;
    }

    public Optional<Room> findRoom(int id) {
        Optional<Room> ro = Optional.empty();
        String find = "SELECT * FROM room WHERE id = " + id;
        Room room = new Room();

        try {
            Statement stm = getDBConnection().createStatement();
            ResultSet rs = stm.executeQuery(find);

            while (rs.next()) {
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("roomNumber"));
                room.setCapacity(rs.getInt("capacity"));
                room.setFloor(rs.getInt("floor"));

                ro = Optional.of(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ro;
    }

    public Optional<Room> updateRoom(Room room, int id) {
        Optional<Room> ro = findRoom(id);

        String update = "UPDATE room SET id = ?, roomNumber = ?, capacity = ?, floor = ? WHERE id = ?";

        if (!ro.isPresent()) {
            ro = Optional.empty();
            return ro;
        }

        try {
            PreparedStatement stm = getDBConnection().prepareStatement(update);
            stm.setLong(1, id);
            stm.setString(2, room.getRoomNumber());
            stm.setInt(3, room.getCapacity());
            stm.setInt(4, room.getFloor());
            stm.setLong(5, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ro;
    }
}
