package com.elearning.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

  @GetMapping("profile")
  public String profile() {
    return "userProfile";
  }

  @GetMapping("course")
  public String course() {
    return "userCourse";
  }
}
