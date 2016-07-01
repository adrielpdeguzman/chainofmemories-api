package io.adrieldg.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.adrieldg.entities.Journal;

@RepositoryRestResource(path = "journals")
public interface JournalRepository
    extends PagingAndSortingRepository<Journal, Long>, JournalRepositoryCustom {
  @RestResource(path = "findByVolume")
  Collection<Journal> findByVolumeOrderByPublishDateAsc(@Param("v") Integer volume);

  @RestResource(path = "findByContentsAndVolume")
  Collection<Journal> findByContentsContainingIgnoreCaseAndVolumeOrderByPublishDateDesc(
      @Param("q") String contents, @Param("v") Integer volume);

  @RestResource(path = "findByContents")
  Collection<Journal> findByContentsContainingIgnoreCaseOrderByPublishDateDesc(
      @Param("q") String contents);

  @Query(value = "select * from journals order by rand() limit 1", nativeQuery = true)
  Journal findRandom();

  @Query(value = "select volume from journals order by volume desc limit 1", nativeQuery = true)
  Integer getCurrentVolume();
}
