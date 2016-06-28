package io.adrieldg.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.adrieldg.entities.Journal;
import io.adrieldg.repositories.JournalRepositoryCustom;

public class JournalRepositoryImpl implements JournalRepositoryCustom {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  @Override
  public Map<Integer, Date> getVolumesWithStartDate() {
    Map<Integer, Date> map = new HashMap<>();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Journal> q = cb.createQuery(Journal.class);

    Root<Journal> j = q.from(Journal.class);
    q.multiselect(cb.max(j.get("volume")), cb.min(j.get("publishDate")));
    q.groupBy(j.get("volume"));
    q.orderBy(cb.asc(cb.max(j.get("volume"))), cb.asc(cb.min(j.get("publishDate"))));

    List<Journal> results = em.createQuery(q).getResultList();

    results.forEach((journal) -> {
      map.put(journal.getVolume(), journal.getPublishDate());
    });

    return map;
  }
}
