package com.example.demo.graduate;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

/*Variables*/
@Entity
@Table
public class Graduate {
  @Id
  @SequenceGenerator(name = "graduate_sequence", sequenceName = "graduate_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graduate_sequence")
  private Long id;
  private String name;
  private String email;
  private LocalDate dob;
  @Transient //No need for age to be a column in the database
  private Integer age;

  /*Constructors*/
  public Graduate() {
  }

  public Graduate(Long id, String name, String email, LocalDate dob) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  public Graduate(String name, String email, LocalDate dob) {
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  /*Getters and Setters*/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  /*To String*/
  @Override
  public String toString() {
    return "Graduate{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", dob=" + dob + ", age="
        + age + '}';
  }
}



