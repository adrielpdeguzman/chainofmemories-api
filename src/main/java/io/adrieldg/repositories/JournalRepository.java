package io.adrieldg.repositories;

import java.util.Collection;

import javax.persistence.OrderBy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.adrieldg.entities.Journal;

@RepositoryRestResource(path = "journals")
public interface JournalRepository extends CrudRepository<Journal, Long> {
  @RestResource(path = "byVolume")
  @OrderBy("publishDate ASC")
  Collection<Journal> findByVolumeOrderByPublishDateDesc(@Param("v") Integer volume);

  @RestResource(path = "byContentsAndVolume")
  @OrderBy("publishDate ASC")
  Collection<Journal> findByContentsContainingIgnoreCaseAndVolumeOrderByPublishDateDesc(
      @Param("q") String contents, @Param("v") Integer volume);
}
