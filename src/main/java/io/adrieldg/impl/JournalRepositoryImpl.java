package io.adrieldg.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import io.adrieldg.repositories.JournalRepositoryCustom;

public class JournalRepositoryImpl implements JournalRepositoryCustom {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public Map<String, String> getVolumesWithStartDate() {
    Map<String, String> map = new HashMap<>();
    /*Query q = sessionFactory.getCurrentSession().createSQLQuery(
            "select volume, publish_date from journal group by volume order by publish_date asc"
    );
    List list = q.list();
    logger.debug(list.toString());*/
    return map;
  }
}