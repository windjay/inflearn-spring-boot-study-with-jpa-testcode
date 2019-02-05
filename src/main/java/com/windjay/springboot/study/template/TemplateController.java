package com.windjay.springboot.study.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

  /**
   * 아래는 모델을 담은 뷰를 리턴한다.
   * @param model
   * @return
   */
  @GetMapping("template_hello")
  public String hello(Model model) {
    model.addAttribute("name", "windjay");
    return "hello";
  }

}
