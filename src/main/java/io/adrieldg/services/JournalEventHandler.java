package io.adrieldg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.adrieldg.entities.Journal;
import io.adrieldg.repositories.UserRepository;

@Component
@RepositoryEventHandler(Journal.class)
public class JournalEventHandler {
  @Autowired
  private UserRepository userRepository;

  @HandleBeforeCreate
  public void handleJournalCreate(Journal journal) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    journal.setUser(userRepository.findByUsername(auth.getName()));
  }
}
