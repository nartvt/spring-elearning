package com.elearning.program.admin.controller;

import java.util.HashMap;
import java.util.Map;

import com.elearning.program.dto.UserDTO;
import com.elearning.program.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  private UserService userServiceImpl;
  
  @PostMapping("register")
  public Object register(@Validated @RequestBody UserDTO user ,BindingResult errors) {
    Map<String, String> map = new HashMap<String,String>();
    if(errors.hasErrors()) {
      map.put("success","false");
      map.put("message","Thong Tin dang nhap chua chinh xac");
      return map;
    }
    if(userServiceImpl.save(user)) {
      map.put("success","true");
      map.put("message","Dang Ky Thanh Cong");
      return map;
    }
    map.put("success","false");
    map.put("message","Dang Ky That Bai");
    return map;
  }
}
