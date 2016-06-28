package io.adrieldg;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.adrieldg.entities.Journal;
import io.adrieldg.entities.User;
import io.adrieldg.repositories.JournalRepository;
import io.adrieldg.repositories.UserRepository;

@SpringBootApplication
public class Application {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository, JournalRepository journalRepository) {
    return (evt) -> {
      User user = userRepository
          .save(new User("test", passwordEncoder.encode("test"), "test@test.test", "Test", "Test"));
      journalRepository
          .save(new Journal(user, new Date(), 1, 1, "Lorem ipsum", "Lorem ipsum"));

      logger.debug("ef051cc8-e730-4036-9bce-2b933bfa9ca1");
    };
  }
}
