package io.adrieldg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.adrieldg.entities.User;
import io.adrieldg.services.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  // @RequestMapping(path = "/users", method = RequestMethod.POST)
  User save(@RequestBody User user) {
    return userService.registerUser(user);
  }
}
