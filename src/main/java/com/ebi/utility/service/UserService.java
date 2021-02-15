package com.ebi.utility.service;

import com.ebi.utility.domain.User;
import com.ebi.utility.dto.UserDTO;
import com.ebi.utility.dto.common.RestResponse;

import java.util.List;
import java.util.Optional;

/**
 * @author Harshal Patil
 */
public interface UserService {

    /**
     * Method to add batch of users
     * @param users
     * @return
     */
    Optional<RestResponse> addUsers(List<UserDTO> users);

    /**
     * Method to add user
     * @param users
     * @return
     */
    Optional<RestResponse> addUser(UserDTO users);

    /**
     * Method to get users
     * @return
     */
    Optional<RestResponse> getUsers();

    /**
     * Get User by Id
     * @param id
     * @return
     */
    Optional<RestResponse> getUser(Long id);

    /**
     * Method to delete user by id
     * @param id
     * @return
     */
    Optional<RestResponse> deleteUser(Long id);

    /**
     * Method to update user by id
     * @param users
     * @return
     */
    Optional<RestResponse> updateUser(Long id, UserDTO users);
}
