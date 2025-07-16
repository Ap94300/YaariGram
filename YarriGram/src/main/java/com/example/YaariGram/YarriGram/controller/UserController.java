package com.example.YaariGram.YarriGram.controller;

import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws UserException {
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) throws UserException {
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/users/{userIds}")
    public ResponseEntity<List<User>> findUserByUserIds(@PathVariable List<Long> userIds) throws UserException {
        List<User> users = userService.findUserByIds(userIds);
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUserHandler(@RequestParam("q") String query) throws UserException {
        List<User> users = userService.searchUser(query);
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);

    }
}

