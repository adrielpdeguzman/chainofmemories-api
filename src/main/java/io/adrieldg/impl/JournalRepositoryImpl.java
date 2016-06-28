package io.adrieldg.impl;


import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.adrieldg.entities.Journal;
import io.adrieldg.repositories.JournalRepositoryCustom;

public class JournalRepositoryImpl implements JournalRepositoryCustom {

  final JsonNodeFactory factory = JsonNodeFactory.instance;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  EntityManager em;

  @Override
  public String getVolumesWithStartDate() {
    ArrayNode json = factory.arrayNode();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Journal> q = cb.createQuery(Journal.class);

    Root<Journal> j = q.from(Journal.class);
    q.multiselect(cb.max(j.get("volume")), cb.min(j.get("publishDate")));
    q.groupBy(j.get("volume"));
    q.orderBy(cb.asc(cb.max(j.get("volume"))), cb.asc(cb.min(j.get("publishDate"))));

    List<Journal> results = em.createQuery(q).getResultList();

    results.forEach((journal) -> {
      ObjectNode child = factory.objectNode();
      child.put("volume", journal.getVolume());
      child.put("publishDate", new SimpleDateFormat("MMMMM''yy").format(journal.getPublishDate()));
      json.add(child);
    });

    return json.toString();
  }
}
