package io.adrieldg.impl;


import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import io.adrieldg.entities.Journal;
import io.adrieldg.repositories.JournalRepositoryCustom;
import io.adrieldg.repositories.UserRepository;

public class JournalRepositoryImpl implements JournalRepositoryCustom {

  final JsonNodeFactory factory = JsonNodeFactory.instance;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  EntityManager em;
  @Autowired
  UserRepository userRepository;

  @Value("${global.anniversary}")
  private String anniversary;

  @Override
  public String getVolumesWithStartDate() {
    ArrayNode volumesWithStartDate = factory.arrayNode();

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
      volumesWithStartDate.add(child);
    });

    return volumesWithStartDate.toString();
  }

  @Override
  public String getDatesWithoutEntry() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    ArrayNode datesWithoutEntry = factory.arrayNode();
    LocalDate anniversaryDate = LocalDate.parse(this.anniversary, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    long days = ChronoUnit.DAYS.between(anniversaryDate, LocalDate.now());

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Journal> q = cb.createQuery(Journal.class);

    Root<Journal> j = q.from(Journal.class);
    q.multiselect(j.get("publishDate"));
    q.where(cb.equal(j.get("user"), userRepository.findByUsername(auth.getName())));
    q.orderBy(cb.desc(j.get("publishDate")));

    List<Journal> results = em.createQuery(q).getResultList();

    for (long i=days; i >= 0; i--) {
      LocalDate d = anniversaryDate.plusDays(i);
      if (!results.contains(d)) {
        datesWithoutEntry.add(d.toString());
      }
    }

    return datesWithoutEntry.toString();
  }
}
