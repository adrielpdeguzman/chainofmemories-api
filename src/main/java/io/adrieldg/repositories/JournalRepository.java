package io.adrieldg.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.adrieldg.entities.Journal;

@RepositoryRestResource(path = "journals")
public interface JournalRepository extends CrudRepository<Journal, Long> {
	Collection<Journal> findByUserUsername(String username);
}
