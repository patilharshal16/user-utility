package com.ebi.utility.controller;


import com.ebi.utility.dto.UserDTO;
import com.ebi.utility.dto.common.RestResponse;
import com.ebi.utility.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

@SpringBootTest
public class UserControllerTests {

    @Mock
    private UserService userService;

    private MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new UserController()).build();;

    @Test
    public void testGetUserList()
            throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/ebi/user/list")
                .accept(MediaType.ALL)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
    }

    @Test
    public void testCreateUser() {
        UserDTO userDTO = getMockUser();

        Optional<RestResponse> restResponse = userService.addUser(userDTO);

        Assertions.assertNotNull(restResponse);
        Assertions.assertEquals(Optional.empty(), restResponse);
    }

    private UserDTO getMockUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirst_name("Harshal");
        userDTO.setLast_name("Patil");
        userDTO.setAge("30");
        userDTO.setFavourite_colour("Yellow");
        return userDTO;
    }
}
