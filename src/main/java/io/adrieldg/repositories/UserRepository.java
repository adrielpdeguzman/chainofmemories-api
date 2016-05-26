package io.adrieldg.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.adrieldg.entities.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
