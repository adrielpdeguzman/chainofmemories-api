package io.adrieldg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.adrieldg.entities.User;
import io.adrieldg.services.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  // @RequestMapping(path = "/users", method = RequestMethod.POST)
  ResponseEntity<User> save(@RequestBody User user) {
    return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
  }
}
