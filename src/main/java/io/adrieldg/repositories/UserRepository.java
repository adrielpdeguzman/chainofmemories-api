package io.adrieldg.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.adrieldg.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
