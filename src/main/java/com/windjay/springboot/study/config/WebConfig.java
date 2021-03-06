package com.windjay.springboot.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//아래의 설정을 하면 안된다......
//@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

  // 리소스핸들러를 cusomize함~~~
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/m/**")
            .addResourceLocations("classpath:/m/")
            .setCachePeriod(20);
  }

  /**
   * CORS 설정
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080");
  }

}
