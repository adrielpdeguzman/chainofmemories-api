package io.adrieldg.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "journals",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "publishDate"})})
@Data
public class Journal {
  @ManyToOne
  private User user;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Temporal(TemporalType.DATE)
  private Date publishDate;
  private int volume;
  private int day;
  @Column(length = 17711)
  private String contents;
  @Column(length = 610)
  private String specialEvents;

  private LocalDateTime created;
  private LocalDateTime modified;

  public Journal(User user, Date publishDate, int volume, int day, String contents,
      String specialEvents) {
    this.user = user;
    this.publishDate = publishDate;
    this.volume = volume;
    this.day = day;
    this.contents = contents;
    this.specialEvents = specialEvents;
  }

  public Journal(int volume, Date publishDate) {
    this.volume = volume;
    this.publishDate = publishDate;
  }

  public Journal(Date publishDate) {
    this.publishDate = publishDate;
  }

  Journal() {}

  @PrePersist
  protected void onCreate() {
    created = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    modified = LocalDateTime.now();
  }
}
