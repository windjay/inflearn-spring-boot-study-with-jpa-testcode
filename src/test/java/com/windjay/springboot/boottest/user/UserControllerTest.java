package com.windjay.springboot.boottest.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void hello() throws Exception {
    mockMvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("hello"));
  }

  @Test
  public void createUser_JSON() throws Exception {
    // 아래의 문자열 따옴표를 잘못 입력해서 오류가 생겼구만...
    String userJson = "{\"username\" : \"windjay\", \"password\": \"123\"}";
    mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .content(userJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is(equalTo("windjay"))))
            .andExpect(jsonPath("$.password", is(equalTo("123"))));

  }

  @Test
  public void createUser_XML() throws Exception {
    // 아래의 문자열 따옴표를 잘못 입력해서 오류가 생겼구만...
    String userJson = "{\"username\" : \"windjay\", \"password\": \"123\"}";
    mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_XML)
            .content(userJson))
            .andExpect(status().isOk())
            .andExpect(xpath("/User/username").string("windjay"))
            .andExpect(xpath("/User/password").string("123"));

  }

}
