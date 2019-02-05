package com.windjay.springboot.study.movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 슬라이싱 테스트... 좋네...
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class MovieRepositoryTest {

  @Autowired
  MovieRepository repository;

  @Test
  public void findByEmail() {
    Movie movie = new Movie();
    movie.setUsername("windjay");
    movie.setEmail("windjay@duam.net");
    repository.save(movie);

    Optional<Movie> byId = repository.findById(movie.getId());
    assertThat(byId).isNotEmpty();

    Optional<Movie> byEmail = repository.findByEmail(movie.getEmail());
    assertThat(byEmail).isNotEmpty();
    assertThat(byEmail.get().getUsername()).isEqualToIgnoringCase("windjay");

  }
}