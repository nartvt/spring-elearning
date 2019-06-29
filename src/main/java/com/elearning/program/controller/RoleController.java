package com.elearning.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.program.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("")
  public Object findNotAdmin() {
    return roleService.findNotAdmin();
  }
}
