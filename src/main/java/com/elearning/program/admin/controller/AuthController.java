package com.elearning.program.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.program.dto.RegisterDTO;
import com.elearning.program.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  private UserService userServiceImpl;
  
  @PostMapping("register")
  public Object register(@Validated @RequestBody RegisterDTO user ,BindingResult errors) {
    Map<String, String> map = new HashMap<String,String>();
    if(errors.hasErrors()) {
      map.put("success","false");
      map.put("message","Thong Tin dang nhap chua chinh xac");
    }
    if(userServiceImpl.save(user)) {
      map.put("success","true");
      map.put("message","Dang Ky Thanh Cong");
    }
    map.put("success","false");
    map.put("message","Dang Ky That Bai");
    return map;
  }
}
