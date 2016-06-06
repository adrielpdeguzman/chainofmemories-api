package io.adrieldg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
public class User {
  @OneToMany(mappedBy = "user")
  private Set<Journal> journals = new HashSet<Journal>();
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String username;
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private String password;
  @Column(unique = true)
  private String email;
  private String firstName;
  private String lastName;

  public User() {}

  public User(String username, String password, String email, String firstName, String lastName) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @JsonIgnore
  public String getPassword() {
    return password;
  }

  @JsonProperty
  public void setPassword(String password) {
    this.password = password;
  }
}
