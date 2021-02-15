package com.ebi.utility.service.impl;

import com.ebi.utility.domain.User;
import com.ebi.utility.dto.UserDTO;
import com.ebi.utility.dto.common.RestResponse;
import com.ebi.utility.repository.UserRepository;
import com.ebi.utility.service.UserService;
import com.ebi.utility.util.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Harshal Patil
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransformer userTransformer;

    /**
     * Method to add batch of users
     * @param usersDTO
     * @return list of userDTO
     */
    public Optional<RestResponse> addUsers(List<UserDTO> usersDTO) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            List<User> users = userTransformer.toEntityList(usersDTO);
            users = userRepository.saveAll(users);
            restResponse.addData("users", userTransformer.toDtoList(users));
        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Method to add user
     * @param userDTO
     * @return userDTO
     */
    public Optional<RestResponse> addUser(UserDTO userDTO) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            User user = userTransformer.toEntity(userDTO);
            user = userRepository.save(user);
            restResponse.addData("user", userTransformer.toDto(user));
        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Method to get users
     * @return list of userDTO
     */
    public Optional<RestResponse> getUsers() {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            List<User> users = userRepository.findAll();
            if(users.isEmpty())
                restResponse.setMessage("no users found");
            restResponse.addData("users", userTransformer.toDtoList(users));
        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Method to get User by Id
     * @param id
     * @return Optional<RestResponse>
     */
    public Optional<RestResponse> getUser(Long id) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            Optional<User> userOptional = userRepository.findById(id);

            if(userOptional.isPresent()) {
                restResponse.addData("updatedUser", userTransformer.toDto(userOptional.get()));
                restResponse.setMessage("user updated!");
            } else {
                restResponse.setMessage("user not found!");
            }
        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Method to update existing user
     * @param id
     * @param userDTO
     * @return
     */
    public Optional<RestResponse> updateUser(Long id, UserDTO userDTO) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            Optional<User> userOptional = userRepository.findById(id);

            if(userOptional.isPresent()) {
                User user = updateExistingUser(userDTO, userOptional);
                user = userRepository.save(user);
                restResponse.addData("updatedUser", userTransformer.toDto(user));
                restResponse.setMessage("user updated!");
            } else {
                restResponse.setMessage("user not found!");
            }

        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Method to delete user by id
     * @param id
     * @return RestResponse
     */
    public Optional<RestResponse> deleteUser(Long id) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        try {
            userRepository.deleteById(id);
            restResponse.setMessage("User deleted successfully!");
        } catch (Exception e) {
            restResponse.setSuccess(false);
            restResponse.setError(e.getMessage(), "500");
            restResponse.setMessage("Something went wrong");
            return Optional.of(restResponse);
        }
        return Optional.of(restResponse);
    }

    /**
     * Update existing user
     * @param userDTO
     * @param userOptional
     * @return
     */
    private User updateExistingUser(UserDTO userDTO, Optional<User> userOptional) {
        User user = userOptional.get();
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setAge(userDTO.getAge());
        user.setFavourite_colour(userDTO.getFavourite_colour());
        return user;
    }
}
