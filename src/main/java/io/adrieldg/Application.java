package io.adrieldg;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.adrieldg.entities.Journal;
import io.adrieldg.entities.User;
import io.adrieldg.repositories.JournalRepository;
import io.adrieldg.services.UserService;

@SpringBootApplication
public class Application {
  @Bean
  CommandLineRunner init(UserService userService, JournalRepository journalRepository) {
    return (evt) -> {
      User user =
          userService.registerUser(new User("test", "test", "test@test.test", "Test", "Test"));
      journalRepository.save(new Journal(user, new Date(), 1, 1, "Lorem ipsum", "Lorem ipsum"));
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
