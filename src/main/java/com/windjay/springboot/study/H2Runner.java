package com.windjay.springboot.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class H2Runner implements ApplicationRunner {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try (Connection connection = dataSource.getConnection();) {

      System.out.println(connection.getMetaData().getURL());
      System.out.println(connection.getMetaData().getUserName());

//      Statement stmt = connection.createStatement();
//      String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY(ID))";
//      stmt.executeUpdate(sql);
//
//      jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'windjay')");

    }
  }
}
