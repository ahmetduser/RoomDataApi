package com.example.lucampusroomdata.controller;


import com.example.lucampusroomdata.model.Room;
import com.example.lucampusroomdata.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lucampus/room")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @RequestMapping(value = "createRoom", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoom(@Validated @RequestBody Room r) throws SQLException {
        service.saveRoom(r);
    }

    @GetMapping()
    public List<Room> fetchRoomList() {
        return service.fetchRoomList();
    }

    @RequestMapping(value = "findRoom/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Room> findRoom(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findRoom(id), HttpStatus.OK);
    }

    @RequestMapping(value = "updateRoom/{id}", method = RequestMethod.PUT, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Room> updateRoom(@RequestBody Room coffee, @PathVariable("id") int id) {
        Room cof = service.updateRoom(coffee, id);

        return new ResponseEntity<>(cof, HttpStatus.OK);
    }

}
