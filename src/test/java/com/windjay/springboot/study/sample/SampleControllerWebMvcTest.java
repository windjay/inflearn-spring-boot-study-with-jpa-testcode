package com.windjay.springboot.study.sample;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerWebMvcTest {

  @MockBean
  SampleService sampleService;

  @Autowired
  MockMvc mockMvc;

  //화면에 출력된 내요을 캡쳐해주는 ... 재밌는 녀석이구만..
  @Rule
  public OutputCapture outputCapture = new OutputCapture();


  @Test
  public void hello2() throws Exception {
    when(sampleService.getName()).thenReturn("windjay");

    mockMvc.perform(MockMvcRequestBuilders.get("/sample_hello")).andExpect(MockMvcResultMatchers.content().string("hello windjay"));

    Assertions.assertThat(outputCapture.toString()).contains("windjay").contains("skip");
  }

}
