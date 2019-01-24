package com.windjay.springboot.boottest.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TemplateController.class)
public class TemplateControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void hello() throws Exception {

    // 요청 "/template_hello"
    // 응답
    // - 모델 name: windjay
    // - 뷰 : hello.html


    mockMvc.perform(get("/template_hello"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(view().name("hello"))
            .andExpect(model().attribute("name", is("windjay")))
            .andExpect(xpath("//h1").string("windjay")) // xml path
            .andExpect(content().string(containsString("windjay")));
  }
}
