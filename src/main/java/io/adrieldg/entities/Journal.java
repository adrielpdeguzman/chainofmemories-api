package io.adrieldg.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "journals",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "publishDate"})})
@Data
public class Journal {
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @Id
  @GeneratedValue
  private Long id;
  private Date publishDate;
  private int volume;
  private int day;
  private String contents;
  private String specialEvents;
  
  public Journal() {}
  
  public Journal(User user, Date publishDate, int volume, int day, String contents,
      String specialEvents) {
    this.user = user;
    this.publishDate = publishDate;
    this.volume = volume;
    this.day = day;
    this.contents = contents;
    this.specialEvents = specialEvents;
  }
}
