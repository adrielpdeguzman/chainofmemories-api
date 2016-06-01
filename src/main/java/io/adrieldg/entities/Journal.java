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

@Entity
@Table(name = "journals",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "publishDate"})})
public class Journal {
  private User user;
  private Long id;
  private Date publishDate;
  private int volume;
  private int day;
  private String contents;
  private String specialEvents;

  public Journal(User user, Date publishDate, int volume, int day, String contents,
      String specialEvents) {
    this.user = user;
    this.publishDate = publishDate;
    this.volume = volume;
    this.day = day;
    this.contents = contents;
    this.specialEvents = specialEvents;
  }

  Journal() {}

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getSpecialEvents() {
    return specialEvents;
  }

  public void setSpecialEvents(String specialEvents) {
    this.specialEvents = specialEvents;
  }

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Journal [user=" + user + ", id=" + id + ", publishDate=" + publishDate + ", volume="
        + volume + ", day=" + day + ", contents=" + contents + ", specialEvents=" + specialEvents
        + "]";
  }

}
