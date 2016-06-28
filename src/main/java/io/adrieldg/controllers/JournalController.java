package io.adrieldg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import io.adrieldg.repositories.JournalRepository;

@RestController
public class JournalController {

  @Autowired
  JournalRepository journalRepository;

  @RequestMapping(path = "journals/getVolumesWithStartDate", method = RequestMethod.GET)
  ResponseEntity<Map> getVolumesWithStartDate() {;
    return new ResponseEntity<Map>(journalRepository.getVolumesWithStartDate(), HttpStatus.OK);
  }
}
