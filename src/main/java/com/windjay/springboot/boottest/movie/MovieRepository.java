package com.windjay.springboot.boottest.movie;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
  Optional<Movie> findByEmail(String email);
}
