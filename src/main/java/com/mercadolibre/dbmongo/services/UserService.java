package com.mercadolibre.dbmongo.services;

import com.mercadolibre.dbmongo.dtos.UserDTO;
import com.mercadolibre.dbmongo.dtos.UserResponse;
import com.mercadolibre.dbmongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    public UserResponse findUserById(String id) {
        return new UserResponse(userRepository.findById(id).get());
    }

    public UserResponse createUser(UserDTO userDTO) {
        return new UserResponse(userRepository.save(userDTO));
    }

    public UserResponse deleteUserById(String id) {
        UserResponse userResponse = findUserById(id);
        userRepository.deleteById(id);
        return userResponse;
    }

    public UserResponse updateUserLogin(String id, String login) {
        UserDTO userDTO1 = userRepository.findById(id).get();
        userDTO1.setLogin(login);
        UserResponse userResponse = new UserResponse(userDTO1);
        userRepository.save(userDTO1);
        return userResponse;
    }

    public UserResponse updateUserPassword(String id, String password){
        UserDTO userDTO1 = userRepository.findById(id).get();
        UserResponse userResponse = new UserResponse(userDTO1);
        userDTO1.setPassword(password);
        userRepository.save(userDTO1);
        return userResponse;
    }

}
