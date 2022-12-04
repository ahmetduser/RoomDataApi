package com.example.lucampusroomdata;

import com.example.lucampusroomdata.model.Room;
import com.example.lucampusroomdata.repository.RoomRepository;
import com.example.lucampusroomdata.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class LuCampusRoomDataApplicationTests {

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository roomRepository;

    @BeforeEach
    public void init() {

        Room room = new Room(1, "123", 12, 1);

        Mockito.when(roomRepository.findRoom(room.getId()))
                .thenReturn(Optional.of(room));
    }

    @Test
    public void whenValidId_thenRoomShouldBeFound() {

        int id = 1;
        Room found = roomService.findRoom(id);

        assertThat(found.getRoomNumber())
                .isEqualTo("123");
    }

}
