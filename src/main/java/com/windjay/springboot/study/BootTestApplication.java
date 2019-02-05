package com.windjay.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

