package io.adrieldg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Entity
@Table(name = "users")
@Data
@ToString(exclude = "password")
public class User {
  @OneToMany(mappedBy = "user")
  @JsonBackReference
  private Set<Journal> journals = new HashSet<>();
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String username;
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  @JsonIgnore
  private String password;
  @Column(unique = true)
  private String email;
  private String firstName;
  private String lastName;

  public User(String username, String password, String email, String firstName, String lastName) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  User() {

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
