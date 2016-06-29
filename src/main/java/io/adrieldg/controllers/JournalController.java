package io.adrieldg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.adrieldg.repositories.JournalRepository;

@RestController
public class JournalController {

  @Autowired
  JournalRepository journalRepository;

  @RequestMapping(path = "journals/search/getVolumesWithStartDate", method = RequestMethod.GET,
      produces = "application/json")
  String getVolumesWithStartDate() {
    return journalRepository.getVolumesWithStartDate();
  }

  @RequestMapping(path = "journals/search/getDatesWithoutEntry", method = RequestMethod.GET,
          produces = "application/json")
  String getDatesWithoutEntry() {
    return journalRepository.getDatesWithoutEntry();
  }
}
