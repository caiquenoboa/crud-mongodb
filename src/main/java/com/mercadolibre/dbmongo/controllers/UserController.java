package com.mercadolibre.dbmongo.controllers;

import com.mercadolibre.dbmongo.dtos.UserDTO;
import com.mercadolibre.dbmongo.dtos.UserRequestUpdateLogin;
import com.mercadolibre.dbmongo.dtos.UserRequestUpdatePassword;
import com.mercadolibre.dbmongo.dtos.UserResponse;
import com.mercadolibre.dbmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @PutMapping("/login")
    public ResponseEntity<UserResponse> updateUserLogin(@RequestBody UserRequestUpdateLogin userRequestUpdateLogin){
        return ResponseEntity.ok(userService.updateUserLogin(userRequestUpdateLogin.getId(), userRequestUpdateLogin.getLogin()));
    }

    @PutMapping("/password")
    public ResponseEntity<UserResponse> updateUserPassword(@RequestBody UserRequestUpdatePassword userRequestUpdatePassword){
        return ResponseEntity.ok(userService.updateUserPassword(userRequestUpdatePassword.getId(), userRequestUpdatePassword.getPassword()));
    }

}
