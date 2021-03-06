package io.adrieldg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.adrieldg.entities.User;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @HandleBeforeCreate
  public void handleUserCreate(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
  }

}
