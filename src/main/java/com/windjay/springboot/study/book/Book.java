package com.windjay.springboot.study.book;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("accounts")
public class Book {

  @Id
  private Long id;

  private String username;

  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
