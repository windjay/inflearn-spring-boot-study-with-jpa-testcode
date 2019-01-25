package com.windjay.springboot.boottest;

import com.windjay.springboot.boottest.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootApplication
public class BootTestApplication {

/*
  @Autowired
  MongoTemplate template;

  @Autowired
  MongoRepository repository;
*/

  public static void main(String[] args) {
    SpringApplication.run(BootTestApplication.class, args);
  }

/*  @Bean
  public ApplicationRunner applicationRunner() {
    return args -> {
      Movie movie = new Movie();
      movie.setEmail("windjay@daum.net");
      movie.setUsername("windjay");
//      template.insert(movie);
      repository.save(movie);

      System.out.println("finishied");
    };
  }*/

}

