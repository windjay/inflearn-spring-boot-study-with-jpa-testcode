package com.windjay.springboot.study.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {


  @Autowired
  WebTestClient webTestClient;

  @MockBean
  SampleService mockSampleService;

  @Test
  public void hello2() throws Exception {
    when(mockSampleService.getName()).thenReturn("windjay");

    webTestClient.get().uri("/sample_hello").exchange().expectStatus().isOk()
            .expectBody(String.class).isEqualTo("hello windjay");
  }

}
