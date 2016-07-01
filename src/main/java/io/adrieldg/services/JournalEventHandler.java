package io.adrieldg.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private UserRepository userRepository;

  @Value("${global.anniversary}")
  private String anniversary;

  @HandleBeforeCreate
  public void handleJournalCreate(Journal journal) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    LocalDate publishDate =
        journal.getPublishDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate anniversaryDate =
        LocalDate.parse(this.anniversary, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    if (publishDate.isBefore(anniversaryDate)) {
      journal.setDay((int) ChronoUnit.DAYS.between(publishDate, anniversaryDate) * -1);
      journal.setVolume(1);
    } else {
      journal.setVolume((int) ChronoUnit.MONTHS.between(anniversaryDate, publishDate) + 2);
      journal.setDay((int) ChronoUnit.DAYS.between(anniversaryDate, publishDate) + 1);
    }
    journal.setUser(userRepository.findByUsername(auth.getName()));
  }
}
