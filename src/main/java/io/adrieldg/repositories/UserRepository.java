package io.adrieldg.repositories;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.adrieldg.entities.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends Repository<User, Long> {
	User save(User user);

	User findOne(Long id);

	User findByUsername(String username);
}