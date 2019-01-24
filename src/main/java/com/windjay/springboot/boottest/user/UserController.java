package com.windjay.springboot.boottest.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @PostMapping("/users/create")
  public User create(@RequestBody User user) {
    System.out.println(user);
    return user;
  }

}
