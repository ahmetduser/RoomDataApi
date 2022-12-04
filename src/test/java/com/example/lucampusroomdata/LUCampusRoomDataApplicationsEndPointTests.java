package com.example.lucampusroomdata;

import com.example.lucampusroomdata.controller.RoomController;
import com.example.lucampusroomdata.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RoomController.class)
public class LUCampusRoomDataApplicationsEndPointTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    RoomService roomService;

//    @Test
//    public void getAllEmployeesAPI() throws Exception
//    {
//        mvc.perform( MockMvcRequestBuilders
//                        .get("/api/v1/lucampus/room")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.room").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.room[*].roomId").isNotEmpty());
//    }
//
//    @Test
//    public void getEmployeeByIdAPI() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .get("/api/v1/lucampus/room/findRoom/{id}", 1)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.roomId").value(1));
//    }

}
