package com.windjay.springboot.boottest.template;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TemplateController.class)
public class TemplateControllerHtmlUnitTest {

  @Autowired
  WebClient webClient;

  @Test
  public void hello() throws Exception {

    // 요청 "/template_hello"
    // 응답
    // - 모델 name: windjay
    // - 뷰 : hello.html


//    mockMvc.perform(get("/template_hello"))
//            .andExpect(status().isOk())
//            .andDo(print())
//            .andExpect(view().name("hello"))
//            .andExpect(model().attribute("name", is("windjay")))
//            .andExpect(xpath("//h1").string("windjay")) // xml path
//            .andExpect(content().string(containsString("windjay")));

      HtmlPage page = webClient.getPage("/template_hello");
      HtmlHeading1 h1 = page.getFirstByXPath("//h1");
      assertThat(h1.getTextContent()).isEqualToIgnoringCase("windjay");

  }
}
