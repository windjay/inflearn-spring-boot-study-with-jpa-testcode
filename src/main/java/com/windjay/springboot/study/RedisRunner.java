package com.windjay.springboot.study;

import com.windjay.springboot.study.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisRunner implements ApplicationRunner {

  @Autowired
  StringRedisTemplate redisTemplate;

  @Autowired
  BookRepository bookRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    ValueOperations<String, String> values = redisTemplate.opsForValue();
//    values.set("hello", "world");
//    values.set("springboot", "2.0");
//    values.set("windjay", "jayjay");
//
//
//    Book book = new Book();
//    book.setEmail("windjay@daum.net");
//    book.setUsername("windjay");
//
//    bookRepository.save(book);
//
//    Optional<Book> byId = bookRepository.findById(book.getId());
//    System.out.println(byId.get().getUsername());
//    System.out.println(byId.get().getEmail());

  }

}
