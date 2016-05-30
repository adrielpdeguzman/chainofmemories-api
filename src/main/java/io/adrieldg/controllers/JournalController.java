package io.adrieldg.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.adrieldg.repositories.JournalRepository;
import io.adrieldg.services.UserService;

@RestController
@RequestMapping("/journals")
public class JournalController {
	private final JournalRepository journalRepository;
	private Date ANNIVERSARY_DATE;

	@Autowired
	public JournalController(JournalRepository journalRepository, UserService userService,
			@Value("${global.anniversary.date}") String date) {
		this.journalRepository = journalRepository;

		try {
			this.ANNIVERSARY_DATE = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
