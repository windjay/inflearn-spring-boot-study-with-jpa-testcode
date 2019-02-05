package com.windjay.springboot.study.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * 아래는 슬라이싱 테스트이다..
 *
 * @SpringBootTest 어노테이션을 쓰면... 전체 인티그레이션 테스트인데...
 * 그경우는 느리고.. 테스트용 DB가 필요하다....
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  AccountRepository accountRepository;

  /**
   * 슬라이스 테스트시는 인메모리 DB가  필요하다..
   * H2 디비를 의존성에 추가해야 한다.
   */
  @Test
  public void di() throws SQLException {
    try (Connection connection = dataSource.getConnection();) {
      DatabaseMetaData metaData = connection.getMetaData();
      System.out.println(metaData.getURL());
      System.out.println(metaData.getUserName());
      System.out.println(metaData.getDriverName());

    }
  }

  @Test
  public void test() {
    Account account = new Account();
    account.setUsername("windjay");
    account.setPassword("1234");

    Account newAccount = accountRepository.save(account);

    assertThat(newAccount).isNotNull();

    Account account1 = accountRepository.findByUsername(newAccount.getUsername());
    assertThat(account1).isNotNull();

    Account account2 = accountRepository.findByUsername("windjay2");
    assertThat(account2).isNull();
  }

}