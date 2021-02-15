package com.ebi.utility.controller;

import com.ebi.utility.domain.User;
import com.ebi.utility.dto.InputDTO;
import com.ebi.utility.dto.UserDTO;
import com.ebi.utility.dto.common.RestResponse;
import com.ebi.utility.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Harshal Patil
 */
@RestController
@RequestMapping(value = "/ebi/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * API to add multiple users in db
     * @param person
     * @return
     */
    @PostMapping
    public ResponseEntity<RestResponse> addPerson(@RequestBody InputDTO person) {
        RestResponse restResponse = userService.addUsers(person.getData()).orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.OK;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to get list of user
     * @return
     */
    @GetMapping(value = "/list")
    public ResponseEntity<RestResponse> getUsers() {
        RestResponse restResponse = userService.getUsers().orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.OK;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to add user
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity<RestResponse> addUser(@RequestBody UserDTO userDTO) {
        RestResponse restResponse = userService.addUser(userDTO).orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.OK;
        return new ResponseEntity<>(restResponse, status);
    }

}
