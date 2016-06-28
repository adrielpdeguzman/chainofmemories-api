package io.adrieldg.repositories;

import java.util.Date;
import java.util.Map;

public interface JournalRepositoryCustom {
  public Map<Integer, Date> getVolumesWithStartDate();
}