package io.adrieldg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
  @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
  private Set<Journal> journals = new HashSet<Journal>();
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String username;
  @JsonIgnore
  private String password;
  @Column(unique = true)
  private String email;
  private String firstName;
  private String lastName;

  public User(String username, String password, String email,
      String firstName, String lastName) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
