package org.example.controller;

import org.example.dto.UserDto;
import org.example.exception.UserNotFoundException;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService service;
    ResponseEntity responseEntity;

    @PutMapping("/users/{id}&{address}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> updateUserAddress(@PathVariable Long id, @PathVariable String address) {
        try {
            responseEntity = new ResponseEntity(service.updateAddress(id, address), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        try {
            responseEntity = new ResponseEntity(service.saveUser(userDto), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(service.deleteUser(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> allUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(service.getUserById(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/users/name={name}&email={email}")
    public ResponseEntity<UserDto> getUserByNameAndEmail(@PathVariable String name, @PathVariable String email) {
        try {
            responseEntity = new ResponseEntity(service.getUserByNameAndEmail(name, email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @PutMapping("/users/activity")
    public ResponseEntity changeStatus(){
        return new ResponseEntity(service.changeActiveStatus(), HttpStatus.OK);
    }
}
