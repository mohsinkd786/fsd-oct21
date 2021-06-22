package com.mohsinkd786.controllers;

import com.mohsinkd786.dtos.UserDto;
import com.mohsinkd786.dtos.UserResponse;
import com.mohsinkd786.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {


    // injection
    // by type
    // by name

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public boolean createUser(@RequestBody UserDto userDto){
        // add the user sent in body
        return userService.createUser(userDto);
    }

    // http://localhost:9191/users/3

    @DeleteMapping("{id}")
    public ResponseEntity<UserResponse> removeUser(@PathVariable String id){
        UserResponse response = new UserResponse();
        try {
            userService.removeUser(id);
            response.setStatus(true);
            response.setMessage("User deleted successfully");
            return  ResponseEntity.ok(response);

        }catch (Exception ex){
            response.setStatus(false);
            response.setError("Invalid User details specified");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateEmailById(@RequestBody String email, @PathVariable String id){
        return ResponseEntity.ok(userService.updateUserEmail(email,id));
    }
}
